package com.sxun.server.platform.service.cms.dto.reply.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "回复删除请求对象")
public class DelReplyParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "回复人",required=true)
    private Integer reply_id;

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }
}
