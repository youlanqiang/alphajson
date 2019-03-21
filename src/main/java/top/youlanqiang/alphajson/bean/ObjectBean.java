package top.youlanqiang.alphajson.bean;


import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public interface ObjectBean {

    String SET ="set";

    String GET ="get";

    String IS = "is";


    Class getObjectClass();


    Method getMethodOfSet(String fieldName);


    Method getMethodOfGet(String fieldName);


    Set<String> getFieldsOfSet();


    Set<String> getFieldsOfGet();

    boolean isEnum();

}
