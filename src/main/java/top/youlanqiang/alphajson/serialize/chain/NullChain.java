package top.youlanqiang.alphajson.serialize.chain;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public class NullChain  extends ObjectToStringChain {

    public NullChain(ObjectToStringChain chain){
        this.next = chain;
    }

    @Override
    public String execute(Object object) {
        if(object == null) {
            return "null";

        }
        return getNext().execute(object);
    }
}
