package com.sxun.server.platform.service.cms.dto.comment.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "评论删除请求对象")
public class DelCommentParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "评论id",required=true)
    private Integer comment_id;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }
}
