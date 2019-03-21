package top.youlanqiang.alphajson.utils;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public  class RailUtil {

    public static String rail(CharSequence str, String start, String end){
        StringBuilder builder = new StringBuilder();
        builder.append(start).append(str).append(end);
        return builder.toString();
    }


    public static String jsonObject(CharSequence str){
        return rail(str, "{", "}");
    }


    public static String jsonArray(CharSequence str){
        return rail(str, "[", "]");
    }


    public static String string(CharSequence str){
        return rail(str, "\"", "\"");
    }

}
