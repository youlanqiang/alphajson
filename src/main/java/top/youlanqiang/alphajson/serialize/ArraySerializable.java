package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.utils.RailUtil;

import java.util.StringJoiner;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 */
public class ArraySerializable implements StringSerialize {

    private JSONArray array;


    public ArraySerializable(JSONArray array){
        super();
        this.array = array;
    }


    @Override
    public String operator() {
        int size = array.size();
        StringJoiner joiner = new StringJoiner(",");
        for(int i = 0; i < size; i++){
            joiner.add(array.getJSONObject(i).toString());
        }
        return RailUtil.jsonArray(joiner.toString());
    }
}
