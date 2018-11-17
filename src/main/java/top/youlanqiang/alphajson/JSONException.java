package top.youlanqiang.alphajson;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/17
 * @since 1.8
 * JSON序列化或反序列化时出错抛出的异常
 */
public class JSONException extends RuntimeException {

    public JSONException(String message){
        super(message);
    }
}
