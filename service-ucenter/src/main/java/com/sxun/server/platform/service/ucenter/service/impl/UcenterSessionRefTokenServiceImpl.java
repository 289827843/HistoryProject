package com.sxun.server.platform.service.ucenter.service.impl;


import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.dao.UcenterSessionRefTokenMapper;
import com.sxun.server.platform.service.ucenter.model.UcenterSessionRefToken;
import com.sxun.server.platform.service.ucenter.service.UcenterSessionRefTokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2017/12/16.
 */
@Service
@Transactional
public class UcenterSessionRefTokenServiceImpl extends AbstractService<UcenterSessionRefToken> implements UcenterSessionRefTokenService {
    @Resource
    private UcenterSessionRefTokenMapper ucenterSessionRefTokenMapper;

}
