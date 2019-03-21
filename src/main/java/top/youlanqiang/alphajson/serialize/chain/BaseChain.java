package top.youlanqiang.alphajson.serialize.chain;

import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.serialize.DefaultJSONSerializer;
import top.youlanqiang.alphajson.utils.RailUtil;

import java.util.Arrays;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public class BaseChain  extends ObjectToStringChain {


    public BaseChain(ObjectToStringChain chain){
        this.next = chain;
    }

    @Override
    public String execute(Object object) {

        if(object.getClass().isArray()){
            return DefaultJSONSerializer.operator(Arrays.asList((Object[]) object));
        }
        if(object instanceof Number){
            return object.toString();
        }
        if(object instanceof Boolean){
            return object.toString();
        }
        if(object instanceof CharSequence){
            return RailUtil.string(object.toString());
        }
        if(object instanceof JSONArray){
            return object.toString();
        }
        if(object instanceof JSONObject){
            return object.toString();
        }
        return next.execute(object);
    }

    @Override
    public void setNext(ObjectToStringChain chain) {
        this.next = next;
    }
}
