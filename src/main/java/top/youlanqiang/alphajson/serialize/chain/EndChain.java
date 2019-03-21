package top.youlanqiang.alphajson.serialize.chain;


import top.youlanqiang.alphajson.bean.SimpleObjectBean;
import top.youlanqiang.alphajson.serialize.DefaultJSONSerializer;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public class EndChain  extends ObjectToStringChain {

    private ObjectToStringChain defaultChain;


    public void setDefaultChain(ObjectToStringChain defaultChain){
        this.defaultChain = defaultChain;
    }

    @Override
    public String execute(Object object) {
        SimpleObjectBean bean = new SimpleObjectBean(object);
        return DefaultJSONSerializer.operator((bean).getContainer(), defaultChain);
    }


    @Override
    public void setNext(ObjectToStringChain chain) {
        //do-no
    }
}
