package top.youlanqiang.alphajson;

import top.youlanqiang.alphajson.serialize.JSONSerialize;
import top.youlanqiang.alphajson.serialize.ObjectSerializable;
import top.youlanqiang.alphajson.serialize.StringSerialize;

import java.util.Map;
import java.util.Set;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 */
public class JSONObject implements JSONSerialize {

    private Map<String,Object> map;


    public void put(String key, Object value){
        map.put(key, value);
    }

    public boolean isEmpty(){
        return map.isEmpty();
    }

    public Set<String>  keys(){
        return map.keySet();
    }

    public int size(){
        return map.size();
    }


    public Object getObjectValue(String key){
        if(map.containsKey(key)){
            return map.get(key);
        }
        return null;
    }

    public Float getFloatValue(String key){
        Object result = getObjectValue(key);
        if(result instanceof Number){
            return (Float) result;
        }
        return 0.0F;
    }

    public Double getDoubleValue(String key){
        Object result = getObjectValue(key);
        if(result instanceof Number){
            return (Double) result;
        }
        return 0.0;
    }

    public Long getLongValue(String key){
        Object result = getObjectValue(key);
        if(result instanceof Number){
            return (Long) result;
        }
        return 0L;
    }

    public Integer getIntegerValue(String key){
        Object result = getObjectValue(key);
        if(result instanceof Number){
            return (Integer) result;
        }
        return 0;
    }

    public Boolean getBooleanValue(String key){
        Object result = getObjectValue(key);
        if(result instanceof Boolean){
            return (Boolean) result;
        }
        return false;
    }

    public String  getStringValue(String key){
        Object result = getObjectValue(key);
        if(result != null){
            return result.toString();
        }
        return null;
    }

    /**
     * 可以将对象转换为对应对象的方法
     * @param object 待转换的对象
     * @param clazz 转换对象的类
     * @param <T>
     * @return
     */
    private <T> T transition(Object object, Class<T> clazz){
        //todo 该方法使用反射会发生异常,要使用其它方法.
        return null;
    }

    @Override
    public StringSerialize getSerialize() {
        return new ObjectSerializable(this);
    }
}
