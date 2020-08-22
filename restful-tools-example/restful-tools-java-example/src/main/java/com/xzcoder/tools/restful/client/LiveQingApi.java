package com.xzcoder.tools.restful.client;

import com.xzcoder.tools.restful.annotation.Get;
import com.xzcoder.tools.restful.annotation.Param;
import com.xzcoder.tools.restful.annotation.Post;
import com.xzcoder.tools.restful.annotation.RestClient;
import com.xzcoder.tools.restful.entity.LiveQingApiResult;

/**
 * @author 朱帅
 * @date 2020-08-21 11:44 下午
 */
@RestClient(baseUrl = "http://127.0.0.1:10080")
public interface LiveQingApi {

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码(经过md5加密,32位长度,不带中划线,不区分大小写)
     * @return result
     */
    @Get("/api/v1/login")
    LiveQingApiResult login(@Param("username") String username, @Param("password") String password);

    /**
     * 刷新播放加密地址
     * @param id 直播流Id（可选，不传递时刷新所有直播流）
     */
    @Post("/api/v1/refreshplaytoken")
    void refreshPlayToken(@Param(value = "id", require = false) String id);

    /**
     * 获取直播列表
     * @param pageIndex 数据起始位置
     * @param pageSize 分页大小
     * @return list
     */
    @Post("/api/v1/live/list")
    LiveQingApiResult listLives(@Param("start") Integer pageIndex, @Param("limit") Integer pageSize);

    /**
     * 直播流开关
     * @param id 直播流ID
     * @param actived 开启：true，关闭：false
     */
    @Post("/api/v1/live/turn/actived")
    void turnLiveActive(@Param("id") String id, @Param("actived") boolean actived);

}
