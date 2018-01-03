package com.sxun.server.platform.service.cms.dto.comment.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "添加评论请求对象")
public class AddCommentParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "评论人id",required=true)
    private Integer comment_user_id;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "评论内容",required=true)
    private String content;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "所属文章id",required=true)
    private Integer article_id;

    public Integer getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(Integer comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }
}
