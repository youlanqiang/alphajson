package top.youlanqiang.alphajson;

import top.youlanqiang.alphajson.serialize.ArraySerializable;
import top.youlanqiang.alphajson.serialize.JSONSerialize;
import top.youlanqiang.alphajson.serialize.StringSerialize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 */
public class JSONArray  implements JSONSerialize {



    private List<JSONObject> array = new ArrayList<>(20);

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int size(){
        return array.size();
    }

    public JSONObject getJSONObject(int index){
        return array.get(index);
    }

    public void addJSONObject(JSONObject jsonObject){
        array.add(jsonObject);
    }


    @Override
    public StringSerialize getSerialize() {
        return new ArraySerializable(this);
    }

    @Override
    public String toString() {
        return getSerialize().operator();
    }
}
