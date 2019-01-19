package top.youlanqiang.alphajson.support.json;

import org.json.JSONObject;
import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.JSONException;
import top.youlanqiang.alphajson.utils.CastUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2019/1/19
 * @since 1.8
 */
public class OrgJSONObject implements top.youlanqiang.alphajson.JSONObject {

    private JSONObject object;

    public OrgJSONObject(){
        this.object = new JSONObject();
    }

    public OrgJSONObject(final JSONObject object){
        this.object = object;
    }

    @Override
    public Byte getByte(String key) {
        return object.getNumber(key).byteValue();
    }

    @Override
    public Short getShort(String key) {
        return object.getNumber(key).shortValue();
    }

    @Override
    public Character getChar(String key) {
        return  (char) object.getInt(key);
    }

    @Override
    public Integer getInteger(String key) {
        return object.getInt(key);
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
        return CastUtil.castToDate(key);
    }

    @Override
    public top.youlanqiang.alphajson.JSONObject getJSONObject(String key) {
        return new OrgJSONObject(object.getJSONObject(key));
    }

    @Override
    public JSONArray getJSONArray(String key) {
        return new OrgJSONArray(object.getJSONArray(key));
    }

    @Override
    public Object getObject(String key) {
        return object.get(key);
    }

    @Override
    public <T> T getObject(String key, Class<T> clazz) {
        Object result = object.get(key);
        if(result.getClass() == clazz){
            return (T) result;
        }
        try {
            return CastUtil.cast(result, clazz);
        }catch(Exception e){
            throw new JSONException(e.getMessage());
        }
    }

    @Override
    public int size() {
        return object.toMap().size();
    }

    @Override
    public boolean isEmpty() {
        return object.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return object.toMap().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return object.toMap().containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return object.get(key.toString());
    }

    @Override
    public Object put(String key, Object value) {
        return object.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return object.remove(key.toString());
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        object.toMap().putAll(m);
    }

    @Override
    public void clear() {
        object = new JSONObject();
    }

    @Override
    public Set<String> keySet() {
        return object.keySet();
    }

    @Override
    public Collection<Object> values() {
        return object.toMap().values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return object.toMap().entrySet();
    }

    public String toString(){
        return object.toString();
    }
}
