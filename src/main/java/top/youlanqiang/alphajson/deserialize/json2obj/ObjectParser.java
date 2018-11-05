package top.youlanqiang.alphajson.deserialize.json2obj;

import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.bean.ClassObjectBean;
import top.youlanqiang.alphajson.bean.ObjectBean;
import top.youlanqiang.alphajson.exception.NotInstanceFunctionException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/3
 * @since 1.8
 * JSONObject解析器
 *
 */
public class ObjectParser <T> {

    private JSONObject object;

    private Class<T> clazz;

    private ObjectBean bean;

    public ObjectParser(final JSONObject object, final Class<T> clazz){
        this.object = object;
        this.clazz = clazz;
        this.bean = new ClassObjectBean(clazz);
    }

    public JSONObject getObject() {
        return object;
    }


    public Class<T> getClazz() {
        return clazz;
    }


    public ObjectBean getBean() {
        return bean;
    }


    /**
     * 执行解析计划
     * @return
     */
    public T parse(){
        if(bean.getFieldsOfSet().isEmpty()){
            return null;
        }
        try {
            T result = clazz.getDeclaredConstructor().newInstance();
            Method method;
            for (String field : bean.getFieldsOfSet()) {
                //TODO 执行字段注入工作
                method = bean.getMethodOfSet(field);
                //字段注入
                ParameterInject.inject(object, method, result);
            }
            return result;
        }catch(InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e){
            throw new NotInstanceFunctionException(clazz);
        }
    }

    public void addParseRule(){
        //TODO 添加解析规则
    }


}
