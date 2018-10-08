package top.youlanqiang.alphajson.utils;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/8
 * @since 1.8
 * 变量转化工具类
 */
public final class TransitionUtil {

    public static String parseString(Object object){
        if (object instanceof String){
            return (String)object;
        }
        return object.toString();
    }


    public static Integer parseInteger(Object object){
        if (object instanceof Number){
            if(object.toString().contains(".")) {
                return (int)Math.round(parseDouble(object));
            }else {
                return  parseLong(object).intValue();
            }
        }
        return Integer.valueOf(parseString(object));
    }

    public static Long parseLong(Object object){
        if (object instanceof Number){
            if(object.toString().contains(".")) {
                return Math.round(parseDouble(object));
            }else {
                return Long.valueOf(object.toString());
            }
        }
        return Long.parseLong(parseString(object));
    }

    public static Float parseFloat(Object object){
        return Float.parseFloat(parseString(object));
    }


    public static Double parseDouble(Object object){
        return Double.parseDouble(parseString(object));
    }

    public static Boolean parseBoolean(Object object){
        if (object instanceof Boolean){
            return (boolean) object;
        }
        return Boolean.valueOf(parseString(object));
    }
}
