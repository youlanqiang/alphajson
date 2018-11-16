package top.youlanqiang.alphajson.deserialize.json2obj;


import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.debug.Debug;
import top.youlanqiang.alphajson.debug.DebugFactory;
import top.youlanqiang.alphajson.exception.JSONTypeException;
import top.youlanqiang.alphajson.utils.BeanUtil;

import java.lang.reflect.Method;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/5
 * @since 1.8
 * 参数注入类
 */
class ParameterInject {

    static final Debug debug = DebugFactory.getDebug();

    /**
     * 注入
     */
    static <T> void inject(final JSONObject object, final Method method, final T result){

        String paramName = BeanUtil.methodFieldName(method.getName());
        Object param = object.getObjectValue(paramName);
        Class<?>[] clazz = method.getParameterTypes();
        if(clazz.length > 1){
            throw new JSONTypeException("方法不符合JAVABean规范,无法注入参数!");
        }
        Class<?> resultClass = clazz[0];
        debug.info("方法名称:" + method.getName() +
                "参数类型" + resultClass.toString() +
                "参数名称:" + paramName +
                "参数值:" + param );

        try {
            //TODO 需要对数据类型进行判断
            method.invoke(result, tranType(resultClass, param));
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 将result转化为clazz中对应的类型
     * TODO 需要完善
     * @param clazz
     * @param result
     * @return
     */
    private  static Object tranType(final Class<?> clazz, final Object result) throws ClassNotFoundException{
        String className = clazz.getName();
        switch(className){
            case "char":
                return (char) result;
            case "byte":
                Number valueByte = (Number) result;
                return valueByte.byteValue();
            case "short":
                Number valueShort = (Number) result;
                return valueShort.shortValue();
            case "int":
                Number valueInt = (Number)result;
                return  valueInt.intValue();
            case "long":
                Number valueLong = (Number)result;
                return valueLong.longValue();
            case "float":
                Number valueFloat = (Number)result;
                return valueFloat.floatValue();
            case "double":
                Number valueDouble = (Number)result;
                return  valueDouble.doubleValue();
            case "boolean":
                return Boolean.valueOf(result.toString());
            default :
                return Class.forName(className).cast(result);
        }
    }

}
