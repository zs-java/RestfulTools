package com.xzcoder.tools.restful.boot.example;

import com.xzcoder.tools.restful.boot.annotation.EnableRestfulTools;
import com.xzcoder.tools.restful.boot.example.client.LiveQingApi;
import com.xzcoder.tools.restful.core.RestfulTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱帅
 * @date 2020-08-21 11:42 下午
 */
@SpringBootApplication
@EnableRestfulTools("com.xzcoder.tools.restful.boot.example.client")
@RestController
public class RestfulToolsApp {

    @GetMapping("/get")
    public void get(@RequestParam("id") String id) {

        LiveQingApi liveQingApi = RestfulTools.getClient(LiveQingApi.class);

        liveQingApi.getLiveStream(id);
    }


    public static void main(String[] args) {
        SpringApplication.run(RestfulToolsApp.class, args);
    }

}
