package top.youlanqiang.alphajson.exception;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/30
 * @since 1.8
 */
public class NotInstanceFunctionException extends RuntimeException {

    public NotInstanceFunctionException(Class clazz){
        super(clazz.getName() + ":类必须要有一个无参构造器!");
    }

}
