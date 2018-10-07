package top.youlanqiang.alphajson.serialize;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 * JSON序列化接口
 */
public interface JSONSerialize {

    /**
     * 获取对象的解析器
     * @return
     */
    StringSerialize getSerialize();

}
