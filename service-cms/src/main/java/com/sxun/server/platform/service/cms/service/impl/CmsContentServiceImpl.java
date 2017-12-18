package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.platform.service.cms.dao.CmsContentMapper;
import com.sxun.server.platform.service.cms.model.CmsContent;
import com.sxun.server.platform.service.cms.service.CmsContentService;
import com.sxun.server.common.web.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
@Service
@Transactional
public class CmsContentServiceImpl extends AbstractService<CmsContent> implements CmsContentService {
    @Resource
    private CmsContentMapper cmsContentMapper;

}
