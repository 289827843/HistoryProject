package com.sxun.server.platform.service.cms.dto.reply.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "回复添加请求对象")
public class AddReplyParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "回复人",required=true)
    private Integer reply_user_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "评论id",required=true)
    private Integer comment_id;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "回复内容",required=true)
    private String comment;

    public Integer getReply_user_id() {
        return reply_user_id;
    }

    public void setReply_user_id(Integer reply_user_id) {
        this.reply_user_id = reply_user_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
