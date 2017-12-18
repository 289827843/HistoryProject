package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.platform.service.cms.dao.CmsArticleMapper;
import com.sxun.server.platform.service.cms.model.CmsArticle;
import com.sxun.server.platform.service.cms.service.CmsArticleService;
import com.sxun.server.common.web.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
@Service
@Transactional
public class CmsArticleServiceImpl extends AbstractService<CmsArticle> implements CmsArticleService {
    @Resource
    private CmsArticleMapper cmsArticleMapper;

}
