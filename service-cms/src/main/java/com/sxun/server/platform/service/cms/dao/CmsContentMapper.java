package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.model.CmsContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsContentMapper extends Mapper<CmsContent> {
    int insertContent(CmsContent cmsContent);
    int deleteContent(@Param("article_id")Integer article_id);
    int getCounts(@Param("article_id") Integer article_id);

    List<CmsContent> findContents(@Param("article_id") Integer article_id);
}