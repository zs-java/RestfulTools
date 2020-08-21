package com.xzcoder.tools.restful.core.handler;

import com.xzcoder.tools.restful.annotation.Param;
import com.xzcoder.tools.restful.annotation.Post;
import com.xzcoder.tools.restful.annotation.RestClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author 朱帅
 * @date 2020-08-22 12:23 上午
 */
public class RestApiInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Post postAnn = method.getDeclaredAnnotation(Post.class);
        String uri = postAnn.value();

        RestClient restClient = method.getDeclaringClass().getDeclaredAnnotation(RestClient.class);
        String baseUrl = restClient.baseUrl();

        Parameter[] parameters = method.getParameters();

        System.out.println("请求地址为：" + (baseUrl + uri));
        for (int i = 0; i < parameters.length; i++) {
            Parameter p = parameters[i];
            Param param = p.getDeclaredAnnotation(Param.class);
            String paramName = param.value();
            Object paramValue = args[i];
            System.out.println("请求参数：" + paramName + "=" + paramValue);
        }
        return null;
    }


}
