package com.washuu.eurekaserver.domain;

import java.io.Serializable;

public class BaseResult implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    public static BaseResult success(Integer code, String msg, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(code);
        baseResult.setData(data);
        baseResult.setMsg(msg);
        return baseResult;
    }

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
