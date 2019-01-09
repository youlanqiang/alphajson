package top.youlanqiang.alphajson;


import top.youlanqiang.alphajson.serialize.DefaultJSONSerializer;
import top.youlanqiang.alphajson.serialize.chain.ObjectToStringChain;
import top.youlanqiang.alphajson.serialize.SerializeChainFactory;
import top.youlanqiang.alphajson.serialize.deobject.JSONDeserializer;
import top.youlanqiang.alphajson.utils.CastUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/17
 * @since 1.8
 */
public class DefaultJSONObject implements JSONObject {

    private Map<String, Object> map;

    private ObjectToStringChain chain;

    public DefaultJSONObject(){
        this.map = new HashMap<>();
    }

    public DefaultJSONObject(ObjectToStringChain... chains){
        this();
        this.chain = SerializeChainFactory.getChain(chain);
    }


    public DefaultJSONObject(Map<String, Object> map){
       this.map = map;
    }

    public DefaultJSONObject(Map<String, Object> map, ObjectToStringChain... chains){
        this(map);
        this.chain = SerializeChainFactory.getChain(chains);
    }

    public static String toString(Object object){
        return DefaultJSONSerializer.operatorToObject(object);
    }

    public static String toString(Object object, ObjectToStringChain... chains){
        return DefaultJSONSerializer.operatorToObject(object, SerializeChainFactory.getChain(chains));
    }


    public  <T> T to(Class<T> clazz){
        return parse(this, clazz);
    }

    /**
     * 反序列化JSON字符串
     * @param json 字符串
     * @return JSONObject对象
     */
    public static DefaultJSONObject parse(String json){
        Map<String, Object> object =  JSONDeserializer.parseToJSONObject(json.trim());
        if(object.isEmpty()){
            return new DefaultJSONObject();
        }else{
            DefaultJSONObject result = new DefaultJSONObject();
            result.map = object;
            return result;
        }
    }

    public static <T> T parse(DefaultJSONObject json, Class<T> clazz){
        try {
            return CastUtil.cast(json, clazz, null);
        }catch(Exception e){
            e.printStackTrace();
            throw new JSONException("parse exception");
        }
    }

    public static <T> T parse(String json, Class<T> clazz){
        return parse(DefaultJSONObject.parse(json), clazz);
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

    public Date getDate(String key){
        return CastUtil.castToDate(map.get(key));
    }

    public DefaultJSONObject getJSONObject(String key){
        Object obj = map.get(key);
        if(obj == null){
            return null;
        }
        if(obj instanceof DefaultJSONObject){
            return (DefaultJSONObject) obj;
        }
        try {
            return CastUtil.cast(obj, DefaultJSONObject.class, null);
        }catch(Exception e){
            JSONException exception = new JSONException("Parse DefaultJSONArray Exception");
            exception.initCause(e);
            throw exception;
        }
    }

    public DefaultJSONArray getJSONArray(String key){
        Object obj = map.get(key);
        if(obj == null){
            return null;
        }
        if(obj instanceof DefaultJSONArray){
            return (DefaultJSONArray) obj;
        }
        try {
            return CastUtil.cast(obj, DefaultJSONArray.class, null);
        }catch(Exception e){
            JSONException exception = new JSONException("Parse DefaultJSONArray Exception");
            exception.initCause(e);
            throw exception;
        }
    }

    public Object getObject(String key){
        return map.get(key);
    }

    public <T> T getObject(String key, Class<T> clazz){
        try {
            return CastUtil.cast(map.get(key), clazz);
        }catch(Exception e){
            JSONException exception = new JSONException("object cast error !");
            exception.initCause(e);
            throw exception;
        }
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

    public void setSerializer(ObjectToStringChain... chains){
        this.chain = SerializeChainFactory.getChain(chains);
    }

    @Override
    public String toString() {
        return DefaultJSONSerializer.operator(map, chain);
    }

    public String toString(ObjectToStringChain... chains) {
        return DefaultJSONSerializer.operator(map, SerializeChainFactory.getChain(chains));
    }
}
