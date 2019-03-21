package top.youlanqiang.alphajson.serialize.chain;

import top.youlanqiang.alphajson.utils.RailUtil;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public class EnumChain extends ObjectToStringChain{

    private ObjectToStringChain next;

    public EnumChain(ObjectToStringChain next){
        this.next = next;
    }

    @Override
    public String execute(Object object) {
        if(object.getClass().isEnum()){
            return RailUtil.string(object.toString());
        }
        return next.execute(object);
    }

    @Override
    public void setNext(ObjectToStringChain chain) {
        this.next = chain;
    }

    @Override
    public ObjectToStringChain getNext() {
        return next;
    }
}
