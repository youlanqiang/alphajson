package entity;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public enum Country {
    chinese("中国", 1), japan("日本", 2);

    private String value;

    private int code;

    Country(String value, int code){
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
