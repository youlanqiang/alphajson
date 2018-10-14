package test;

import top.youlanqiang.alphajson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/14
 * @since 1.8
 */
public class JSONArrayTest {

    public static void main(String[] args){
        JSONObject object = new JSONObject();
        List<String> list = new ArrayList<>();
        list.add("12312");
        list.add("hello");
        list.add("goods");
        object.put("list", list);
        System.out.println(object.toString());
    }
}
