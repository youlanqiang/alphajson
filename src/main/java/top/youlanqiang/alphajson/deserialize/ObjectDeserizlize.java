package top.youlanqiang.alphajson.deserialize;

import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.serialize.MapContainer;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/17
 * @since 1.8
 *
 * Object对象反序列化
 */
public class ObjectDeserizlize {

    public static JSONObject bean2Json(MapContainer container){
        JSONObject object = new JSONObject();
        object.setContainer(container.getContainer());
        return object;
    }


}
