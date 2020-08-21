package com.xzcoder.tools.restful.annotation;

import java.lang.annotation.*;

/**
 * @author 朱帅
 * @date 2020-08-21 11:31 下午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestClient {

    String baseUrl() default "";

}
