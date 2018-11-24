package top.youlanqiang.alphajson.serialize.ParseChain;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/24
 * @since 1.8
 * 处理时间类型
 * TODO 未完成
 */
public class TimeChain extends ObjectToStringChain{

    public TimeChain(ObjectToStringChain chain){
        this.next = chain;
    }

    @Override
    public String execute(Object object) {
        return null;
    }

    @Override
    public void setNext(ObjectToStringChain chain) {
        this.next = chain;
    }
}
