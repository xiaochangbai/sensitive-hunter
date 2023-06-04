package io.xiaochangbai.sensitive.common.annotation;

import java.lang.annotation.*;

/**
 * @author xiaochangbai
 * @date 2023-06-04 17:25
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadSafe {
}
