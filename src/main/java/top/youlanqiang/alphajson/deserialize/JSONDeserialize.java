package top.youlanqiang.alphajson.deserialize;

import top.youlanqiang.alphajson.serialize.JSONSerialize;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 * JSON反序列化接口
 */
public interface JSONDeserialize {

    /**
     * 解析
     * @param context
     * @return
     */
    JSONSerialize parse(String context);

}
