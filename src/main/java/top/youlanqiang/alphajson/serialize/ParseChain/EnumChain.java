package top.youlanqiang.alphajson.serialize.ParseChain;

import top.youlanqiang.alphajson.utils.RailUtil;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/12/13
 * @since 1.8
 * 处理枚举类型的操作链
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
