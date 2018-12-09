package top.youlanqiang.alphajson.annotation;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/12/9
 * @since 1.8
 */
public enum JSONEnableType {

    /**
     * 字段只能被序列化为JSON
     */
    Serialize,
    /**
     * 字段只能被反序列化为JavaBean
     */
    Deserialize,
    /**
     * 字段忽略
     */
    Igonre,
    /**
     * 字段可以被序列化和反序列化
     */
    Show


}
