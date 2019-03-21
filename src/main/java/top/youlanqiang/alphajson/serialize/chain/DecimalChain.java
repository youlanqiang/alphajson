package top.youlanqiang.alphajson.serialize.chain;

import top.youlanqiang.alphajson.serialize.SerializeChainFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public class DecimalChain extends ObjectToStringChain {

    private String decimalFormat;

    private DecimalFormat format;

    private ObjectToStringChain next;

    public DecimalChain(ObjectToStringChain next) {

        this.next = next;
        this.decimalFormat = SerializeChainFactory.getDefaultConfig().getDecimalFormat();
        this.format = new DecimalFormat(decimalFormat);

    }

    @Override
    public String execute(Object object) {
        if (object instanceof BigDecimal) {
            return format.format(object);
        }
        return next.execute(object);
    }
}
