# AlphaJson
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c3c9b86ef0d24640b3f68c3a85e0ce91)](https://www.codacy.com/app/youlanqiang/alphajson?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=youlanqiang/alphajson&amp;utm_campaign=Badge_Grade)
由Java实现的JSON解析类库。

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
