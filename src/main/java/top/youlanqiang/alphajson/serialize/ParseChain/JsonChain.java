package top.youlanqiang.alphajson.serialize.ParseChain;

import top.youlanqiang.alphajson.serialize.JSONSerialize;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/14
 * @since 1.8
 * JSONObject 和 JSONArray的解析器
 */
public class JsonChain extends ObjectToStringChain{


    public JsonChain(ObjectToStringChain chain){
        this.next = chain;
    }

    @Override
    public String execute(Object object) {
        if(object instanceof JSONSerialize){
            return ((JSONSerialize) object).getSerialize().operator();
        }
        return next.execute(object);
    }
}
