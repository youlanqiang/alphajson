package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.JSONObject;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 */
public class ObjectSerializable implements StringSerialize {

    private JSONObject object;


    public ObjectSerializable(JSONObject object){
        super();
        this.object = object;
    }


    @Override
    public String operator() {
        return null;
    }
}
