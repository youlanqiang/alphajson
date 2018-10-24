package top.youlanqiang.alphajson.bean;

import top.youlanqiang.alphajson.utils.BeanUtil;

import java.lang.reflect.Method;
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
public class SimpleObjectBean implements ObjectBean {

    private static final String  GET = "get";

    private static final String  SET = "set";

    private Object object;

    private Map<String,Method> methodsOfSet = new HashMap<>();

    private Map<String,Method> methodsOfGet = new HashMap<>();


    public SimpleObjectBean(Object object){
        this.object = object;
        Class clazz = object.getClass();
        String methodName;

        /**
         * 将object中的get,set方法放入对应的HashMap表中.
         */
        for (Method method : clazz.getDeclaredMethods()) {
            methodName = method.getName();
            if(methodName.startsWith(SET)){
                methodsOfSet.put(BeanUtil.methodFieldName(methodName), method);
            }
            if(methodName.startsWith(GET)){
                methodsOfGet.put(BeanUtil.methodFieldName(methodName), method);
            }
        }


    }

    public Class getObjectClass() {
        return object.getClass();
    }

    public Method getMethodOfSet(String fieldName) {
        if(methodsOfSet.containsKey(fieldName)){
            Method method = methodsOfSet.get(fieldName);
            method.setAccessible(true);
            return method;
        }
        return null;
    }

    public Method getMethodOfGet(String fieldName) {
        if(methodsOfGet.containsKey(fieldName)){
            Method method = methodsOfGet.get(fieldName);
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

    @Override
    public Map<String, Object> getContainer() {
        Map<String, Object> container = new HashMap<>(20);
        for(String key : methodsOfGet.keySet()){
            try {
                container.put(key, getMethodOfGet(key).invoke(object, null));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return container;
    }

    @Override
    public void putAll(Map<String, Object> map) {
        //TODO empty
    }
}
