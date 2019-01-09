package top.youlanqiang.alphajson;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2019/1/9
 * @since 1.8
 */
public interface JSONArray extends Collection {

    JSONObject getJSONObject(int index);

    JSONArray getJSONArray(int index);

    Byte getByte(int index);

    Short getShort(int index);

    Character getChar(int index);

    Integer getInt(int index);

    Long getLong(int index);

    Float getFloat(int index);

    Double getDouble(int index);

    String getString(int index);

    Boolean getBoolean(int index);

    BigDecimal getBigDecimal(int index);

    BigInteger getBigInteger(int index);

    Date getDate(int index);

    Object getObject(int index);

    <T> T getObject(int index, Class<T> clazz);
}
