package top.youlanqiang.alphajson.serialize.ParseChain;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * 工作链的尾链 可以什么也不做
 */
public class EndChain  extends ObjectToStringChain{


    @Override
    public String execute(Object object) {
        return "null";
    }
}
