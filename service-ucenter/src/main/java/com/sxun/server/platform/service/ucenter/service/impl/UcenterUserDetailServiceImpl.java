package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.platform.service.ucenter.dao.UcenterUserDetailMapper;
import com.sxun.server.platform.service.ucenter.model.UcenterUserDetail;
import com.sxun.server.platform.service.ucenter.service.UcenterUserDetailService;
import com.sxun.server.platform.service.ucenter.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/10.
 */
@Service
@Transactional
public class UcenterUserDetailServiceImpl extends AbstractService<UcenterUserDetail> implements UcenterUserDetailService {
    @Resource
    private UcenterUserDetailMapper ucenterUserDetailMapper;

}
