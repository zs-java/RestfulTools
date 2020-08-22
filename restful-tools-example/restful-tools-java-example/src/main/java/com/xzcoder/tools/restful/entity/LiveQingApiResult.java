package com.xzcoder.tools.restful.entity;

import java.io.Serializable;

/**
 * @author 朱帅
 * @date 2020-08-22 2:07 下午
 */
public class LiveQingApiResult implements Serializable {

    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
