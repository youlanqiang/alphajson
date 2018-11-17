package top.youlanqiang.alphajson.utils;


import top.youlanqiang.alphajson.JSONException;
import top.youlanqiang.alphajson.serialize.deobject.JSONDeserializer;

import java.math.BigDecimal;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/8
 * @since 1.8
 * 变量转化工具类
 */
public class CastUtil {

    public static Byte castToByte(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return byteValue((BigDecimal) value);
        }
        if (value instanceof Number) {
            return ((Number) value).byteValue();
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")) {
                return null;
            }
            return Byte.parseByte(str);
        }
        throw new JSONException("The value cast to byte error");
    }

    public static Byte byteValue(BigDecimal value) {
        if (value == null) {
            return 0;
        }
        return value.byteValue();
    }


    public static Short castToShort(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return shortValue((BigDecimal) value);
        }
        if (value instanceof Number) {
            return ((Number) value).shortValue();
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")) {
                return null;
            }
            return Short.parseShort(str);
        }
        throw new JSONException("The value cast to short error");
    }

    public static Short shortValue(BigDecimal value) {
        if (value == null) {
            return 0;
        }
        return value.shortValue();
    }


    public static Character castToChar(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Character) {
            return (char) value;
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str)) {
                return '\0';
            }
            if (str.length() == 1) {
                return str.charAt(0);
            }
        }
        throw new JSONException("The value cast to char error");
    }

    public static Integer castToInteger(Object value){
        if(value == null){
            return null;
        }
        if(value instanceof BigDecimal){
            return intValue((BigDecimal) value);
        }
        if(value instanceof Number){
            return ((Number) value).intValue();
        }
        if(value instanceof String){
            String str = (String) value;
            if(StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")){
                return null;
            }
            if(str.contains(".")){
                str = str.substring(str.indexOf('.'));
                return Integer.valueOf(str);
            }
            return Integer.valueOf(str);
        }
        throw new JSONException("The value cast to int error");
    }

    public static Integer intValue(BigDecimal value){
        if(value == null){
            return 0;
        }
        return value.intValue();
    }

    public static Long castToLong(Object value){
        if(value == null){
            return null;
        }
        if(value instanceof BigDecimal){
            return longValue((BigDecimal) value);
        }
        if(value instanceof Number){
            return ((Number) value).longValue();
        }
        if(value instanceof String){
            String str = (String) value;
            if(StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")){
                return null;
            }
            if(str.contains(".")){
                str = str.substring(str.indexOf('.'));
                return Long.valueOf(str);
            }
            return Long.valueOf(str);
        }
        throw new JSONException("The value cast to long error");
    }

    public static Long longValue(BigDecimal value){
        if(value == null){
            return 0L;
        }
        return value.longValue();
    }

    public static Float castToFloat(Object value){
        if(value == null){
            return null;
        }
        if(value instanceof BigDecimal){
            return floatValue((BigDecimal) value);
        }
        if(value instanceof Number){
            return ((Number) value).floatValue();
        }
        if(value instanceof String){
            String str = (String) value;
            if(StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")){
                return null;
            }
            return Float.valueOf(str);
        }
        throw new JSONException("The value cast to float error");
    }

    public static Float floatValue(BigDecimal value){
        if(value == null){
            return 0F;
        }
        return value.floatValue();
    }

    public static Double castToDouble(Object value){
        if(value == null){
            return null;
        }
        if(value instanceof BigDecimal){
            return doubleValue((BigDecimal) value);
        }
        if(value instanceof Number){
            return ((Number) value).doubleValue();
        }
        if(value instanceof String){
            String str = (String) value;
            if(StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")){
                return null;
            }
            return Double.valueOf(str);
        }
        throw new JSONException("The value cast to int error");
    }

    public static Double doubleValue(BigDecimal value){
        if(value == null){
            return 0.0;
        }
        return value.doubleValue();
    }


    public static String castToString(Object value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static Boolean castToBoolean(Object value){
        if(value == null){
            return null;
        }
        if(value instanceof BigDecimal){
            int num = intValue((BigDecimal) value);
            return num != 0 ? true : false;
        }
        if(value instanceof Number){
            int num =  castToInteger(value);
            return num != 0 ? true : false;
        }
        if(value instanceof String){
            String str = (String) value;
            if(StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")){
                return null;
            }
            return Boolean.valueOf(str);
        }
        throw new JSONException("The value cast to boolean error");
    }


    public static Object castToObject(String value){
        if(value.length() == 0){
            return value;
        }
        char start = value.charAt(0);
        //判断类型为String, false, true, null类型

        switch(start){
            case '\"':
                return value.substring(1);
            case '\'':
                return value.substring(1);
            case 'f':
                return false;
            case 't':
                return true;
            case 'n':
                return null;
            case '{':
                return JSONDeserializer.parseToObject(value);
            case '[':
                return JSONDeserializer.parseToObject(value);
        }
        try {
            if (value.contains(".")) {
                return Double.valueOf(value);
            } else {
                return Long.valueOf(value);
            }
        }catch(Exception e){
            return value;
        }
    }


}
