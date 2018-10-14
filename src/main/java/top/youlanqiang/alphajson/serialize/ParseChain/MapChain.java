package top.youlanqiang.alphajson.serialize.ParseChain;

import top.youlanqiang.alphajson.serialize.MapContainer;
import top.youlanqiang.alphajson.serialize.ObjectSerializable;

import java.util.Map;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * MapContainer对象解析器
 */
public class MapChain extends ObjectToStringChain {

    public MapChain(ObjectToStringChain chain){
        super();
        this.next = chain;
    }

    @Override
    public String execute(Object object) {
        ObjectSerializable serializable;

        if(object instanceof Map){
            final Map<String, Object> map = (Map<String, Object>) object;
            serializable = new ObjectSerializable(new MapContainer() {
                @Override
                public Map<String, Object> getContainer() {
                    return map;
                }
            });
            return serializable.operator();
        }
        return next.execute(object);
    }
}
