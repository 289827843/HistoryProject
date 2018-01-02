package com.sxun.server.platform.service.ucenter.Util;

public class ResultMsg {


    private String key;
    private Object value;


    public ResultMsg() {

    }

    public ResultMsg(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
