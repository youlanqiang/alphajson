package top.youlanqiang.alphajson.serialize.ParseChain;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * NULL对象解析器
 */
public class NullChain extends ObjectToStringChain {

    public NullChain(ObjectToStringChain chain){
        super();
        this.next = chain;
    }


    @Override
    public String execute(Object object) {
        if(object == null){
            return "null";
        }
        return next.execute(object);
    }
}
