package top.youlanqiang.alphajson.support.jackson;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2019/1/19
 * @since 1.8
 * todo 未完成
 */
public class JackJSONObject implements JSONObject {

    private ObjectMapper mapper;

    private ObjectNode node;

    public JackJSONObject(){
        this.mapper = new ObjectMapper();
        this.node = mapper.createObjectNode();
    }

    public JackJSONObject(final ObjectNode node){
        this.mapper = new ObjectMapper();
        this.node = node;
    }

    @Override
    public Byte getByte(String key) {
        return (byte) node.get(key).asInt();
    }

    @Override
    public Short getShort(String key) {
        return  node.get(key).shortValue();
    }

    @Override
    public Character getChar(String key) {
        return (char) node.get(key).asInt();
    }

    @Override
    public Integer getInteger(String key) {
        return node.get(key).asInt();
    }

    @Override
    public Long getLong(String key) {
        return node.get(key).asLong();
    }

    @Override
    public Float getFloat(String key) {
        return node.get(key).floatValue();
    }

    @Override
    public Double getDouble(String key) {
        return node.get(key).doubleValue();
    }

    @Override
    public String getString(String key) {
        return node.get(key).toString();
    }

    @Override
    public Boolean getBoolean(String key) {
        return node.get(key).booleanValue();
    }

    @Override
    public BigDecimal getBigDecimal(String key) {
        JsonNode result = node.get(key);
        if(result.isBigDecimal()) {
            return result.decimalValue();
        }
        return null;
    }

    @Override
    public BigInteger getBigInteger(String key) {
        JsonNode result = node.get(key);
        if(result.isBigInteger()) {
            return result.bigIntegerValue();
        }
        return null;
    }

    @Override
    public Date getDate(String key) {
        return null;
    }

    @Override
    public JSONObject getJSONObject(String key) {
        JsonNode result = node.get(key);
        if(result.isObject()){
            return new JackJSONObject((ObjectNode) result);
        }
        return null;
    }

    @Override
    public JSONArray getJSONArray(String key) {
        JsonNode result = node.get(key);
        if(result.isArray()){
            return new JackJSONArray((ArrayNode) result);
        }
        return null;
    }

    @Override
    public Object getObject(String key) {
        return node.get(key);
    }

    @Override
    public <T> T getObject(String key, Class<T> clazz) {
        return null;
    }

    @Override
    public int size() {
        return node.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(String key, Object value) {
        return node.putPOJO(key, value);
    }

    @Override
    public Object remove(Object key) {
        return node.remove(key.toString());
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Object> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return null;
    }

    public String toString(){
        return node.toString();
    }
}
