package top.youlanqiang.alphajson.serialize.ParseChain;


import top.youlanqiang.alphajson.bean.SimpleObjectBean;
import top.youlanqiang.alphajson.serialize.ObjectSerializable;
import top.youlanqiang.alphajson.utils.RailUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/14
 * @since 1.8
 * 数组类型解析器
 */
public class ArrayChain extends ObjectToStringChain {

    public ArrayChain(ObjectToStringChain chain){
        this.next = chain;
    }

    @Override
    public String execute(Object object) {

        if(object instanceof Object[]){
            List list =  Arrays.asList((Object[]) object);
            return toListString(list);
        }

        if(object instanceof Collection){
            return toListString((Collection) object);
        }


        return next.execute(object);
    }

    /**
     * 解析为Array类型的字符串
     * @param list
     * @return
     */
    private String toListString(Collection list){
        StringJoiner joiner = new StringJoiner(",");
        for(Object object : list){
            ObjectSerializable serializable = new ObjectSerializable(new SimpleObjectBean(object));
            joiner.add(serializable.operator());
        }
        return RailUtil.jsonArray(joiner.toString());
    }
}
