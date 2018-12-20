package top.youlanqiang.alphajson.serialize.chain;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * 对象转JSON字符串的责任链
 *  如果无法解析便交给下一位解析链
 */
public abstract class ObjectToStringChain {

    protected ObjectToStringChain next;

    /**
     * 执行对象转字符串操作
     * @return
     */
    abstract public String execute(Object object);

    /**
     * 如果条件不成立执行下一个责任连
     * @param chain
     */
    public void setNext(ObjectToStringChain chain){
        this.next = chain;
    }

    public ObjectToStringChain getNext(){
        return next;
    }

}
