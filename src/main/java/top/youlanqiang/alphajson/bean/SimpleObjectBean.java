package top.youlanqiang.alphajson.bean;

import top.youlanqiang.alphajson.JSONException;
import top.youlanqiang.alphajson.annotation.JSONOption;
import top.youlanqiang.alphajson.utils.BeanUtil;
import top.youlanqiang.alphajson.utils.CastUtil;
import top.youlanqiang.alphajson.utils.StringUtil;

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
 * @since 1.8
 */
public class SimpleObjectBean<T> implements ObjectBean {



    private T object;


    private Map<String, Method> methodsOfSet = new HashMap<>(10);


    private Map<String, Method> methodsOfGet = new HashMap<>(10);


    private Set<String> ignoreField = new HashSet<>(5);


    private Set<String> serializeField = new HashSet<>(5);


    private Set<String> deserializeField = new HashSet<>(5);


    private Map<String, String> originNames = new HashMap<>(10);

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
            throw new JSONException("Object is none of method.");
        }
    }


    private void methodsInit(final Class clazz) {
        String methodName;
        for (Method method : clazz.getDeclaredMethods()) {
            methodName = method.getName();
            String fieldName = null;
            if (methodName.startsWith(SET) && methodName.length() > 3) {
                fieldName = BeanUtil.methodFieldName(methodName);
                methodsOfSet.put(fieldName, method);
            } else if (methodName.startsWith(IS) && methodName.length() > 2) {
                fieldName = BeanUtil.methodFieldNameForIs(methodName);
                methodsOfGet.put(fieldName, method);
            } else if (methodName.startsWith(GET) && methodName.length() > 3) {
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

                if (!field.isAnnotationPresent(JSONOption.class)) {
                    return;
                }

                JSONOption annotation = field.getAnnotation(JSONOption.class);

                switch (annotation.type()) {
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
                if (!StringUtil.isNullOrEmpty(annotation.name())) {
                    originNames.put(fieldName, annotation.name());
                    originNames.put(annotation.name(), fieldName);
                }
            }
        } catch (NoSuchFieldException e) {
            throw new JSONException(e.getMessage());
        }
    }


    public Class getObjectClass() {
        return object.getClass();
    }


    public Method getMethodOfSet(String fieldName) {
        return getMethod(fieldName, methodsOfSet);
    }


    public Method getMethodOfGet(String fieldName) {
        return getMethod(fieldName, methodsOfGet);
    }


    private Method getMethod(String fieldName, final Map<String, Method> map) {
        if (map.containsKey(fieldName)) {
            Method method = map.get(fieldName);
            method.setAccessible(true);
            return method;
        }
        return null;
    }


    public Set<String> getFieldsOfSet() {
        return methodsOfSet.keySet();
    }


    public Set<String> getFieldsOfGet() {
        return methodsOfGet.keySet();
    }


    public Map<Object, Object> getContainer() {
        Map<Object, Object> container = new HashMap<>(20);
        for (String key : methodsOfGet.keySet()) {
            if (deserializeField.contains(key) || ignoreField.contains(key)) {
                continue;
            }
            try {
                if(originNames.containsKey(key)){
                    key = originNames.get(key);
                }
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
                if(originNames.containsKey(field)){
                    field = originNames.get(field);
                }
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
