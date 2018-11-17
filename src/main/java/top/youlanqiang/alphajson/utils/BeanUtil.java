package top.youlanqiang.alphajson.utils;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/1
 * @since 1.8
 * JsonBean工具类
 */
public  class BeanUtil {

    /**
     * 更具传进来的名称截取字符串
     * getName ==> name
     * setName ==> name
     * @param name 名称
     * @return
     */
    public static String methodFieldName(String name){
        return name.substring(3, 4).toLowerCase() + name.substring(4);
    }

    /**
     * 截取字符串名称
     * isName ==> is
     * @param name
     * @return
     */
    public static String methodFieldNameForIs(String name){
        return name.substring(2, 3).toLowerCase() + name.substring(3);
    }
}
