package com.sxun.server.platform.service.ucenter.service;

public interface RedisService {

    public void set(String key, Object value);

    public Object get(String key);

}