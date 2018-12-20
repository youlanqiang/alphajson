package top.youlanqiang.alphajson.serialize.chain;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/30
 * @since 1.8
 * 处理Null数据的工作链,该工作链应该处于工作链的顶级.
 * 否则程序容易出现NullPointException异常
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
