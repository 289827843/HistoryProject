package com.sxun.server.platform.service.ucenter.dao;


import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.ucenter.model.UcenterSession;

public interface UcenterSessionMapper extends Mapper<UcenterSession> {


    public UcenterSession findBySession_token(String token);

}