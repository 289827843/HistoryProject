package com.sxun.server.platform.service.ucenter.dao;


import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.AuthCode;
import com.sxun.server.platform.service.ucenter.model.UcenterUserAuth;

public interface UcenterUserAuthMapper extends Mapper<UcenterUserAuth> {


    public void saveAuthCode(AuthCode authCode);


}