package top.youlanqiang.alphajson.deserialize;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/19
 * @since 1.8
 */
public class DeserizlizeToken {


    private Object data;

    private int limit;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "DeserizlizeToken{" +
                "data=" + data +
                ", limit=" + limit +
                '}';
    }
}
