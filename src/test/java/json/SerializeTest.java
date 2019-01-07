package json;

import chain.BigDecimalChain;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import entity.*;
import org.junit.Assert;
import org.junit.Test;
import top.youlanqiang.alphajson.JSONArray;
import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.serialize.deobject.JSONDeserializer;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/17
 * @since 1.8
 */
public class SerializeTest {

    public static String getJSONString() {
        return "{\"shuz1\":1,\"boolean\":false,\"user\":{\"name\":\"youlanqiang\",\"man\":false,\"autors\":[{\"admin\":{\"adminName\":\"admin1\",\"value\":\"boooss\"},\"point\":{\"4.43\":3.22,\"3.33\":3.33},\"name\":\"autor1\"},{\"admin\":{\"adminName\":\"admin2\",\"value\":\"1000dass\"},\"point\":{\"3.>>?\":1.33,\"???ww\":5.33},\"name\":\"autor2\"},{\"admin\":{\"adminName\":\"admin3\",\"value\":\"这个是为什么\"},\"point\":{\"7777777777\":7.7777,\"发生了什么\":0.0},\"name\":\"autor3\"},{\"admin\":{\"adminName\":\"77777\",\"value\":\"7了\"},\"point\":{\"jiade\":1.0,\"2,2\":2.33},\"name\":\"autor4\"}],\"age\":10}}\n";
    }

    public static User getUser() {
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
    public void testForHardJson() {
        JSONObject object = new JSONObject();
        object.put("shuz1", 1);
        object.put("boolean", false);
        object.put("user", getUser());
        Assert.assertEquals(object.toString(), "{\"shuz1\":1,\"boolean\":false,\"user\":{\"name\":\"youlanqiang\",\"man\":false,\"autors\":[{\"admin\":{\"adminName\":\"admin1\",\"value\":\"boooss\"},\"point\":{\"4.43\":3.22,\"3.33\":3.33},\"name\":\"autor1\"},{\"admin\":{\"adminName\":\"admin2\",\"value\":\"1000dass\"},\"point\":{\"3.>>?\":1.33,\"???ww\":5.33},\"name\":\"autor2\"},{\"admin\":{\"adminName\":\"admin3\",\"value\":\"这个是为什么\"},\"point\":{\"7777777777\":7.7777,\"发生了什么\":0.0},\"name\":\"autor3\"},{\"admin\":{\"adminName\":\"77777\",\"value\":\"7了\"},\"point\":{\"jiade\":1.0,\"2,2\":2.33},\"name\":\"autor4\"}],\"age\":10}}");
        //{"shuz1":1,"boolean":false,"user":{"name":"youlanqiang","man":false,"autors":[{"admin":{"adminName":"admin1","value":"boooss"},"point":{"4.43":3.22,"3.33":3.33},"name":"autor1"},{"admin":{"adminName":"admin2","value":"1000dass"},"point":{"3.>>?":1.33,"???ww":5.33},"name":"autor2"},{"admin":{"adminName":"admin3","value":"这个是为什么"},"point":{"7777777777":7.7777,"发生了什么":0.0},"name":"autor3"},{"admin":{"adminName":"77777","value":"7了"},"point":{"jiade":1.0,"2,2":2.33},"name":"autor4"}],"age":10}}
    }

    /**
     * 测试JSONDeserializer的反序列化
     * 测试成功
     */
    @Test
    public void testForJSONDeserializer() {
        String str = getJSONString();
        Map<String, Object> object = JSONDeserializer.parseToJSONObject(str);
        Assert.assertEquals(object.get("shuz1"), 1L);
        Assert.assertEquals(JSONObject.toString(object), "{\"shuz1\":1,\"boolean\":false,\"user\":{\"name\":\"youlanqiang\",\"man\":false,\"autors\":[{\"name\":\"autor1\",\"admin\":{\"adminName\":\"admin1\",\"value\":\"boooss\"},\"point\":{\"4.43\":3.22,\"3.33\":3.33}},{\"name\":\"autor2\",\"admin\":{\"adminName\":\"admin2\",\"value\":\"1000dass\"},\"point\":{\"3.>>?\":1.33,\"???ww\":5.33}},{\"name\":\"autor3\",\"admin\":{\"adminName\":\"admin3\",\"value\":\"这个是为什么\"},\"point\":{\"7777777777\":7.7777,\"发生了什么\":0.0}},{\"name\":\"autor4\",\"admin\":{\"adminName\":\"77777\",\"value\":\"7了\"},\"point\":{\"jiade\":1.0,\"2,2\":2.33}}],\"age\":10}}");
    }


    /**
     * 测试JSON字符串反序列化为Object对象
     * 测试通过
     */
    @Test
    public void testForJSON2Object() {
        User one = JSONObject.parse(JSONObject.toString(getUser()), User.class);
        Assert.assertFalse(one.getAutors().isEmpty());
        Assert.assertEquals(JSONObject.toString(one), "{\"name\":\"youlanqiang\",\"man\":false,\"autors\":[{\"admin\":{\"adminName\":\"admin1\",\"value\":\"boooss\"},\"point\":{\"4.43\":3.22,\"3.33\":3.33},\"name\":\"autor1\"},{\"admin\":{\"adminName\":\"admin2\",\"value\":\"1000dass\"},\"point\":{\"3.>>?\":1.33,\"???ww\":5.33},\"name\":\"autor2\"},{\"admin\":{\"adminName\":\"admin3\",\"value\":\"这个是为什么\"},\"point\":{\"7777777777\":7.7777,\"发生了什么\":0.0},\"name\":\"autor3\"},{\"admin\":{\"adminName\":\"77777\",\"value\":\"7了\"},\"point\":{\"jiade\":1.0,\"2,2\":2.33},\"name\":\"autor4\"}],\"age\":10}");
    }

    @Test
    public void testForJSONObjectParse() {
        JSONObject user = JSONObject.parse(getJSONString(), JSONObject.class);
        Assert.assertEquals(user.toString(), "{\"shuz1\":1,\"boolean\":false,\"user\":{\"name\":\"youlanqiang\",\"man\":false,\"autors\":[{\"name\":\"autor1\",\"admin\":{\"adminName\":\"admin1\",\"value\":\"boooss\"},\"point\":{\"4.43\":3.22,\"3.33\":3.33}},{\"name\":\"autor2\",\"admin\":{\"adminName\":\"admin2\",\"value\":\"1000dass\"},\"point\":{\"3.>>?\":1.33,\"???ww\":5.33}},{\"name\":\"autor3\",\"admin\":{\"adminName\":\"admin3\",\"value\":\"这个是为什么\"},\"point\":{\"7777777777\":7.7777,\"发生了什么\":0.0}},{\"name\":\"autor4\",\"admin\":{\"adminName\":\"77777\",\"value\":\"7了\"},\"point\":{\"jiade\":1.0,\"2,2\":2.33}}],\"age\":10}}");
    }

    /**
     * 正常
     */
    @Test
    public void testForJSON2String() {
        Map<String, User> map = new HashMap<>();

        map.put("user", getUser());
        Assert.assertEquals(JSONObject.toString(getUser()), "{\"name\":\"youlanqiang\",\"man\":false,\"autors\":[{\"admin\":{\"adminName\":\"admin1\",\"value\":\"boooss\"},\"point\":{\"4.43\":3.22,\"3.33\":3.33},\"name\":\"autor1\"},{\"admin\":{\"adminName\":\"admin2\",\"value\":\"1000dass\"},\"point\":{\"3.>>?\":1.33,\"???ww\":5.33},\"name\":\"autor2\"},{\"admin\":{\"adminName\":\"admin3\",\"value\":\"这个是为什么\"},\"point\":{\"7777777777\":7.7777,\"发生了什么\":0.0},\"name\":\"autor3\"},{\"admin\":{\"adminName\":\"77777\",\"value\":\"7了\"},\"point\":{\"jiade\":1.0,\"2,2\":2.33},\"name\":\"autor4\"}],\"age\":10}");
        Assert.assertEquals(JSONObject.toString(map), "{\"user\":{\"name\":\"youlanqiang\",\"man\":false,\"autors\":[{\"admin\":{\"adminName\":\"admin1\",\"value\":\"boooss\"},\"point\":{\"4.43\":3.22,\"3.33\":3.33},\"name\":\"autor1\"},{\"admin\":{\"adminName\":\"admin2\",\"value\":\"1000dass\"},\"point\":{\"3.>>?\":1.33,\"???ww\":5.33},\"name\":\"autor2\"},{\"admin\":{\"adminName\":\"admin3\",\"value\":\"这个是为什么\"},\"point\":{\"7777777777\":7.7777,\"发生了什么\":0.0},\"name\":\"autor3\"},{\"admin\":{\"adminName\":\"77777\",\"value\":\"7了\"},\"point\":{\"jiade\":1.0,\"2,2\":2.33},\"name\":\"autor4\"}],\"age\":10}}");

    }

    /**
     * 测试时间和HastSet解析和反序列化操作
     * 测试通过
     */
    @Test
    public void testForHashSetParse() {
        TimeCarryer carryer = new TimeCarryer();
        carryer.setIns(Sets.newHashSet(1, 2, 3, 4));
        carryer.setTime(new Date());
        carryer.setName("first");
        String jsonStr = JSONObject.toString(carryer);
        Assert.assertTrue(jsonStr.trim().length() != 0);
        TimeCarryer tie = JSONObject.parse(jsonStr, TimeCarryer.class);
        Assert.assertTrue(JSONObject.toString(tie).trim().length() != 0);
    }

    /**
     * 测试自定义ObjectToStringChain
     */
    @Test
    public void testForUserOptionObjectToStringChain() {
        BankMan man = new BankMan();
        man.setName("youlanqiang");
        man.setMoney(BigDecimal.valueOf(20.0));
        Assert.assertEquals(JSONObject.toString(man, new BigDecimalChain()), "{\"stack\":null,\"money\":\"金钱\",\"name\":\"youlanqiang\",\"queue\":null}");
    }

    @Test
    public void testForString2Object() {
        String json = "{\"stack\":[\"one\",\"two\"],\"money\":null,\"name\":null,\"queue\":[100,200]}";
        JSONObject object = JSONObject.parse(json);
        Assert.assertEquals(object.toString(), "{\"stack\":[\"one\",\"two\"],\"money\":null,\"name\":null,\"queue\":[100,200]}");
    }

    /**
     * JSON序列化和反序列化 Stack,Queue测试
     * 测试通过
     */
    @Test
    public void testForStackAndQueue() {
        BankMan man = new BankMan();
        man.setMoney(null);
        man.setName(null);
        man.setQueue(null);
        man.setStack(null);
        String json = JSONObject.toString(man);
        Assert.assertEquals(json, "{\"stack\":null,\"money\":null,\"name\":null,\"queue\":null}");
        //{"stack":null,"money":null,"name":null,"queue":null}
        BankMan newMan = JSONObject.parse(json, BankMan.class);
        Assert.assertEquals(JSONObject.toString(newMan), "{\"stack\":null,\"money\":null,\"name\":null,\"queue\":null}");
        //{"stack":null,"money":null,"name":null,"queue":null}
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(100);
        queue.add(200);
        Stack<String> stack = new Stack<>();
        stack.add("one\"");
        stack.add("two");
        newMan.setStack(stack);
        newMan.setQueue(queue);
        String newJson = JSONObject.toString(newMan);
        Assert.assertEquals(newJson, "{\"stack\":[\"one\"\",\"two\"],\"money\":null,\"name\":null,\"queue\":[100,200]}");
        //{"stack":["one","two"],"money":null,"name":null,"queue":[100,200]}
        BankMan man2 = JSONObject.parse(newJson, BankMan.class);
        Assert.assertEquals(man2.getStack().toString(), "[one\", two]");
        Assert.assertEquals(man2.getQueue().toString(), "[100, 200]");
    }


    /**
     * 测试枚举类型序列化
     */
    @Test
    public void testForEnumParse() {
        JSONObject object = new JSONObject();
        Country c = Country.chinese;
        object.put("enum", c);
        Assert.assertEquals(object.toString(), "{\"enum\":\"chinese\"}");
        JSONObject c2 = JSONObject.parse(object.toString());
        Assert.assertEquals(c2.getObject("enum", Country.class), Country.chinese);
    }

    /**
     * 测试内部类和多重List泛型序列化
     */
    @Test
    public void testForIntoClass(){
        Into<Boolean> into = new Into<>();
        Into<Boolean>.IntoBase intoBase = into.new IntoBase();
        intoBase.setName("name");
        intoBase.setIn(false);
        List<List<Boolean>> list = new ArrayList<>();
        list.add(Arrays.asList(false,true,false,true));
        list.add(Arrays.asList(false,true,false,true));
        list.add(Arrays.asList(false,true,false,true));
        into.setIntoBase(intoBase);
        into.setIninList(list);
        Assert.assertEquals(JSONObject.toString(into), "{\"intoBase\":{\"in\":false,\"name\":\"name\"},\"ininList\":[[false,true,false,true],[false,true,false,true],[false,true,false,true]]}");
        JSONObject object = JSONObject.parse("{\"intoBase\":{\"in\":false,\"name\":\"name\"},\"ininList\":[[false,true,false,true],[false,true,false,true],[false,true,false,true]]}");
        JSONObject base = object.getJSONObject("intoBase");
        Assert.assertEquals(base.toString(), "{\"in\":false,\"name\":\"name\"}");
        JSONArray array = object.getJSONArray("ininList");
         Assert.assertEquals(array.toString(), "[[false,true,false,true],[false,true,false,true],[false,true,false,true]]");
    }

}
