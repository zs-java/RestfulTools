package com.xzcoder.tools.restful;

import com.xzcoder.tools.restful.client.LiveQingApi;
import com.xzcoder.tools.restful.core.RestfulTools;

/**
 * @author 朱帅
 * @date 2020-08-22 1:41 下午
 */
public class App {

    public static void main(String[] args) {

        LiveQingApi client = RestfulTools.getClient(LiveQingApi.class);

        client.refreshPlayToken("test");

    }

}
