package test;

import top.youlanqiang.alphajson.JSONArray;
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
        //[{"deep":33,"json":23,"hello":123}]
        JSONObject object = new JSONObject();
        object.put("hello", 123);
        object.put("deep", 33);
        object.put("json", 23);
        JSONArray array = new JSONArray();
        array.addJSONObject(object);
        System.out.println(array.toString());
        JSONArray array1 = JSONArray.parse("[{\"deep\"\":3,3,\"json\":23,\"hello\":123]]");
        System.out.println(array1.toString());

    }
}
