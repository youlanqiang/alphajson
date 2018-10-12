package top.youlanqiang.alphajson.serialize.ParseChain;

import top.youlanqiang.alphajson.utils.RailUtil;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * 字符串对象解析器
 */
public class StringChain extends ObjectToStringChain {

    public StringChain(ObjectToStringChain chain){
        super();
        this.next = chain;
    }


    @Override
    public String execute(Object object) {
        if(object instanceof CharSequence){
            return RailUtil.string(object.toString());
        }
        return next.execute(object);
    }


}
