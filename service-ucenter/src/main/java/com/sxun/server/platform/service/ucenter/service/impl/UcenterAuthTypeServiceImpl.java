package com.sxun.server.platform.service.ucenter.service.impl;
import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.dao.UcenterAuthTypeMapper;
import com.sxun.server.platform.service.ucenter.model.UcenterAuthType;
import com.sxun.server.platform.service.ucenter.service.UcenterAuthTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2017/12/10.
 */
@Service
@Transactional
public class UcenterAuthTypeServiceImpl extends AbstractService<UcenterAuthType> implements UcenterAuthTypeService {
    @Resource
    private UcenterAuthTypeMapper ucenterAuthTypeMapper;

}
