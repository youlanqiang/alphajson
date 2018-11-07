package top.youlanqiang.alphajson.serialize;

import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.serialize.ParseChain.ObjectToStringChain;
import top.youlanqiang.alphajson.utils.RailUtil;

import java.util.Collection;
import java.util.StringJoiner;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 */
public class  ArraySerializable implements StringSerialize {

    private Iterable array;

    private static final ObjectToStringChain chain = SerializeChainFactory.getChain();


    public ArraySerializable(Iterable array){
        super();
        this.array = array;
    }


    @Override
    public String operator() {
        StringJoiner joiner = new StringJoiner(",");
        for(Object object : array){
            joiner.add(chain.execute(object));
        }
        return RailUtil.jsonArray(joiner.toString());
    }
}
