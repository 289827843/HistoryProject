package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.platform.service.cms.dao.CmsArticleLogMapper;
import com.sxun.server.platform.service.cms.model.CmsArticleLog;
import com.sxun.server.platform.service.cms.model.CmsDir;
import com.sxun.server.platform.service.cms.service.CmsArticleLogService;
import com.sxun.server.common.web.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
@Service
@Transactional
public class CmsArticleLogServiceImpl extends AbstractService<CmsArticleLog> implements CmsArticleLogService {
    @Resource
    private CmsArticleLogMapper cmsArticleLogMapper;

    @Override
    public void saveArticleLog(CmsArticleLog cmsArticleLog) {
        if(cmsArticleLog!=null){
            int rows=cmsArticleLogMapper.insertArticleLog(cmsArticleLog);
        }
    }

    ;

}
