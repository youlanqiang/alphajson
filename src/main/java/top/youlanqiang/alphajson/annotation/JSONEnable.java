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
public @interface JSONEnable {

    JSONEnableType value() default JSONEnableType.Show;

}
