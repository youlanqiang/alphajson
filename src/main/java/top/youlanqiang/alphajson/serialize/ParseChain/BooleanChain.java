package top.youlanqiang.alphajson.serialize.ParseChain;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * boolean解析器
 */
public class BooleanChain extends ObjectToStringChain {

    public BooleanChain(ObjectToStringChain chain){
        super();
        this.next = chain;
    }


    @Override
    public String  execute(Object object) {
        if(object instanceof Boolean){
            return object.toString();
        }
        return next.execute(object);
    }
}
