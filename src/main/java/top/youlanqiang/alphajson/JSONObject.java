package top.youlanqiang.alphajson;

import top.youlanqiang.alphajson.bean.ObjectBean;
import top.youlanqiang.alphajson.bean.SimpleObjectBean;
import top.youlanqiang.alphajson.serialize.DefaultJSONSerializer;
import top.youlanqiang.alphajson.serialize.deobject.JSONDeserializer;
import top.youlanqiang.alphajson.utils.CastUtil;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
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


    public  <T> T to(Class<T> clazz){
        return parse(this, clazz);
    }

    /**
     * 反序列化JSON字符串
     * @param json 字符串
     * @return JSONObject对象
     */
    public static JSONObject parse(String json){
        Map<String, Object> object =  JSONDeserializer.parseToMap(json);
        if(object.isEmpty()){
            return new JSONObject();
        }else{
            JSONObject result = new JSONObject();
            result.map = object;
            return result;
        }
    }

    public static <T> T parse(JSONObject json, Class<T> clazz){
        try {
            if(clazz == JSONObject.class) {
                return (T) json;
            }
            return CastUtil.cast(json, clazz);
        }catch(Exception e){
            throw new JSONException("parse exception");
        }
    }

    public static <T> T parse(String json, Class<T> clazz){
        try {
            if(clazz == JSONObject.class) {
                return (T) JSONObject.parse(json);
            }
            if(clazz == JSONArray.class){
                return (T) JSONArray.parse(json);
            }
            return CastUtil.cast(JSONObject.parse(json), clazz);
        }catch(Exception e){
            throw new JSONException("parse exception");
        }
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

    public BigDecimal getBigDecimal(String key){
        return CastUtil.castToBigDecimal(map.get(key));
    }

    public BigInteger getBigInteger(String key){
        return CastUtil.castToBigInteger(map.get(key));
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
        map.clear();
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
