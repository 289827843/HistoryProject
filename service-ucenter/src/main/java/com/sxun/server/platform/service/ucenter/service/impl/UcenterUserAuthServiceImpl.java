package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.Util.Tools;
import com.sxun.server.platform.service.ucenter.dao.UcenterUserAuthMapper;
import com.sxun.server.platform.service.ucenter.model.UcenterUserAuth;
import com.sxun.server.platform.service.ucenter.service.UcenterUserAuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2017/12/10.
 */
@Service
@Transactional
public class UcenterUserAuthServiceImpl extends AbstractService<UcenterUserAuth> implements UcenterUserAuthService {
    @Resource
    private UcenterUserAuthMapper ucenterUserAuthMapper;

    @Override
    public String getAuthCode() {

        return Tools.getAuthCode();
    }
}
