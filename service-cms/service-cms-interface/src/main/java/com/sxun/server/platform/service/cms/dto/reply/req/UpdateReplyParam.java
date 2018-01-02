package com.sxun.server.platform.service.cms.dto.reply.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "修改回复请求对象")
public class UpdateReplyParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "回复人id",required=true)
    private Integer reply_id;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "回复内容",required=true)
    private String conment;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "是否显示回复",required=true)
    private Boolean is_display;

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public String getConment() {
        return conment;
    }

    public void setConment(String conment) {
        this.conment = conment;
    }

    public Boolean getIs_display() {
        return is_display;
    }

    public void setIs_display(Boolean is_display) {
        this.is_display = is_display;
    }
}
