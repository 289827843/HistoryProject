package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.dto.article.req.ListArticleParam;
import com.sxun.server.platform.service.cms.model.CmsArticle;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CmsArticleMapper extends Mapper<CmsArticle> {
    int findArticles(@Param("dir_id") Integer dir_id);

    int insertArticle(CmsArticle cmsArticle);

    int findArticleid(@Param("name") Integer dir_id);

    int updateAriticle(CmsArticle cmsArticle);

    int getCounts(@Param("article_id") Integer article_id);

    int sumbitAriticle(CmsArticle cmsArticle);

    int getStatus(@Param("article_id") Integer article_id);

    CmsArticle findArticle(@Param("article_id") Integer article_id);

    int updateStatus(CmsArticle cmsArticle);

    List<CmsArticle> listAriticle(ListArticleParam param);

    int getAriticleCounts(ListArticleParam param);
    List<CmsArticle> findArticls(@Param("dir_id") Integer dir_id);
}