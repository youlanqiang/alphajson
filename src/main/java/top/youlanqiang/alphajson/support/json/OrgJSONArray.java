package top.youlanqiang.alphajson.support.json;

import org.json.JSONArray;
import top.youlanqiang.alphajson.JSONException;
import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.utils.CastUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2019/1/19
 * @since 1.8
 */
public class OrgJSONArray implements top.youlanqiang.alphajson.JSONArray {

    private JSONArray array;

    public OrgJSONArray() {
        this.array = new JSONArray();
    }

    public OrgJSONArray(final JSONArray array) {
        this.array = array;
    }

    @Override
    public JSONObject getJSONObject(int index) {
        return new OrgJSONObject(array.getJSONObject(index));
    }

    @Override
    public top.youlanqiang.alphajson.JSONArray getJSONArray(int index) {
        return new OrgJSONArray(array.getJSONArray(index));
    }

    @Override
    public Byte getByte(int index) {
        return array.getNumber(index).byteValue();
    }

    @Override
    public Short getShort(int index) {
        return array.getNumber(index).shortValue();
    }

    @Override
    public Character getChar(int index) {
        return (char) array.getInt(index);
    }

    @Override
    public Integer getInt(int index) {
        return array.getInt(index);
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
        return CastUtil.castToDate(array.get(index));
    }

    @Override
    public Object getObject(int index) {
        return array.get(index);
    }

    @Override
    public <T> T getObject(int index, Class<T> clazz) {
        Object object = array.get(index);
        if(object.getClass() == clazz){
            return (T) object;
        }
        try {
           return CastUtil.cast(object, clazz);
        }catch(Exception e){
            throw new JSONException(e.getMessage());
        }
    }

    @Override
    public int size() {
        return array.toList().size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        for(Object obj : array){
            if(obj.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return array.iterator();
    }

    @Override
    public Object[] toArray() {
        return array.toList().toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return array.toList().toArray(a);
    }

    @Override
    public boolean add(Object o) {
        if(o!=null) {
            array.put(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return array.toList().remove(o);
    }

    @Override
    public boolean containsAll(Collection c) {
        return array.toList().containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        if (c != null && !c.isEmpty()) {
            array.put(c);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return array.toList().removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return array.toList().retainAll(c);
    }

    @Override
    public void clear() {
        array = new JSONArray();
    }

    public String toString() {
        return array.toString();
    }
}
