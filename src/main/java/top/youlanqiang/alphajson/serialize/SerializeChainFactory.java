package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.serialize.ParseChain.ArrayOrMapChain;
import top.youlanqiang.alphajson.serialize.ParseChain.BaseChain;
import top.youlanqiang.alphajson.serialize.ParseChain.EndChain;
import top.youlanqiang.alphajson.serialize.ParseChain.ObjectToStringChain;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * 解析链工厂
 */
public class SerializeChainFactory {



    public static ObjectToStringChain getChain(){
        EndChain endChain = new EndChain();
        ArrayOrMapChain mapChain = new ArrayOrMapChain(endChain);
        BaseChain baseChain = new BaseChain(mapChain);

        return baseChain;
    }
}
