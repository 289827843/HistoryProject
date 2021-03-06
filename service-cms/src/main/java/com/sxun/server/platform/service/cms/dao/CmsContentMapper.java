package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.model.CmsContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsContentMapper extends Mapper<CmsContent> {
    int insertContent(CmsContent cmsContent);
    int deleteContent(Integer article_id);
    int getCounts(Integer article_id);

    List<CmsContent> findContents( Integer article_id);
}