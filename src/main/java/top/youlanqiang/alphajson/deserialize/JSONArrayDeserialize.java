package top.youlanqiang.alphajson.deserialize;

import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.serialize.JSONSerialize;
import top.youlanqiang.alphajson.utils.StringUtil;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/17
 * @since 1.8
 *
 * JSONArray对象反序列化
 */
public class JSONArrayDeserialize implements JSONDeserialize{


    private JSONArray array = new JSONArray();



    @Override
    public JSONSerialize parse(String context) {
        if(StringUtil.isNullOrEmpty(context)){
            throw new RuntimeException("字符串不能为空");
        }
        context = context.trim();
        if(context.startsWith("[") && context.endsWith("]")){
            //TODO 解析出每条JSONObject对象 并转化

            return null;
        }else{
            throw new RuntimeException("错误的JSONArray格式");
        }
    }
}
