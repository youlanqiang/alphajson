# AlphaJson
由Java实现的JSON解析类库，并没有太多功能，目前唯一优点是小巧。

- 支持JavaBean转JSON对象
- 支持数组转JSONArray
- 支持解析JSON字符串为JSON对象
- JSON对象转JavaBean对象

```$java
 //解析JSON字符串
 JSONObject json = JSONObject.parse("{\"user\":\"admin\"}");
 //JSON对象转JavaBean
 User user = JSONObject.parse("{\"user\":\"admin\"}", User.class);
 //JavaBean直接打印JSON字符串
 JSONObject.toString(javaBean);   
```
项目的还会持续添加特性和优化，直到完成第一个release版。

> write by youlanqiang
