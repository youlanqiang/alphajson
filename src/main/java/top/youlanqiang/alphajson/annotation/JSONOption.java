package top.youlanqiang.alphajson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONOption {


    JSONEnableType type() default JSONEnableType.Show;


    String name() default "";
}
