package top.youlanqiang.alphajson.serialize.chain;

import top.youlanqiang.alphajson.DefaultJSONArray;
import top.youlanqiang.alphajson.DefaultJSONObject;
import top.youlanqiang.alphajson.serialize.DefaultJSONSerializer;
import top.youlanqiang.alphajson.utils.RailUtil;

import java.util.Arrays;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/15
 * @since 1.8
 * 处理基本类型的操作链
 * 如 null,number,boolean,String
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
        if(object instanceof DefaultJSONArray){
            return object.toString();
        }
        if(object instanceof DefaultJSONObject){
            return object.toString();
        }
        return next.execute(object);
    }

    @Override
    public void setNext(ObjectToStringChain chain) {
        this.next = next;
    }
}
