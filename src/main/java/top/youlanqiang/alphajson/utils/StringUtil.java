package top.youlanqiang.alphajson.utils;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/17
 * @since 1.8
 * 字符串工具类
 */
public final class StringUtil {

    public static boolean isNullOrEmpty(String context){
        if(context == null || context.trim().equals("")){
            return true;
        }
        return false;
    }
}
