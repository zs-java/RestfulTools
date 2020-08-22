package com.xzcoder.tools.restful.annotation;

import java.lang.annotation.*;

/**
 * @author 朱帅
 * @date 2020-08-21 11:29 下午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Get {

    String value();

}
