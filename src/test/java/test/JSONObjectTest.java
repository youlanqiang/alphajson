package test;

import top.youlanqiang.alphajson.JSONObject;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/8
 * @since 1.8
 */
public class JSONObjectTest {

    public static void main(String[] args){
        JSONObject object = new JSONObject();
        object.put("number", 232323);
        object.put("hello", "youlanqiang");
        object.put("time", false);
        object.put("isNull", null);
        JSONObject object2 = new JSONObject();
        object2.put("good", "isGood");
        object.put("child", object2);
        System.out.println(object.toString());
    }

}
