package top.youlanqiang.alphajson.exception;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/3
 * @since 1.8
 * 没有发现JSON字符抛出的异常
 */
public class NotJsonFieldException extends RuntimeException{

    public NotJsonFieldException(String field){
        super("没有这个字段:" + field);
    }

}
