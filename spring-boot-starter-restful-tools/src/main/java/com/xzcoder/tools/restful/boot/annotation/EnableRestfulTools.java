package com.xzcoder.tools.restful.boot.annotation;

import com.xzcoder.tools.restful.boot.core.RestClientsRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author 朱帅
 * @date 2020-08-21 11:51 下午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RestClientsRegistrar.class)
public @interface EnableRestfulTools {

    String EMPTY = "";

    @AliasFor("basePackage")
    String value() default EMPTY;

    @AliasFor("value")
    String basePackage() default EMPTY;

}
