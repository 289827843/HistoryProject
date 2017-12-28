package com.sxun.server.platform.service.ucenter.service;


import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.model.UcenterUserAuth;

/**
 * Created by CodeGenerator on 2017/12/10.
 */
public interface UcenterUserAuthService extends Service<UcenterUserAuth> {


    public String getAuthCode();



}
