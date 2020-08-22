package com.xzcoder.tools.restful.core.builder;

import org.apache.http.client.methods.HttpUriRequest;

import java.lang.reflect.Method;

/**
 * @author 朱帅
 * @date 2020-08-22 11:08 下午
 */
public interface HttpRequestHandler {

    HttpUriRequest build(Object proxy, Method method, Object[] args);

    int order();

    boolean support(Method method);

}
