package top.youlanqiang.alphajson;

import top.youlanqiang.alphajson.serialize.ArraySerializable;
import top.youlanqiang.alphajson.serialize.JSONSerialize;
import top.youlanqiang.alphajson.serialize.StringSerialize;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 */
public class JSONArray  implements JSONSerialize {


    @Override
    public StringSerialize getSerialize() {
        return new ArraySerializable(this);
    }
}
