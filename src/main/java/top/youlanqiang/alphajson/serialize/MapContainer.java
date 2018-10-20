package top.youlanqiang.alphajson.serialize;

import java.util.Map;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/12
 * @since 1.8
 *  对象是可以提供JSON属性键值对像
 */
public interface MapContainer {

    /**
     * 返回对象中的属性值
     * 属性名 和 属性对象
     * @return
     */
   Map<String, Object> getContainer();


   void setContainer(Map<String, Object> map);
}
