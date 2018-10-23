package top.youlanqiang.alphajson.deserialize;

import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.debug.Debug;
import top.youlanqiang.alphajson.debug.DebugFactory;
import top.youlanqiang.alphajson.serialize.JSONSerialize;
import top.youlanqiang.alphajson.utils.StringUtil;

import java.util.Stack;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/17
 * @since 1.8
 *
 * JSONArray对象反序列化
 */
public class JSONArrayDeserialize implements JSONDeserialize{

    private static final Debug debug = DebugFactory.getDebug();

    private JSONArray array = new JSONArray();

    private JSONDeserialize deserialize;

    @Override
    public JSONSerialize parse(String context) {
        if(StringUtil.isNullOrEmpty(context)){
            throw new RuntimeException("字符串不能为空");
        }
        context = context.trim();
        if(context.startsWith("[") && context.endsWith("]")){
            //TODO 解析出每条JSONObject对象 并转化

            Stack<Character> stack = new Stack<>();

            char token;
            int start = 0;
            int end;
            for(int index = 0; index < context.length(); index++){
                token = context.charAt(index);
                if(token == '{'){
                    if(stack.isEmpty()){
                        start = index;
                    }
                    stack.push(token);
                }else if(token == '}'){
                    stack.pop();
                    if(stack.isEmpty()){
                        end = index;
                        debug.info(context.substring(start, end + 1));
                        array.addJSONSerialize(parseValue(context.substring(start, end + 1)));
                    }
                }
            }
            return array;
        }else{
            throw new RuntimeException("错误的JSONArray格式");
        }
    }

    private JSONSerialize parseValue(String value){
        if(value.startsWith("[") && value.endsWith("]")){
            deserialize = new JSONArrayDeserialize();
            return deserialize.parse(value);
        }
        if(value.startsWith("{") && value.endsWith("}")){
            deserialize = new JSONObjectDeserialize();
            return deserialize.parse(value);
        }
        throw new RuntimeException("错误的JSON格式!");
    }
}
