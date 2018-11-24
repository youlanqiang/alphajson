package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.serialize.ParseChain.*;

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
        TimeChain timeChain = new TimeChain(mapChain);
        BaseChain baseChain = new BaseChain(timeChain);
        return baseChain;
    }

    /**
     * 适配自定义的解析模块
     * TODO 未测试
     * @param chains 解析组
     * @return 解析器
     */
    public static ObjectToStringChain getChain(ObjectToStringChain... chains){

        EndChain endChain = new EndChain();
        ArrayOrMapChain mapChain = new ArrayOrMapChain(endChain);
        TimeChain timeChain = new TimeChain(mapChain);
        if(chains.length > 0){
            ObjectToStringChain chain;
            for(int i = chains.length - 1; i >= 0; i--){
                chain = chains[i];
                if(i != 0){
                    chain.setNext(chains[i - 1]);
                }
            }
            chain= chains[0];
            chain.setNext(timeChain);
            BaseChain baseChain = new BaseChain(chains[chains.length - 1]);
            return baseChain;
        }
        BaseChain baseChain = new BaseChain(timeChain);
        return baseChain;
    }
}
