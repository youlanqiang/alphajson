package top.youlanqiang.alphajson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/12/9
 * @since 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONOption {

    /**
     * json显示方式
     * @return
     */
    JSONEnableType type() default JSONEnableType.Show;

    /**
     * json字段名称
     * @return
     */
    String name() default "";
}
