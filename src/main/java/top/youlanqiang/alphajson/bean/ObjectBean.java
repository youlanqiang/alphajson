package top.youlanqiang.alphajson.bean;


import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/1
 * @since 1.8
 * JavaBean对象解析
 */
public interface ObjectBean {

    String SET ="set";

    String GET ="get";

    String IS = "is";

    /**
     * 获取目标Class
     * @return
     */
    Class getObjectClass();

    /**
     * 获取字段set方法
     * @param fieldName 字段名
     * @return
     */
    Method getMethodOfSet(String fieldName);

    /**
     * 获取字段get方法
     * @param fieldName 字段名
     * @return
     */
    Method getMethodOfGet(String fieldName);

    /**
     * 获取所有带有set方法的字段
     * @return
     */
    Set<String> getFieldsOfSet();

    /**
     * 获取所有带有get方法的字段
     * @return
     */
    Set<String> getFieldsOfGet();

}
