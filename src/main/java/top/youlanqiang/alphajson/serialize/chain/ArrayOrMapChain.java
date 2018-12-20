package top.youlanqiang.alphajson.serialize.chain;

import top.youlanqiang.alphajson.serialize.DefaultJSONSerializer;

import java.util.Map;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * MapContainer对象解析器
 */
public class ArrayOrMapChain extends ObjectToStringChain {

    public ArrayOrMapChain(ObjectToStringChain chain){
        super();
        this.next = chain;
    }

    @Override
    public String execute(Object object) {
        if(object instanceof Map){
            Map map = (Map) object;
            if(!map.isEmpty()) {
                return DefaultJSONSerializer.operator(map);
            }
            return "null";
        }

        if(object instanceof Iterable){
            Iterable iterable = (Iterable) object;
            return DefaultJSONSerializer.operator(iterable);
        }


        return next.execute(object);
    }


    @Override
    public void setNext(ObjectToStringChain chain) {
        this.next = chain;
    }
}
