package json;

import com.google.common.collect.Maps;
import entity.Admin;
import entity.Autor;
import entity.User;
import org.junit.Test;
import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.serialize.deobject.JSONDeserializer;

import java.util.*;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/17
 * @since 1.8
 */
public class SerializeTest {

    public static String getJSONString(){
        return "{\"shuz1\":1,\"boolean\":false,\"user\":{\"name\":\"youlanqiang\",\"man\":false,\"autors\":[{\"admin\":{\"adminName\":\"admin1\",\"value\":\"boooss\"},\"point\":{\"4.43\":3.22,\"3.33\":3.33},\"name\":\"autor1\"},{\"admin\":{\"adminName\":\"admin2\",\"value\":\"1000dass\"},\"point\":{\"3.>>?\":1.33,\"???ww\":5.33},\"name\":\"autor2\"},{\"admin\":{\"adminName\":\"admin3\",\"value\":\"这个是为什么\"},\"point\":{\"7777777777\":7.7777,\"发生了什么\":0.0},\"name\":\"autor3\"},{\"admin\":{\"adminName\":\"77777\",\"value\":\"7了\"},\"point\":{\"jiade\":1.0,\"2,2\":2.33},\"name\":\"autor4\"}],\"age\":10}}\n";
    }

    public static User getUser(){
        User user = new User();
        user.setAge(10);
        user.setMan(false);
        user.setName("youlanqiang");
        List<Autor> list = new ArrayList<>();
        Autor autor1 = new Autor();
        autor1.setName("autor1");
        autor1.setAdmin(new Admin("admin1", "boooss"));
        Map<String, Double> map1 = Maps.newHashMap();
        map1.put("3.33", 3.33);
        map1.put("4.43", 3.22);
        autor1.setPoint(map1);
        Autor autor2 = new Autor();
        autor2.setName("autor2");
        autor2.setAdmin(new Admin("admin2", "1000dass"));
        Map<String, Double> map2 = Maps.newHashMap();
        map2.put("???ww", 5.33);
        map2.put("3.>>?", 1.33);
        autor2.setPoint(map2);
        Autor autor3 = new Autor();
        autor3.setName("autor3");
        autor3.setAdmin(new Admin("admin3", "这个是为什么"));
        Map<String, Double> map3 = Maps.newHashMap();
        map3.put("发生了什么", 0.0);
        map3.put("7777777777", 7.7777);
        autor3.setPoint(map3);
        Autor autor4 = new Autor();
        autor4.setName("autor4");
        autor4.setAdmin(new Admin("77777", "7了"));
        Map<String, Double> map4 = Maps.newHashMap();
        map4.put("jiade", 1.0);
        map4.put("2,2", 2.33);
        autor4.setPoint(map4);
        list.add(autor1);
        list.add(autor2);
        list.add(autor3);
        list.add(autor4);
        user.setAutors(list);
        return user;
    }


    /**
     * 测试JSONObject在复杂JSON下的字符串序列化
     * 测试通过
     */
    @Test
    public void test1(){
        JSONObject object = new JSONObject();
        object.put("shuz1", 1);
        object.put("boolean", false);
        object.put("user", getUser());
        System.out.println(object.toString());
        //{"shuz1":1,"boolean":false,"user":{"name":"youlanqiang","man":false,"autors":[{"admin":{"adminName":"admin1","value":"boooss"},"point":{"4.43":3.22,"3.33":3.33},"name":"autor1"},{"admin":{"adminName":"admin2","value":"1000dass"},"point":{"3.>>?":1.33,"???ww":5.33},"name":"autor2"},{"admin":{"adminName":"admin3","value":"这个是为什么"},"point":{"7777777777":7.7777,"发生了什么":0.0},"name":"autor3"},{"admin":{"adminName":"77777","value":"7了"},"point":{"jiade":1.0,"2,2":2.33},"name":"autor4"}],"age":10}}
    }

    /**
     * 测试JSONDeserializer的反序列化
     * 测试成功
     */
    @Test
    public void test2(){
        String str = getJSONString();
        Map<String, Object> object =  JSONDeserializer.parseToMap(str);
        System.out.println(object.get("shuz1"));
        System.out.println(JSONObject.toString(object));
    }


    /**
     * 测试JSON字符串反序列化为Object对象
     * 测试未通过
     */
    @Test
    public void test3(){
        User one =  JSONObject.parse(JSONObject.toString(getUser()), User.class);
        System.out.println(one.getAutors().size());
    }

    @Test
    public void test4(){
       JSONObject user = JSONObject.parse(getJSONString(), JSONObject.class);
        System.out.println(user);
    }

    /**
     * 正常
     */
    @Test
    public void test5(){
        Map<String, User> map = new HashMap<>();

        map.put("user", getUser());
        JSONArray.toString(map);
        System.out.println(JSONObject.toString(getUser()));
        System.out.println(JSONObject.toString(map));

    }
}
