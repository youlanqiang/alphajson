package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.serialize.ParseChain.ObjectToStringChain;
import top.youlanqiang.alphajson.utils.RailUtil;

import java.util.Map;
import java.util.StringJoiner;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 */
public class ObjectSerializable implements StringSerialize {

    private Map<String, Object> map;

    private static final ObjectToStringChain chain = SerializeChainFactory.getChain();


    public ObjectSerializable(MapContainer container){
        super();
        this.map = container.getContainer();
    }


    /**
     * 对象转化
     * @param key
     * @param value
     * @return
     */
    private static String KeyAndValue(String key, Object value){
        StringBuilder builder = new StringBuilder("\"");
        builder.append(key).append("\"").append(":").append(
                chain.execute(value)
        );
        return builder.toString();
    }

    @Override
    public String operator() {
        StringJoiner joiner = new StringJoiner(",");
        for(String key : map.keySet()){
            joiner.add(KeyAndValue(key, map.get(key)));
        }
        return RailUtil.jsonObject(joiner.toString());
    }



}
