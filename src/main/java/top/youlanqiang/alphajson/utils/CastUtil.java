package top.youlanqiang.alphajson.utils;


import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.JSONException;
import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.bean.SimpleObjectBean;
import top.youlanqiang.alphajson.serialize.SerializeChainFactory;
import top.youlanqiang.alphajson.serialize.deobject.JSONDeserializer;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        throw new JSONException("The type cast to byte error");
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
        throw new JSONException("The type cast to short error");
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
        throw new JSONException("The type cast to char error");
    }

    public static Integer castToInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return intValue((BigDecimal) value);
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")) {
                return null;
            }
            if (str.contains(".")) {
                str = str.substring(str.indexOf('.'));
                return Integer.valueOf(str);
            }
            return Integer.valueOf(str);
        }
        throw new JSONException("The type cast to int error");
    }

    public static Integer intValue(BigDecimal value) {
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }

    public static Long castToLong(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return longValue((BigDecimal) value);
        }
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")) {
                return null;
            }
            if (str.contains(".")) {
                str = str.substring(str.indexOf('.'));
                return Long.valueOf(str);
            }
            return Long.valueOf(str);
        }
        throw new JSONException("The type cast to long error");
    }

    public static Long longValue(BigDecimal value) {
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }

    public static Float castToFloat(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return floatValue((BigDecimal) value);
        }
        if (value instanceof Number) {
            return ((Number) value).floatValue();
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")) {
                return null;
            }
            return Float.valueOf(str);
        }
        throw new JSONException("The type cast to float error");
    }

    public static Float floatValue(BigDecimal value) {
        if (value == null) {
            return 0F;
        }
        return value.floatValue();
    }

    public static Double castToDouble(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return doubleValue((BigDecimal) value);
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")) {
                return null;
            }
            return Double.valueOf(str);
        }
        throw new JSONException("The type cast to int error");
    }

    public static Double doubleValue(BigDecimal value) {
        if (value == null) {
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

    public static Boolean castToBoolean(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            int num = intValue((BigDecimal) value);
            return num != 0 ? true : false;
        }
        if (value instanceof Number) {
            int num = castToInteger(value);
            return num != 0 ? true : false;
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")) {
                return null;
            }
            return Boolean.valueOf(str);
        }
        if (value instanceof Boolean) {
            return (boolean) value;
        }
        throw new JSONException("The type cast to boolean error");
    }

    public static BigDecimal castToBigDecimal(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        }
        if (value instanceof Number) {
            Number num = (Number) value;
            return BigDecimal.valueOf(num.doubleValue());
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")) {
                return null;
            }
            return new BigDecimal(castToDouble(str));
        }
        if (value instanceof Boolean) {
            boolean result = (boolean) value;
            return result ? BigDecimal.ONE : BigDecimal.ZERO;
        }
        throw new JSONException("The type cast to boolean error");
    }

    public static BigInteger castToBigInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return (BigInteger) value;
        }
        if (value instanceof Number) {
            Number num = (Number) value;
            return BigInteger.valueOf(num.intValue());
        }
        if (value instanceof String) {
            String str = (String) value;
            if (StringUtil.isNullOrEmpty(str) || str.equals("NULL") || str.equals("null")) {
                return null;
            }
            return BigInteger.valueOf(castToLong(str));
        }
        if (value instanceof Boolean) {
            boolean result = (boolean) value;
            return result ? BigInteger.ONE : BigInteger.ZERO;
        }
        throw new JSONException("The type cast to boolean error");
    }

    public static Date castToDate(Object value) {
        return castToDate(value, null);
    }

    public static Date castToDate(Object value, String format) {
        if (value == null) {
            return null;
        }
        if (value instanceof Date) {
            return (Date) value;
        }
        if (value instanceof Calendar) {
            return ((Calendar) value).getTime();
        }

        long longValue = -1;

        if (value instanceof BigDecimal) {
            longValue = longValue((BigDecimal) value);
            return new Date(longValue);
        }
        if (value instanceof Number) {
            longValue = ((Number) value).longValue();
            return new Date(longValue);
        }

        if (value instanceof String) {
            String strVal = (String) value;
            SimpleDateFormat dateFormat;
            if (!StringUtil.isNullOrEmpty(format)) {
                try {
                    dateFormat = new SimpleDateFormat(format);
                    return dateFormat.parse(strVal);
                } catch (ParseException e) {
                }
            }
            try {
                dateFormat = new SimpleDateFormat(SerializeChainFactory.getDefaultConfig().getDateFormat());
                return dateFormat.parse(strVal);
            } catch (ParseException e) {

            }
            try {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return dateFormat.parse(strVal);
            } catch (ParseException e) {

            }
            try {
                longValue = Long.parseLong(strVal);
                return new Date(longValue);
            } catch (NumberFormatException e) {

            }
        }
        throw new JSONException("The type cast to date error");
    }


    public static Object castToObject(String value) {
        if (value.length() == 0) {
            return value;
        }
        char start = value.charAt(0);
        //判断类型为String, false, true, null, number类型

        switch (start) {
            case '\"':
                return value.substring(1, value.length() - 1);
            case '\'':
                return value.substring(1, value.length() - 1);
            case 'f':
                return false;
            case 't':
                return true;
            case 'n':
                return null;
            case '{':
                return JSONDeserializer.parseToJSONObject(value);
            case '[':
                return JSONDeserializer.parseToJSONArray(value);
        }
        try {
            if (value.contains(".")) {
                return Double.valueOf(value);
            } else {
                return Long.valueOf(value);
            }
        } catch (Exception e) {
            return value;
        }
    }


    public static <T> T cast(Object obj, Class<T> clazz, Class... geners) throws Exception {

        if (obj == null) {
            if (clazz == int.class) {
                return (T) Integer.valueOf(0);
            }
            if (clazz == long.class) {
                return (T) Long.valueOf(0);
            }
            if (clazz == float.class) {
                return (T) Float.valueOf(0.0f);
            }
            if (clazz == double.class) {
                return (T) Double.valueOf(0.0);
            }
            if (clazz == byte.class) {
                return (T) Byte.valueOf((byte) 0);
            }
            if (clazz == short.class) {
                return (T) Short.valueOf((short) 0);
            }
            if (clazz == boolean.class) {
                return (T) Boolean.FALSE;
            }
            return null;
        }
        if (clazz == null) {
            throw new JSONException("class is null");
        }

        if (obj.getClass() == clazz) {
            return (T) obj;
        }


        if (clazz.isArray()) {
            if (obj instanceof Collection) {
                Collection coll = (Collection) obj;
                Object array = Array.newInstance(clazz.getComponentType(), coll.size());
                int index = 0;
                for (Object item : coll) {
                    Array.set(array, index, cast(item, clazz.getComponentType()));
                    index++;
                }
                return (T) array;
            }
        }

        if (obj instanceof Collection) {
            Collection coll = (Collection) obj;
            if (List.class.isAssignableFrom(clazz)) {
                if (geners.length != 0 && geners.length == 1) {
                    Object[] tempList = new Object[coll.size()];
                    int index = 0;
                    for (Object result : coll) {
                        tempList[index] = cast(result, geners[0]);
                        index++;
                    }
                    if (clazz.isInterface()) {
                        return (T) Arrays.asList(tempList);
                    } else if (Stack.class.isAssignableFrom(clazz)) {
                        Stack stack = new Stack();
                        for (Object item : tempList) {
                            stack.add(item);
                        }
                        return (T) stack;
                    } else {
                        return clazz.getConstructor(Collection.class).newInstance(Arrays.asList(tempList));
                    }
                }
                return null;
            }

            if (Set.class.isAssignableFrom(clazz)) {
                if (geners.length != 0 && geners.length == 1) {
                    Object[] tempList = new Object[coll.size()];
                    int index = 0;
                    for (Object result : coll) {
                        tempList[index] = cast(result, geners[0]);
                        index++;
                    }
                    if (clazz.isInterface()) {
                        return (T) new HashSet(Arrays.asList(tempList));
                    } else {
                        return clazz.getConstructor(Collection.class).newInstance(Arrays.asList(tempList));
                    }
                }
                return null;
            }

            if (Queue.class.isAssignableFrom(clazz)) {
                if (geners.length != 0 && geners.length == 1) {
                    Object[] tempList = new Object[coll.size()];
                    int index = 0;
                    for (Object result : coll) {
                        tempList[index] = cast(result, geners[0]);
                        index++;
                    }
                    if (clazz.isInterface()) {
                        return (T) new PriorityQueue(Arrays.asList(tempList));
                    } else {
                        return clazz.getConstructor(Collection.class).newInstance(Arrays.asList(tempList));
                    }
                }
                return null;
            }
        }


        if (clazz.isAssignableFrom(obj.getClass())) {
            return (T) obj;
        }

        if (clazz == Map.class) {
            if (obj instanceof Map) {
                return (T) obj;
            }
            SimpleObjectBean<Object> bean = new SimpleObjectBean<>(obj);
            return (T) bean.getContainer();
        }


        if (clazz == int.class || clazz == Integer.class) {
            return (T) castToInteger(obj);
        }
        if (clazz == long.class || clazz == Long.class) {
            return (T) castToLong(obj);
        }
        if (clazz == float.class || clazz == Float.class) {
            return (T) castToFloat(obj);
        }
        if (clazz == double.class || clazz == Double.class) {
            return (T) castToDouble(obj);
        }
        if (clazz == short.class || clazz == Short.class) {
            return (T) castToShort(obj);
        }
        if (clazz == byte.class || clazz == Byte.class) {
            return (T) castToByte(obj);
        }
        if (clazz == char.class || clazz == Character.class) {
            return (T) castToChar(obj);
        }
        if (clazz == boolean.class || clazz == Boolean.class) {
            return (T) castToBoolean(obj);
        }
        if (clazz == String.class) {
            return (T) castToString(obj);
        }
        if (clazz == BigDecimal.class) {
            return (T) castToBigDecimal(obj);
        }
        if (clazz == BigInteger.class) {
            return (T) castToBigInteger(obj);
        }
        if (clazz == Date.class) {
            return (T) castToDate(obj);
        }
        if (clazz.isEnum()) {
            return (T) clazz.getMethod("valueOf", String.class).invoke(null, obj.toString());
        }
        if (clazz == JSONObject.class) {
            if (obj instanceof Map) {
                return (T) new JSONObject((Map<String, Object>) obj);
            }
            SimpleObjectBean bean = new SimpleObjectBean(obj);
            Map<String, Object> resultMap = (Map<String, Object>) bean.getContainer();
            return (T) new JSONObject(resultMap);
        }
        if (clazz == JSONArray.class) {
            Object[] objects = CastUtil.cast(obj, Object[].class, null);
            return (T) new JSONArray(Arrays.asList(objects));
        }

        if (obj instanceof Map) {
            SimpleObjectBean<T> objectBean = new SimpleObjectBean<>(clazz);
            return objectBean.injectJSONObject((Map) obj);
        }
        return null;
    }


}
