package top.youlanqiang.alphajson.deserialize;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/17
 * @since 1.8
 *
 * Object对象反序列化
 */
public class ObjectDeserizlize {

    /**
     * 判断基本类型转化
     * @param value
     * @return
     */
    public static Object parse(String value){
        if(value.length() == 0){
            return value;
        }
        char start = value.charAt(0);
        //判断类型为String, false, true, null类型

        JSONDeserialize parser;
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
                parser = new JSONObjectDeserialize();
                return parse(value);
            case '[':
                parser = new JSONArrayDeserialize();
                return parse(value);
        }
        //判断为数字类型
        try {
            Integer.valueOf(start);
            return Double.valueOf(value);
        }catch(Exception e){
            return "";
        }
    }



}
