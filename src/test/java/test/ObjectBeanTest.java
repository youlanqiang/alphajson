package test;

import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.bean.SimpleObjectBean;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/30
 * @since 1.8
 */
public class ObjectBeanTest {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(10);
        user.setMan(false);
        user.setName("youlanqiang");
        JSONObject object = new JSONObject();
        object.put("user", user);
        System.out.println(object.toString());
    }
}
