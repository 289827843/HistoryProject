package com.sxun.server.platform.service.cms.service;
import com.sxun.server.platform.service.cms.model.CmsArticleLog;
import com.sxun.server.common.web.core.Service;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
public interface CmsArticleLogService extends Service<CmsArticleLog> {
    void saveArticleLog(CmsArticleLog cmsArticleLog);
}
