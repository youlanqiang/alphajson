package top.youlanqiang.alphajson.utils;

import top.youlanqiang.alphajson.exception.JSONParseException;

import java.math.BigDecimal;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/8
 * @since 1.8
 * 变量转化工具类
 * TODO 完成所有对象的转换.
 */
public class TransitionUtil {

    public static String parseString(Object object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    public static Byte parseByte(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof BigDecimal) {

        }
        if (object instanceof Number) {
            return ((Number) object).byteValue();
        }
        if (object instanceof String) {
            String value = (String) object;
            if(StringUtil.isNullOrEmpty(value) || value.equals("null") || value.equals("NULL")){
                return null;
            }
            return Byte.parseByte(value);
        }
        throw new JSONParseException("对象转化byte失败:" + object);
    }

    public static Short parseShort(Object object){
        if(object == null){
            return null;
        }
        if(object instanceof BigDecimal){

        }
        if(object instanceof Number){
            return ((Number) object).shortValue();
        }
        if(object instanceof String){
            String value = (String) object;
            if(StringUtil.isNullOrEmpty(value) || value.equals("null") || value.equals("NULL")){
                return null;
            }
            return Short.parseShort(value);
        }
        throw new JSONParseException("对象转化short失败:" + object);
    }


    public static Integer parseInteger(Object object) {
        if (object instanceof Number) {
            if (object.toString().contains(".")) {
                return (int) Math.round(parseDouble(object));
            } else {
                return parseLong(object).intValue();
            }
        }
        return Integer.valueOf(parseString(object));
    }

    public static Long parseLong(Object object) {
        if (object instanceof Number) {
            if (object.toString().contains(".")) {
                return Math.round(parseDouble(object));
            } else {
                return Long.valueOf(object.toString());
            }
        }
        return Long.parseLong(parseString(object));
    }

    public static Float parseFloat(Object object) {
        return Float.parseFloat(parseString(object));
    }


    public static Double parseDouble(Object object) {
        return Double.parseDouble(parseString(object));
    }

    public static Boolean parseBoolean(Object object) {
        if (object instanceof Boolean) {
            return (boolean) object;
        }
        return Boolean.valueOf(parseString(object));
    }
}
