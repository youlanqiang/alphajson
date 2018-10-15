package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.serialize.ParseChain.*;

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
        JsonChain jsonChain = new JsonChain(mapChain);
        BaseChain baseChain = new BaseChain(jsonChain);

        return baseChain;
    }
}
