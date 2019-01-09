package top.youlanqiang.alphajson;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2019/1/9
 * @since 1.8
 */
public interface JSONObject extends  Map<String, Object> {

    Byte getByte(String key);

    Short getShort(String key);

    Character getChar(String key);

    Integer getInteger(String key);

    Long getLong(String key);

    Float getFloat(String key);

     Double getDouble(String key);

    String getString(String key);

    Boolean getBoolean(String key);

    BigDecimal getBigDecimal(String key);

    BigInteger getBigInteger(String key);

    Date getDate(String key);

    JSONObject getJSONObject(String key);

    JSONArray getJSONArray(String key);

    Object getObject(String key);

    <T> T getObject(String key, Class<T> clazz);
}
