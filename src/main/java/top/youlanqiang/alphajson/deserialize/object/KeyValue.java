package top.youlanqiang.alphajson.deserialize.object;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/21
 * @since 1.8
 *
 * 解析JSONObject对象的键值对
 */
public class KeyValue {

    /**
     * 主键名称
     */
    private String keyName;

    /**
     * 值
     */
    private String value;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "keyName='" + keyName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
