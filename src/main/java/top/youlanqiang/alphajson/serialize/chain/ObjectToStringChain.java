package top.youlanqiang.alphajson.serialize.chain;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public abstract class ObjectToStringChain {

    protected ObjectToStringChain next;


    abstract public String execute(Object object);


    public void setNext(ObjectToStringChain chain){
        this.next = chain;
    }

    public ObjectToStringChain getNext(){
        return next;
    }

}
