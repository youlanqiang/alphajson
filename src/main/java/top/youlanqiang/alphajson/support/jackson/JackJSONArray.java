package top.youlanqiang.alphajson.support.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.JSONException;
import top.youlanqiang.alphajson.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2019/1/19
 * @since 1.8
 * todo 未完成
 */
public class JackJSONArray implements JSONArray {

    private ObjectMapper mapper;

    private ArrayNode node;

    public JackJSONArray(){
        this.mapper = new ObjectMapper();
        this.node = mapper.createArrayNode();
    }

    public JackJSONArray(final ArrayNode node){
        this.mapper = new ObjectMapper();
        this.node = node;
    }

    @Override
    public JSONObject getJSONObject(int index) {
        return null;
    }

    @Override
    public JSONArray getJSONArray(int index) {
        return null;
    }

    @Override
    public Byte getByte(int index) {
        return null;
    }

    @Override
    public Short getShort(int index) {
        return null;
    }

    @Override
    public Character getChar(int index) {
        return null;
    }

    @Override
    public Integer getInt(int index) {
        return null;
    }

    @Override
    public Long getLong(int index) {
        return null;
    }

    @Override
    public Float getFloat(int index) {
        return null;
    }

    @Override
    public Double getDouble(int index) {
        return null;
    }

    @Override
    public String getString(int index) {
        return null;
    }

    @Override
    public Boolean getBoolean(int index) {
        return null;
    }

    @Override
    public BigDecimal getBigDecimal(int index) {
        return null;
    }

    @Override
    public BigInteger getBigInteger(int index) {
        return null;
    }

    @Override
    public Date getDate(int index) {
        return null;
    }

    @Override
    public Object getObject(int index) {
        return null;
    }

    @Override
    public <T> T getObject(int index, Class<T> clazz) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        // no-do
        throw new JSONException("Jackson can't use removeAll");
    }

    @Override
    public boolean retainAll(Collection c) {
        // no-do
        throw new JSONException("Jackson can't use retainAll");
    }

    @Override
    public void clear() {
        node = mapper.createArrayNode();
    }
}
