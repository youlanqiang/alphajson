# AlphaJson(该项目已完成，不会进行任何BUG修复和更新)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7e04b1f3b8a84959a6a0fbea77293e1a)](https://www.codacy.com/app/youlanqiang/alphajson?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=youlanqiang/alphajson&amp;utm_campaign=Badge_Grade)
[![Build Status](https://www.travis-ci.org/youlanqiang/alphajson.svg?branch=master)](https://www.travis-ci.org/youlanqiang/alphajson)

由Java实现的JSON解析类库。

-   支持JavaBean转JSON对象
-   支持数组转JSONArray
-   支持解析JSON字符串为JSON对象
-   JSON对象转JavaBean对象


```$java
 //解析JSON字符串
 JSONObject json = JSONObject.parse("{\"user\":\"admin\"}");
 //JSON对象转JavaBean
 User user = JSONObject.parse("{\"user\":\"admin\"}", User.class);
 //JavaBean直接打印JSON字符串
 JSONObject.toString(javaBean);   
```


> write by youlanqiang
