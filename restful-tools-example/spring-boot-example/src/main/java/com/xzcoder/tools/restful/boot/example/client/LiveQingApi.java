package com.xzcoder.tools.restful.boot.example.client;

import com.xzcoder.tools.restful.annotation.Param;
import com.xzcoder.tools.restful.annotation.Post;
import com.xzcoder.tools.restful.annotation.RestClient;

/**
 * @author 朱帅
 * @date 2020-08-21 11:44 下午
 */
@RestClient(baseUrl = "http://127.0.0.1/liveqing")
public interface LiveQingApi {

    @Post("/live/stream")
    void getLiveStream(@Param("id") String id);

}
