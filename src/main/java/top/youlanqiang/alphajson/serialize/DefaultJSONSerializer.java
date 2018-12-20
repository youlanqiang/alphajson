package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.serialize.chain.ObjectToStringChain;
import top.youlanqiang.alphajson.utils.RailUtil;

import java.util.Map;
import java.util.StringJoiner;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 */
public class DefaultJSONSerializer {


    private static final ObjectToStringChain chain = SerializeChainFactory.getChain();


    public static String operator(final Map map){
        StringJoiner joiner = new StringJoiner(",");
        for(Object key : map.keySet()){
            joiner.add(keyAndValue(key, map.get(key)).toString());
        }
        return RailUtil.jsonObject(joiner.toString());
    }

    public static String operator(final Map map, final ObjectToStringChain defaultChain){
        StringJoiner joiner = new StringJoiner(",");
        for(Object key : map.keySet()){
            joiner.add(keyAndValue(key, map.get(key), defaultChain).toString());
        }
        return RailUtil.jsonObject(joiner.toString());
    }


    public static String operator(final Iterable iterable) {
        StringJoiner joiner = new StringJoiner(",");
        for(Object object : iterable){
            joiner.add(chain.execute(object));
        }
        return RailUtil.jsonArray(joiner.toString());
    }

    public static String operator(final Iterable iterable, final ObjectToStringChain defaultChain) {
        if(defaultChain != null){
            StringJoiner joiner = new StringJoiner(",");
            for(Object object : iterable){
                joiner.add(defaultChain.execute(object));
            }
            return RailUtil.jsonArray(joiner.toString());
        }
        return operator(iterable);
    }

    public static String operatorToObject(final Object object){
        return chain.execute(object);
    }

    public static String operatorToObject(final Object object, final ObjectToStringChain defaultChain){
        if(defaultChain != null){
            return defaultChain.execute(object);
        }
        return chain.execute(object);
    }


    private static StringBuilder keyAndValue(final Object key, final Object value){
        StringBuilder builder = new StringBuilder();
        builder.append(chain.execute(key)).append(":").append(
                chain.execute(value)
        );
        return builder;
    }

    private static StringBuilder keyAndValue(final Object key, final Object value, final ObjectToStringChain defaultChain){
        if(defaultChain != null){
            StringBuilder builder = new StringBuilder();
            builder.append(defaultChain.execute(key)).append(":").append(
                    defaultChain.execute(value)
            );
            return builder;
        }
        return keyAndValue(key, value);
    }

}
