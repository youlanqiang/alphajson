package top.youlanqiang.alphajson.bean;

import top.youlanqiang.alphajson.JSONException;
import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.utils.BeanUtil;
import top.youlanqiang.alphajson.utils.CastUtil;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/1
 * @since 1.8
 * ObjectBean的基本实现类
 */
public class  SimpleObjectBean<T> implements ObjectBean {


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


    public SimpleObjectBean(final T object) {
        this.object = object;
        Class clazz = object.getClass();
        methodsInit(clazz);
    }

    public SimpleObjectBean(final Class<T> clazz){
        try {
            this.object = clazz.getConstructor().newInstance(null);
            methodsInit(clazz);
        }catch(Exception e){
            throw new JSONException("对象没有无参构造方法.");
        }
    }

    /**
     * 注入get,set,is方法加载到HashMap中
     * @param clazz 对象的Class类
     */
    private void methodsInit(final Class clazz) {
        String methodName;
        for (Method method : clazz.getDeclaredMethods()) {
            methodName = method.getName();
            if (methodName.startsWith(SET)) {
                methodsOfSet.put(BeanUtil.methodFieldName(methodName), method);
            } else if (methodName.startsWith(IS)) {
                methodsOfGet.put(BeanUtil.methodFieldNameForIs(methodName), method);
            } else if (methodName.startsWith(GET)) {
                methodsOfGet.put(BeanUtil.methodFieldName(methodName), method);
            }
        }
    }

    /**
     * 获取原始对象的Class
     * @return class
     */
    public Class getObjectClass() {
        return object.getClass();
    }

    /**
     * 获取对应字段的Set方法
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
     * @return
     */
    public Set<String> getFieldsOfSet() {
        return methodsOfSet.keySet();
    }

    /**
     * 获取所有的Get,is方法字段名
     * @return
     */
    public Set<String> getFieldsOfGet() {
        return methodsOfGet.keySet();
    }

    /**
     * 将对象转换为JAVABean的Map
     * @return HashMap
     */
    public Map<String, Object> getContainer() {
        Map<String, Object> container = new HashMap<>(20);
        for (String key : methodsOfGet.keySet()) {
            try {
                container.put(key, getMethodOfGet(key).invoke(object, new Object[]{}));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return container;
    }

    /**
     * 将JSONObject转换为同类型对象
     * @param json json字符串
     * @return 同类型对象
     */
    public T injectJSONObject(JSONObject json){
        //TODO 需要将JSON转变为同类型对象
        Set<String> keys =  getFieldsOfSet();
        Method method;
        for(String field : keys){
            method = getMethodOfSet(field);
            try {
                //TODO 泛型BUG
                Type[] types = method.getGenericParameterTypes();
                for (Type type2 : types) {
                    System.out.println(type2);
                    if (type2 instanceof ParameterizedType) {
                        Type[] typetwos = ((ParameterizedType) type2).getActualTypeArguments();
                        for (Type type3 : typetwos) {
                            System.out.println("泛型参数类型" + type3);
                        }
                    }
                }
                method.invoke(object, CastUtil.cast(json.getObject(field), method.getParameterTypes()[0]));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return object;
    }


}
