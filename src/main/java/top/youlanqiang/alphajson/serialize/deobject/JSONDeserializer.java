package top.youlanqiang.alphajson.serialize.deobject;


import top.youlanqiang.alphajson.DefaultJSONArray;
import top.youlanqiang.alphajson.JSONException;
import top.youlanqiang.alphajson.DefaultJSONObject;
import top.youlanqiang.alphajson.utils.CastUtil;
import top.youlanqiang.alphajson.utils.StringUtil;

import java.util.*;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/17
 * @since 1.8
 */
public class JSONDeserializer {


    /**
     * 解析4种可能出现的JSON信息
     * [[..], [..], [..]]
     * [x, x, x, x]
     * [{..}, {..}, {..}]
     * [{..}, [..], x]
     * @param context json字符串
     * @return JSONArray对象
     */
    public static DefaultJSONArray parseToJSONArray(final String context){
        DefaultJSONArray array = new DefaultJSONArray();
        if (StringUtil.isNullOrEmpty(context)) {
            throw new JSONException("context is null");
        }
        if (StringUtil.isJSONArrayString(context)) {
            char token;
            int start = 1;
            for(int index = 0; index < context.length(); index++){
                token = context.charAt(index);
                if (token == '[' && index != 0){
                    int tempIndex = StringUtil.findArrayLimit(index, context);
                    array.add(parseToJSONArray(context.substring(index, tempIndex)));
                    index = tempIndex;
                    start = index + 1;
                } else if(token == '{'){
                    int tempIndex = StringUtil.findObjLimit(index, context);
                    array.add(parseToJSONObject(context.substring(index, tempIndex)));
                    index = tempIndex;
                    start = index + 1;
                } else if(token == ',' || token == ']'){
                    array.add(parseToObject(context.substring(start, index)));
                    start = index + 1;
                }
            }
            return array;
        } else {
            throw new JSONException("JSON type is error");
        }
    }



    public static DefaultJSONObject parseToJSONObject(final String context) {
        DefaultJSONObject object = new DefaultJSONObject();
        if (StringUtil.isNullOrEmpty(context)) {
            throw new JSONException("context is null");
        }
        if (StringUtil.isJSONObjectString(context.trim())) {
            /**
             * keyParser将字符串中的 key:value解析并放入KeyValue对象中
             */
            List<KeyValue> list = KeyParser.execute(context.trim().toCharArray());
            list.forEach(x -> {
                String value = x.getValue();
                Object returnValue = CastUtil.castToObject(value);
                object.put(x.getKeyName(), returnValue);
            });
            return object;
        } else {
            throw new JSONException("JSON type is error");
        }
    }


    public static Object parseToObject(final String value) {
        if (StringUtil.isJSONArrayString(value)) {
            return JSONDeserializer.parseToJSONArray(value);
        }
        if (StringUtil.isJSONObjectString(value)) {
            return JSONDeserializer.parseToJSONObject(value);
        }
        return CastUtil.castToObject(value);
    }


}
