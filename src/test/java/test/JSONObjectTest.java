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
        object.put("number",232323);
        System.out.println(object.getLongValue("number"));
    }

}
