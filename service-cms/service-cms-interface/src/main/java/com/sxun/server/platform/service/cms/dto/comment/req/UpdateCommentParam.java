package com.sxun.server.platform.service.cms.dto.comment.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "修改评论请求对象")
public class UpdateCommentParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "评论id",required=true)
    private Integer comment_id;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "评论内容",required=true)
    private String content;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "是否显示",required=true)
    private Boolean is_display;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIs_display() {
        return is_display;
    }

    public void setIs_display(Boolean is_display) {
        this.is_display = is_display;
    }
}
