package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.model.CmsArticleLog;

public interface CmsArticleLogMapper extends Mapper<CmsArticleLog> {
    int insertArticleLog(CmsArticleLog cmsArticleLog);
}