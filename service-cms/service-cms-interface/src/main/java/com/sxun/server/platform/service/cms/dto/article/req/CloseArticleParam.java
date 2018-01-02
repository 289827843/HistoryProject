package com.sxun.server.platform.service.cms.dto.article.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "文章下架请求对象")
public class CloseArticleParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "文章id",required=true)
    private Integer article_id;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }
}
