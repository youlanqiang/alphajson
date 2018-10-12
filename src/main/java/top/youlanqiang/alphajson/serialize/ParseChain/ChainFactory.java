package top.youlanqiang.alphajson.serialize.ParseChain;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * 解析链工厂
 */
public class ChainFactory {



    public static ObjectToStringChain getChain(){
        EndChain endChain = new EndChain();
        MapContainerChain mapContainerChain = new MapContainerChain(endChain);
        StringChain stringChain = new StringChain(mapContainerChain);
        NumberChain numberChain = new NumberChain(stringChain);
        BooleanChain booleanChain = new BooleanChain(numberChain);
        NullChain nullChain = new NullChain(booleanChain);
        return nullChain;
    }
}
