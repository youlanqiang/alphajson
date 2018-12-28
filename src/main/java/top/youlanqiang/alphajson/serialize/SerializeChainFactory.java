package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.serialize.chain.*;

import java.io.File;
import java.io.InputStream;


/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * 解析链工厂
 */
public class SerializeChainFactory {

    private SerializeChainFactory() {}

    private static  ParseConfig parseConfig = null;


    public static ParseConfig getDefaultConfig() throws ClassNotFoundException {
        if(parseConfig == null){
            synchronized(SerializeChainFactory.class) {
                parseConfig = new DefaultParseConfig();
                InputStream in = SerializeChainFactory.class.getClassLoader().getResourceAsStream(File.separator + "json.properties");
                if (in != null) {
                    ((DefaultParseConfig)parseConfig).initByProperties(in);
                    return parseConfig;
                }
                in = SerializeChainFactory.class.getClassLoader().getResourceAsStream(File.separator + "json.yml");
                if (in != null) {
                    ((DefaultParseConfig)parseConfig).initByYaml(in);
                    return parseConfig;
                }
            }
        }
        return parseConfig;
    }

    public static ObjectToStringChain getChain() {
        return getChain(null);
    }

    /**
     * 适配自定义的解析模块
     *
     * @param chains 解析组
     * @return 解析器
     */
    public static ObjectToStringChain getChain(ObjectToStringChain... chains) {

        EndChain endChain = new EndChain();
        ArrayOrMapChain mapChain = new ArrayOrMapChain(endChain);
        TimeChain timeChain = new TimeChain(mapChain);
        EnumChain enumChain = new EnumChain(timeChain);
        BaseChain baseChain = new BaseChain(enumChain);
        DecimalChain decimalChain = new DecimalChain(baseChain);
        if (chains != null && chains.length > 0) {
            ObjectToStringChain chain;
            for (int i = chains.length - 1; i >= 0; i--) {
                chain = chains[i];
                if (i != 0) {
                    chain.setNext(chains[i - 1]);
                }
            }
            chain = chains[0];
            chain.setNext(decimalChain);
            NullChain nullChain = new NullChain(chains[chains.length - 1]);
            endChain.setDefaultChain(nullChain);
            return nullChain;
        }
        NullChain nullChain = new NullChain(decimalChain);
        return nullChain;
    }
}
