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
        ArrayChain arrayChain = new ArrayChain(endChain);
        MapChain mapChain = new MapChain(arrayChain);
        StringChain stringChain = new StringChain(mapChain);
        NumberChain numberChain = new NumberChain(stringChain);
        BooleanChain booleanChain = new BooleanChain(numberChain);
        JsonChain jsonChain = new JsonChain(booleanChain);
        NullChain nullChain = new NullChain(jsonChain);

        return nullChain;
    }
}
