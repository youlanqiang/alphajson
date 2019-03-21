package top.youlanqiang.alphajson.serialize.deobject;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 *
 */
public class KeyValue {


    private String keyName;

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
                ", type='" + value + '\'' +
                '}';
    }
}
