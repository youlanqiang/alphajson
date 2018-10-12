package top.youlanqiang.alphajson.serialize.ParseChain;

import top.youlanqiang.alphajson.serialize.MapContainer;
import top.youlanqiang.alphajson.serialize.ObjectSerializable;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 * MapContainer对象解析器
 */
public class MapContainerChain extends ObjectToStringChain {

    public MapContainerChain(ObjectToStringChain chain){
        super();
        this.next = chain;
    }

    @Override
    public String execute(Object object) {
        if(object instanceof MapContainer){
            ObjectSerializable serializable = new ObjectSerializable((MapContainer) object);
            return serializable.operator();
        }
        return next.execute(object);
    }
}
