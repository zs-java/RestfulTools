package com.xzcoder.tools.restful.core.builder;

import com.xzcoder.tools.restful.annotation.Param;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱帅
 * @date 2020-08-22 11:03 下午
 */
public abstract class AbstractHttpRequestHandler implements HttpRequestHandler {


    protected Map<String, Object> getMethodParams(Object proxy, Method method, Object[] args) {

        try {
            Map<String, Object> params = new HashMap<>();

            Parameter[] parameters = method.getParameters();

            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                Param paramAnn = parameter.getDeclaredAnnotation(Param.class);

                if (paramAnn == null) {
                    Object arg = args[i];

                    Class<?> clazz = arg.getClass();
                    //获得属性
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                        //获得get方法
                        Method getMethod = pd.getReadMethod();
                        //执行get方法返回一个Object
                        Object value = getMethod.invoke(clazz);
                        String name = field.getName();

                        if (!params.containsKey(name)) {

                            params.put(name, value);

                        }

                    }


                } else {
                    boolean require = paramAnn.require();
                    String name = paramAnn.value();

                    params.put(name, args[i]);
                }

            }

            return params;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
