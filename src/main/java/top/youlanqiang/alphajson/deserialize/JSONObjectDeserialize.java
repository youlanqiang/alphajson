package top.youlanqiang.alphajson.deserialize;

import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.debug.Debug;
import top.youlanqiang.alphajson.debug.DebugFactory;
import top.youlanqiang.alphajson.deserialize.object.KeyParser;
import top.youlanqiang.alphajson.deserialize.object.KeyValue;
import top.youlanqiang.alphajson.serialize.JSONSerialize;
import top.youlanqiang.alphajson.utils.StringUtil;

import java.util.List;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/17
 * @since 1.8
 *
 * JSONObject对象反序列化
 */
public class JSONObjectDeserialize implements JSONDeserialize{

    private static final Debug debug = DebugFactory.getDebug();


    private JSONObject object;

    public JSONObjectDeserialize(){
        this.object = new JSONObject();
    }


    @Override
    public JSONSerialize parse(String context) {
        if(StringUtil.isNullOrEmpty(context)){
            throw new RuntimeException("字符串不能为空");
        }
        context = context.trim();
        if(context.startsWith("{") && context.endsWith("}")){
            debug.info("解析的字符串:" + context);
            List<KeyValue> list =  KeyParser.execute(context.toCharArray());
            list.forEach(x->{
                setValueInJson(x);
            });
            return object;
        }else{
            throw new RuntimeException("错误的JSONObject格式");
        }
    }


    private void setValueInJson(KeyValue keyValue){
        String value = keyValue.getValue();
        Object returnValue = ObjectDeserizlize.parse(value);
        object.put(keyValue.getKeyName(), returnValue);
    }
}
