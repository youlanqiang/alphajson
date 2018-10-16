package top.youlanqiang.alphajson.serialize.ParseChain;




import top.youlanqiang.alphajson.serialize.SerializeChainFactory;

import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * MapContainer对象解析器
 */
public class MapChain extends ObjectToStringChain {

    private static final ObjectToStringChain chain = SerializeChainFactory.getChain();


    public MapChain(ObjectToStringChain chain){
        super();
        this.next = chain;
    }

    @Override
    public String execute(Object object) {
        if(object instanceof Map){
            Map<Object, Object> map = (Map<Object, Object>) object;
            if(!map.isEmpty()) {
                StringJoiner joiner = new StringJoiner(",");
                Set<Object> keys = map.keySet();
                StringBuilder builder = new StringBuilder();
                for (Object key : keys) {
                    builder.append(chain.execute(key))
                            .append(":")
                            .append(chain.execute(map.get(key)));
                    joiner.add(builder);
                    //清空builder
                    builder.setLength(0);
                }
                return joiner.toString();
            }
            return "null";
        }
        return next.execute(object);
    }
}
