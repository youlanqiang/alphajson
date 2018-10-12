package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.JSONObject;

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


    public ObjectSerializable(MapContainer container){
        super();
        this.map = container.getContainer();
    }

    /**
     * 组合JSON字符串
     * @param joiner
     * @return
     */
    private String rail(StringJoiner joiner){
        StringBuilder json = new StringBuilder("{");
        json.append(joiner).append("}");
        return json.toString();
    }

    /**
     * 对象转化
     * @param key
     * @param value
     * @return
     */
    private static String KeyAndValue(String key, Object value){
        StringBuilder builder = new StringBuilder("\"");
        builder.append(key).append("\"").append(":").append(value.toString());
        return builder.toString();
    }

    @Override
    public String operator() {
        StringJoiner joiner = new StringJoiner(",");
        for(String key : map.keySet()){
            joiner.add(KeyAndValue(key, map.get(key)));
        }
        return rail(joiner);
    }



}
