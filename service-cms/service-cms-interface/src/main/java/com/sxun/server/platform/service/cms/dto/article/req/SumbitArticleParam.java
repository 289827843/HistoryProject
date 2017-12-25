package com.sxun.server.platform.service.cms.dto.article.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "提交文章请求对象")
public class SumbitArticleParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "文章id",required=true)
    private Number article_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "操作员ID,具有权限的操作员ID",required=true)
    private int opr_user_id;

    public Number getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Number article_id) {
        this.article_id = article_id;
    }

    public int getOpr_user_id() {
        return opr_user_id;
    }

    public void setOpr_user_id(int opr_user_id) {
        this.opr_user_id = opr_user_id;
    }
}
