package top.youlanqiang.alphajson.utils;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * RailUtil工具类用来将字符串使用start和end包装起来
 */
public  class RailUtil {

    public static String rail(CharSequence str, String start, String end){
        StringBuilder builder = new StringBuilder();
        builder.append(start).append(str).append(end);
        return builder.toString();
    }

    /**
     * 包装JSONObject对象
     * @param str
     * @return
     */
    public static String jsonObject(CharSequence str){
        return rail(str, "{", "}");
    }

    /**
     * 包装JSONArray对象
     * @param str
     * @return
     */
    public static String jsonArray(CharSequence str){
        return rail(str, "[", "]");
    }

    /**
     * 包装字符串对象
     * @param str
     * @return
     */
    public static String string(CharSequence str){
        return rail(str, "\"", "\"");
    }

}
