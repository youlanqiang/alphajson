package top.youlanqiang.alphajson.deserialize.json2obj;

import top.youlanqiang.alphajson.JSONObject;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/5
 * @since 1.8
 * 参数注入类
 */
class ParameterInject {

    /**
     * 注入
     */
    static <T> void inject(final JSONObject object, final Method method, final T result){
        Parameter[] parameters = method.getParameters();
        Object[] params = new Object[parameters.length];
        for(int i = 0; i < parameters.length; i++){
            Parameter param = parameters[i];
            //参数名
            String paramName = param.getName();
            //参数类型
            Class type = param.getType();
            params[i] = object.getObjectValue(paramName, type);
        }
        try {
            //TODO 需要对数据类型进行判断
            method.invoke(result, params);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
