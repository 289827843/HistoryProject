package com.sxun.server.platform.service.cms.service;
import com.sxun.server.platform.service.cms.dto.article.req.AddArticleParam;
import com.sxun.server.platform.service.cms.dto.article.req.AuditArticleParam;
import com.sxun.server.platform.service.cms.dto.article.req.ListArticleParam;
import com.sxun.server.platform.service.cms.dto.article.req.UpdateArticleParam;
import com.sxun.server.platform.service.cms.model.CmsArticle;
import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.cms.web.ArticleController;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
public interface CmsArticleService extends Service<CmsArticle> {
    int saveArticle(AddArticleParam param);
    int updateArticle(UpdateArticleParam param);
   int sumbitArticle(Integer article_id,Integer opr_user_id);
   int  auditArticle(AuditArticleParam param);
   int closeArticle(Integer article_id);
    Map<String,Object> detailArticle(Integer article_id);
    Map<String,Object> listArticle(ListArticleParam param);
}
