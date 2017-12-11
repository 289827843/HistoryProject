package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.platform.service.ucenter.dao.UcenterUserMapper;
import com.sxun.server.platform.service.ucenter.model.UcenterUser;
import com.sxun.server.platform.service.ucenter.service.UcenterUserService;
import com.sxun.server.platform.service.ucenter.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/10.
 */
@Service
@Transactional
public class UcenterUserServiceImpl extends AbstractService<UcenterUser> implements UcenterUserService {
    @Resource
    private UcenterUserMapper ucenterUserMapper;


}
