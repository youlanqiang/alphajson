package top.youlanqiang.alphajson.serialize.ParseChain;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * 数字对象解析器
 */
public class NumberChain extends ObjectToStringChain{


    public NumberChain(ObjectToStringChain chain){
        super();
        this.next = chain;
    }

    @Override
    public String execute(Object object) {
        if(object instanceof  Number){
            return object.toString();
        }
        return next.execute(object);
    }
}
