package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.platform.service.ucenter.dao.UcenterUserLogMapper;
import com.sxun.server.platform.service.ucenter.model.UcenterUserLog;
import com.sxun.server.platform.service.ucenter.service.UcenterUserLogService;
import com.sxun.server.platform.service.ucenter.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/10.
 */
@Service
@Transactional
public class UcenterUserLogServiceImpl extends AbstractService<UcenterUserLog> implements UcenterUserLogService {
    @Resource
    private UcenterUserLogMapper ucenterUserLogMapper;

}
