package top.youlanqiang.alphajson;

import top.youlanqiang.alphajson.serialize.DefaultJSONSerializer;
import top.youlanqiang.alphajson.utils.CastUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/17
 * @since 1.8
 * JSONArray是AlphaJSON的JSON数组对象
 * 内部实现为一个List来实现Collection的功能.
 */
public class JSONArray  implements Collection {

    private static final int CAPACITY = 20;

    private List<Object> list;


    public JSONArray(){
        this.list = new ArrayList<>(CAPACITY);
    }


    public JSONArray(int size){
        this.list = new ArrayList<>(size);
    }

    public JSONArray(List list){
        if(list != null) {
            this.list = list;
        }else{
            throw new NullPointerException("list is null");
        }
    }

    public static String toString(Object object){
        return DefaultJSONSerializer.operatorToObject(object);
    }


    /**
     * 获取一个下标对应的JSONObject对象
     * @param index 对应下标
     * @return JSONObject对象
     */
    public JSONObject getJSONObject(int index){
        return null;
    }

    public JSONArray getJSONArray(int index){
        return null;
    }

    public Byte getByte(int index){
        return CastUtil.castToByte(list.get(index));
    }


    public Short getShort(int index){
        return CastUtil.castToShort(list.get(index));
    }

    public Character getChar(int index){
        return CastUtil.castToChar(list.get(index));
    }

    public Integer getInt(int index){
        return CastUtil.castToInteger(list.get(index));
    }

    public Long getLong(int index){
        return CastUtil.castToLong(list.get(index));
    }

    public Float getFloat(int index){
        return CastUtil.castToFloat(list.get(index));
    }

    public Double getDouble(int index){
        return CastUtil.castToDouble(list.get(index));
    }

    public String getString(int index){
        return CastUtil.castToString(list.get(index));
    }

    public Boolean getBoolean(int index){
        return CastUtil.castToBoolean(list.get(index));
    }

    public Object getObject(int index){
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(Object o) {
        return list.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        return list.addAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        this.list = new ArrayList<>(CAPACITY);
    }


    @Override
    public String toString(){
        return DefaultJSONSerializer.operator(list);
    }
}
