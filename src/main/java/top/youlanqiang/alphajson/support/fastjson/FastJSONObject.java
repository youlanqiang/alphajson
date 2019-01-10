package top.youlanqiang.alphajson.support.fastjson;

import com.alibaba.fastjson.JSONObject;
import top.youlanqiang.alphajson.JSONArray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2019/1/10
 * @since 1.8
 */
public class FastJSONObject implements top.youlanqiang.alphajson.JSONObject {

    private JSONObject object;

    public FastJSONObject(){
        object = new JSONObject();
    }

    public FastJSONObject(final JSONObject object){
        this.object = object;
    }


    @Override
    public Byte getByte(String key) {
        return object.getByte(key);
    }

    @Override
    public Short getShort(String key) {
        return object.getShort(key);
    }

    @Override
    public Character getChar(String key) {
        //no-do
        return null;
    }

    @Override
    public Integer getInteger(String key) {
        return object.getInteger(key);
    }

    @Override
    public Long getLong(String key) {
        return object.getLong(key);
    }

    @Override
    public Float getFloat(String key) {
        return object.getFloat(key);
    }

    @Override
    public Double getDouble(String key) {
        return object.getDouble(key);
    }

    @Override
    public String getString(String key) {
        return object.getString(key);
    }

    @Override
    public Boolean getBoolean(String key) {
        return object.getBoolean(key);
    }

    @Override
    public BigDecimal getBigDecimal(String key) {
        return object.getBigDecimal(key);
    }

    @Override
    public BigInteger getBigInteger(String key) {
        return object.getBigInteger(key);
    }

    @Override
    public Date getDate(String key) {
        return object.getDate(key);
    }

    @Override
    public top.youlanqiang.alphajson.JSONObject getJSONObject(String key) {
        return new FastJSONObject(object.getJSONObject(key));
    }

    @Override
    public JSONArray getJSONArray(String key) {
        return new FastJSONArray(object.getJSONArray(key));
    }

    @Override
    public Object getObject(String key) {
        return object.getJSONObject(key);
    }

    @Override
    public <T> T getObject(String key, Class<T> clazz) {
        return object.getObject(key, clazz);
    }

    @Override
    public int size() {
        return object.size();
    }

    @Override
    public boolean isEmpty() {
        return object.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return object.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return object.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return object.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return object.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return object.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        object.putAll(m);
    }

    @Override
    public void clear() {
        object.clear();
    }

    @Override
    public Set<String> keySet() {
        return object.keySet();
    }

    @Override
    public Collection<Object> values() {
        return object.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return object.entrySet();
    }
}
