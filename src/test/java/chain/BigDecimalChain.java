package chain;

import top.youlanqiang.alphajson.serialize.chain.ObjectToStringChain;

import java.math.BigDecimal;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/30
 * @since 1.8
 */
public class BigDecimalChain extends ObjectToStringChain {

    @Override
    public String execute(Object object) {
        if(object instanceof BigDecimal){
            return "\"金钱\"";
        }
        return getNext().execute(object);
    }


}
