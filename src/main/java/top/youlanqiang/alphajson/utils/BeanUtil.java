package top.youlanqiang.alphajson.utils;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/1
 * @since 1.8
 * JsonBean工具类
 */
public final class BeanUtil {

    /**
     * 更具传进来的名称截取字符串
     * getName ==> name
     * setName ==> name
     * @param name 名称
     * @return
     */
    public static String  methodFieldName(String name){
        return name.substring(3);
    }

}
