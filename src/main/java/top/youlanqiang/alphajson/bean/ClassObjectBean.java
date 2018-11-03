package top.youlanqiang.alphajson.bean;

import top.youlanqiang.alphajson.exception.NotJsonFieldException;
import top.youlanqiang.alphajson.utils.BeanUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/3
 * @since 1.8
 * Class对象的bean类型
 */
public class ClassObjectBean implements ObjectBean {



    private Class clazz;

    private Map<String, Method> methodsOfSet;

    public ClassObjectBean(Class clazz){
        this.clazz = clazz;
        this.methodsOfSet = new HashMap<>(20);
        methodsInit(clazz);
    }

    private void methodsInit(Class clazz){
        String methodName;
        /**
         * 将object中的get,set方法放入对应的HashMap表中.
         */
        for (Method method : clazz.getDeclaredMethods()) {
            methodName = method.getName();
            if(methodName.startsWith(SET)){
                methodsOfSet.put(BeanUtil.methodFieldName(methodName), method);
            }
        }
    }


    @Override
    public Class getObjectClass() {
        return clazz;
    }

    @Override
    public Method getMethodOfSet(String fieldName) {
        if(methodsOfSet.containsKey(fieldName)){
            return methodsOfSet.get(fieldName);
        }
        throw new NotJsonFieldException(fieldName);
    }

    @Override
    public Method getMethodOfGet(String fieldName) {
        //nop
        return null;
    }

    @Override
    public Set<String> getFieldsOfSet() {
        return methodsOfSet.keySet();
    }

    @Override
    public Set<String> getFieldsOfGet() {
        //nop
        return null;
    }

    @Override
    public Map<String, Object> getContainer() {
        //nop
        return null;
    }

    @Override
    public void putAll(Map<String, Object> map) {
        //nop
    }
}
