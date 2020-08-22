package com.xzcoder.tools.restful.annotation;

import java.lang.annotation.*;

/**
 * @author 朱帅
 * @date 2020-08-22 12:16 上午
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Param {

    String value();

    boolean require() default true;

}
