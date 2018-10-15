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

        if(object instanceof Map){
            final Map<Object, Object> map = (Map<Object, Object>) object;
            //TODO 必须可以对Map进行Key和Value的解析
            return null;
        }
        return next.execute(object);
    }
}
