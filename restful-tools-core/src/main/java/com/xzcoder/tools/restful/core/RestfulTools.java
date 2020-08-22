package com.xzcoder.tools.restful.core;

import com.xzcoder.tools.restful.core.handler.RestApiInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author 朱帅
 * @date 2020-08-22 12:38 上午
 */
public class RestfulTools {

    @SuppressWarnings("all")
    public static <T> T getClient(Class<T> clazz) {
        Object client = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new RestApiInvocationHandler());
        return (T) client;
    }

    public static Object getClient(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new RestApiInvocationHandler());
    }

}
