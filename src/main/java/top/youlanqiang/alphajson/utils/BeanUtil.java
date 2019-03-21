package top.youlanqiang.alphajson.utils;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public  class BeanUtil {


    public static String methodFieldName(String name){
        return name.substring(3, 4).toLowerCase() + name.substring(4);
    }


    public static String methodFieldNameForIs(String name){
        return name.substring(2, 3).toLowerCase() + name.substring(3);
    }
}
