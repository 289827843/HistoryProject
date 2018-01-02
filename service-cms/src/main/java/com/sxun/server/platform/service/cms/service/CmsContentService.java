package com.sxun.server.platform.service.cms.service;
import com.sxun.server.platform.service.cms.model.CmsContent;
import com.sxun.server.common.web.core.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
public interface CmsContentService extends Service<CmsContent> {
    void saveContent(CmsContent cmsContent);
    void deleteContent(Integer article_id);
    int getCounts(Integer article_id);
    List<CmsContent> findContents(Integer article_id);
}
