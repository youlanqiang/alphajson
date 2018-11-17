package top.youlanqiang.alphajson;

import top.youlanqiang.alphajson.serialize.DefaultJSONSerializer;
import top.youlanqiang.alphajson.utils.CastUtil;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/17
 * @since 1.8
 */
public class  JSONObject implements Map<String, Object> {

    private Map<String, Object> map;

    public JSONObject(){
        this.map = new ConcurrentHashMap<>();
    }

    public static String toString(Object object){
        return DefaultJSONSerializer.operatorToObject(object);
    }

    public Byte getByte(String key){
        return CastUtil.castToByte(map.get(key));
    }

    public Short getShort(String key){
        return CastUtil.castToShort(map.get(key));
    }

    public Character getChar(String key){
        return CastUtil.castToChar(map.get(key));
    }

    public Integer getInteger(String key){
        return CastUtil.castToInteger(map.get(key));
    }

    public Long getLong(String key){
        return CastUtil.castToLong(map.get(key));
    }

    public Float getFloat(String key){
        return CastUtil.castToFloat(map.get(key));
    }

    public Double getDouble(String key){
        return CastUtil.castToDouble(map.get(key));
    }

    public String getString(String key){
        return CastUtil.castToString(map.get(key));
    }

    public Boolean getBoolean(String key){
        return CastUtil.castToBoolean(map.get(key));
    }

    public Object getObject(String key){
        return map.get(key);
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return map.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<Object> values() {
        return map.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return map.entrySet();
    }

    public String toString(){
        return DefaultJSONSerializer.operator(map);
    }
}
