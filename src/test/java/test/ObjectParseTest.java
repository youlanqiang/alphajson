package test;

import top.youlanqiang.alphajson.JSONObject;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/10
 * @since 1.8
 */
public class ObjectParseTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName("youlanqiang");
        user.setMan(false);
        user.setAge(10);
        String str = JSONObject.toString(user);
        User user1 = JSONObject.parse(str, User.class);
        System.out.println(JSONObject.toString(user1));
    }
}
