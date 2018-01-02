package com.sxun.server.platform.service.cms.dto.comment.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "创建目录结果对象")
public class AddCommentResult {
    @ApiObjectField(description = "成功新增的评论id",required=true)
    private Integer comment_id;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }
}
