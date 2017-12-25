package com.sxun.server.platform.service.cms.dto.article.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(description = "创建文章结果对象")
public class AddArticleResult {
    @ApiObjectField(description = "新增的文章ID")
    private Integer article_id;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }
}
