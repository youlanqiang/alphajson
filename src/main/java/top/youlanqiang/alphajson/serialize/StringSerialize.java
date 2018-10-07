package top.youlanqiang.alphajson.serialize;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 * 实现该接口的类可以将javabean转换为String类型
 */
public interface StringSerialize {

    /**
     * 将对象转化为String字符串
     * @return
     */
    String operator();


}
