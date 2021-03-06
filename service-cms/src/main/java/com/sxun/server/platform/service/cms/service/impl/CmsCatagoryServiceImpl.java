package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.platform.service.cms.dao.CmsCatagoryMapper;
import com.sxun.server.platform.service.cms.model.CmsCatagory;
import com.sxun.server.platform.service.cms.service.CmsCatagoryService;
import com.sxun.server.common.web.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
@Service
@Transactional
public class CmsCatagoryServiceImpl extends AbstractService<CmsCatagory> implements CmsCatagoryService {
    @Resource
    private CmsCatagoryMapper cmsCatagoryMapper;

}
