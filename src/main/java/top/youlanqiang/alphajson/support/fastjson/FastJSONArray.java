package top.youlanqiang.alphajson.support.fastjson;

import com.alibaba.fastjson.JSONArray;
import top.youlanqiang.alphajson.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2019/1/10
 * @since 1.8
 */
public class FastJSONArray implements top.youlanqiang.alphajson.JSONArray {

    private JSONArray array;

    public FastJSONArray(){
        this.array = new JSONArray();
    }

    public FastJSONArray(final JSONArray array){
        this.array = array;
    }

    @Override
    public JSONObject getJSONObject(int index) {
        return new FastJSONObject(array.getJSONObject(index));
    }

    @Override
    public top.youlanqiang.alphajson.JSONArray getJSONArray(int index) {
        return new FastJSONArray(array.getJSONArray(index));
    }

    @Override
    public Byte getByte(int index) {
        return array.getByte(index);
    }

    @Override
    public Short getShort(int index) {
        return array.getShort(index);
    }

    @Override
    public Character getChar(int index) {
        //no-do
        return null;
    }

    @Override
    public Integer getInt(int index) {
        return array.getInteger(index);
    }

    @Override
    public Long getLong(int index) {
        return array.getLong(index);
    }

    @Override
    public Float getFloat(int index) {
        return array.getFloat(index);
    }

    @Override
    public Double getDouble(int index) {
        return array.getDouble(index);
    }

    @Override
    public String getString(int index) {
        return array.getString(index);
    }

    @Override
    public Boolean getBoolean(int index) {
        return array.getBoolean(index);
    }

    @Override
    public BigDecimal getBigDecimal(int index) {
        return array.getBigDecimal(index);
    }

    @Override
    public BigInteger getBigInteger(int index) {
        return array.getBigInteger(index);
    }

    @Override
    public Date getDate(int index) {
        return array.getDate(index);
    }

    @Override
    public Object getObject(int index) {
        return array.getJSONObject(index);
    }

    @Override
    public <T> T getObject(int index, Class<T> clazz) {
        return array.getObject(index, clazz);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return array.contains(o);
    }

    @Override
    public Iterator iterator() {
        return array.iterator();
    }

    @Override
    public Object[] toArray() {
        return array.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return array.toArray(a);
    }

    @Override
    public boolean add(Object o) {
        return array.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return array.remove(o);
    }

    @Override
    public boolean containsAll(Collection c) {
        return array.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        return array.addAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return array.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return array.retainAll(c);
    }

    @Override
    public void clear() {
        array.clear();
    }
}
