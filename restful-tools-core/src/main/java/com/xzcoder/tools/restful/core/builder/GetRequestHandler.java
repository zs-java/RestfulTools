package com.xzcoder.tools.restful.core.builder;

import com.xzcoder.tools.restful.annotation.Get;
import com.xzcoder.tools.restful.annotation.RestClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author 朱帅
 * @date 2020-08-22 11:05 下午
 */
public class GetRequestHandler extends AbstractHttpRequestHandler {


    @Override
    public HttpUriRequest build(Object proxy, Method method, Object[] args) {
       try {
           Get getAnn = method.getDeclaredAnnotation(Get.class);
           String uri = getAnn.value();

           Class<?> clazz = method.getDeclaringClass();
           RestClient restClient = clazz.getDeclaredAnnotation(RestClient.class);
           String baseUrl = restClient.baseUrl();

           URIBuilder builder = new URIBuilder(baseUrl + uri);

           Map<String, Object> params = getMethodParams(proxy, method, args);

           params.forEach((k, v) -> builder.addParameter(k, (String) v));
           return new HttpGet(builder.build());
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public int order() {
        return -1;
    }

    @Override
    public boolean support(Method method) {
        return method.getDeclaredAnnotation(Get.class) != null;
    }

}
