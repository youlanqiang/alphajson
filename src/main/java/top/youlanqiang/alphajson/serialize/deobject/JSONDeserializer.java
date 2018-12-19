package top.youlanqiang.alphajson.serialize.deobject;


import top.youlanqiang.alphajson.JSONException;
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

    public static Collection parseToCollection(String context) {
        List<Object> list = new ArrayList<>();
        if (StringUtil.isNullOrEmpty(context)) {
            throw new JSONException("context is null");
        }
        if (StringUtil.isJSONArrayString(context)) {
            Stack<Character> stack = new Stack<>();
            char token;
            int start = 0;
            int end = 0;
            for (int index = 0; index < context.length(); index++) {
                token = context.charAt(index);
                if (token == '{') {
                    if (stack.isEmpty()) {
                        start = index;
                    }
                    stack.push(token);
                } else if (token == '}') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        end = index;
                        list.add(parseToObject(context.substring(start, end + 1)));
                    }
                } else if (token == ',' && stack.isEmpty() && index > end + 1) {
                    list.add(parseToObject(context.substring(start + 1, index)));
                    start = index;
                } else if (token == ']' && stack.isEmpty() && index > end + 1) {
                    list.add(parseToObject(context.substring(start + 1, index)));
                    start = index;
                }
            }

            /**
             * stack不为空表示JSON字符串是错误的,因为没有解析完
             */
            if (!stack.isEmpty()) {
                throw new JSONException("JSON type is error");
            }

            return list;
        } else {
            throw new JSONException("JSON type is error");
        }
    }


    public static Map<String, Object> parseToMap(String context) {
        Map<String, Object> map = new HashMap<>();
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
                map.put(x.getKeyName(), returnValue);
            });
            return map;
        } else {
            throw new JSONException("JSON type is error");
        }
    }


    public static Object parseToObject(String value) {
        if (StringUtil.isJSONArrayString(value)) {
            return JSONDeserializer.parseToCollection(value);
        }
        if (StringUtil.isJSONObjectString(value)) {
            return JSONDeserializer.parseToMap(value);
        }
        return CastUtil.castToObject(value);
    }


}
