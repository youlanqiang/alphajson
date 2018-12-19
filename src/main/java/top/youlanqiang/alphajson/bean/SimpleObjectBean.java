package top.youlanqiang.alphajson.bean;

import top.youlanqiang.alphajson.JSONException;
import top.youlanqiang.alphajson.annotation.JSONEnable;
import top.youlanqiang.alphajson.utils.BeanUtil;
import top.youlanqiang.alphajson.utils.CastUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/1
 * @since 1.8
 * ObjectBean的基本实现类
 */
public class SimpleObjectBean<T> implements ObjectBean {


    /**
     * 原始Object对象
     */
    private T object;

    /**
     * 对象中的set字段,Map中保存的是对应方法,key为字段名(字段名首字母小写)
     */
    private Map<String, Method> methodsOfSet = new HashMap<>();

    /**
     * 对象中的get字段,Map中保存的是对应方法,key为字段名(字段名首字母小写)
     */
    private Map<String, Method> methodsOfGet = new HashMap<>();

    /**
     * 被忽略的字段
     */
    private Set<String> ignoreField = new HashSet<>(10);

    /**
     * 只能被序列化为JSON的字段
     */
    private Set<String> serializeField = new HashSet<>(10);

    /**
     * 只能被反序列化为JavaBean的字段
     */
    private Set<String> deserializeField = new HashSet<>(10);

    private boolean isEnum = false;


    public SimpleObjectBean(final T object) {
        this.object = object;
        Class clazz = object.getClass();
        methodsInit(clazz);
    }

    public SimpleObjectBean(final Class<T> clazz) {
        try {
            if (clazz.isEnum()) {
                this.isEnum = true;
                methodsInit(clazz);
            } else {
                this.object = clazz.getConstructor().newInstance(null);
                methodsInit(clazz);
            }
        } catch (Exception e) {
            throw new JSONException("对象没有无参构造方法.");
        }
    }

    /**
     * 注入get,set,is方法加载到HashMap中
     *
     * @param clazz 对象的Class类
     */
    private void methodsInit(final Class clazz) {
        String methodName;
        for (Method method : clazz.getDeclaredMethods()) {
            methodName = method.getName();
            String fieldName = null;

            if (methodName.startsWith(SET)) {
                fieldName = BeanUtil.methodFieldName(methodName);
                methodsOfSet.put(fieldName, method);
            } else if (methodName.startsWith(IS)) {
                fieldName = BeanUtil.methodFieldNameForIs(methodName);
                methodsOfGet.put(fieldName, method);
            } else if (methodName.startsWith(GET)) {
                fieldName = BeanUtil.methodFieldName(methodName);
                methodsOfGet.put(fieldName, method);
            }
            fieldEnableType(fieldName, clazz);
        }
    }


    private void fieldEnableType(String fieldName, final Class clazz) {
        try {
            if (fieldName != null) {
                Field field = clazz.getDeclaredField(fieldName);

                if (!field.isAnnotationPresent(JSONEnable.class)) {
                    return;
                }

                JSONEnable annotation = field.getAnnotation(JSONEnable.class);

                switch (annotation.value()) {
                    case Igonre:
                        ignoreField.add(fieldName);
                        break;
                    case Serialize:
                        serializeField.add(fieldName);
                        break;
                    case Deserialize:
                        deserializeField.add(fieldName);
                        break;
                    case Show:
                    default:
                        //do-not
                }
            }
        } catch (NoSuchFieldException e) {

        }
    }

    /**
     * 获取原始对象的Class
     *
     * @return class
     */
    public Class getObjectClass() {
        return object.getClass();
    }

    /**
     * 获取对应字段的Set方法
     *
     * @param fieldName 字段名
     * @return 方法
     */
    public Method getMethodOfSet(String fieldName) {
        if (methodsOfSet.containsKey(fieldName)) {
            Method method = methodsOfSet.get(fieldName);
            method.setAccessible(true);
            return method;
        }
        return null;
    }

    /**
     * 获取对应字段的Get,is方法
     *
     * @param fieldName 字段名
     * @return 方法
     */
    public Method getMethodOfGet(String fieldName) {
        if (methodsOfGet.containsKey(fieldName)) {
            Method method = methodsOfGet.get(fieldName);
            method.setAccessible(true);
            return method;
        }
        return null;
    }

    /**
     * 获取所有的Set方法字段名
     *
     * @return
     */
    public Set<String> getFieldsOfSet() {
        return methodsOfSet.keySet();
    }

    /**
     * 获取所有的Get,is方法字段名
     *
     * @return
     */
    public Set<String> getFieldsOfGet() {
        return methodsOfGet.keySet();
    }

    /**
     * 将对象转换为JAVABean的Map
     *
     * @return HashMap
     */
    public Map<Object, Object> getContainer() {
        Map<Object, Object> container = new HashMap<>(20);
        for (String key : methodsOfGet.keySet()) {
            if (deserializeField.contains(key) || ignoreField.contains(key)) {
                continue;
            }
            try {
                container.put(key, getMethodOfGet(key).invoke(object, new Object[]{}));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return container;
    }


    public T injectJSONObject(Map map) {
        Set<String> keys = getFieldsOfSet();
        Method method;
        for (String field : keys) {
            if (serializeField.contains(field) || ignoreField.contains(field)) {
                continue;
            }
            method = getMethodOfSet(field);
            try {
                method.invoke(object, CastUtil.cast(map.get(field), method.getParameterTypes()[0], getGenerClass(method)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }



    @Override
    public boolean isEnum() {
        return isEnum;
    }

    /**
     * 获取方法参数的泛型类型
     *
     * @param method 方法
     * @return 泛型类型
     */
    private Class[] getGenerClass(final Method method) {
        Type[] types = method.getGenericParameterTypes();
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                Type[] typeArray = ((ParameterizedType) type).getActualTypeArguments();
                if (typeArray.length > 0) {
                    Class[] classes = new Class[typeArray.length];
                    for (int i = 0; i < typeArray.length; i++) {
                        classes[i] = (Class) typeArray[i];
                    }
                    return classes;
                }
            }
        }
        return new Class[]{};
    }


}
