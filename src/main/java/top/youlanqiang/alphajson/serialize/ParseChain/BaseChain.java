package top.youlanqiang.alphajson.serialize.ParseChain;

import top.youlanqiang.alphajson.utils.RailUtil;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/15
 * @since 1.8
 * 处理基本类型的操作链
 * 如 null,number,boolean,String
 */
public class BaseChain  extends ObjectToStringChain{


    public BaseChain(ObjectToStringChain chain){
        this.next = chain;
    }

    @Override
    public String execute(Object object) {
        if(object == null){
            return "null";
        }
        if(object instanceof Number ){
            return object.toString();
        }
        if(object instanceof Boolean){
            return object.toString();
        }
        if(object instanceof CharSequence){
            return RailUtil.string(object.toString());
        }
        return next.execute(object);
    }
}
