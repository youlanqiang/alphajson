package top.youlanqiang.alphajson.deserialize;

import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.deserialize.decode.SimpleJSONObjectDecoder;
import top.youlanqiang.alphajson.serialize.JSONSerialize;
import top.youlanqiang.alphajson.utils.StringUtil;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/17
 * @since 1.8
 *
 * JSONObject对象反序列化
 */
public class JSONObjectDeserialize implements JSONDeserialize{


    @Override
    public JSONSerialize parse(String context) {
        if(StringUtil.isNullOrEmpty(context)){
            throw new RuntimeException("字符串不能为空");
        }
        context = context.trim();
        if(context.startsWith("{") && context.endsWith("}")){
            SimpleJSONObjectDecoder decoder = new SimpleJSONObjectDecoder(0);
            decoder.run(context.toCharArray());
            return decoder.toJSONObject();
        }else{
            throw new RuntimeException("错误的JSONObject格式");
        }
    }
}
