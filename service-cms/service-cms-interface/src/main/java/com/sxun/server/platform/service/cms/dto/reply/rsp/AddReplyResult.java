package com.sxun.server.platform.service.cms.dto.reply.rsp;


import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(description = "添加回复结果对象")
public class AddReplyResult {
    @ApiObjectField(description = "新增用户回复id" ,required=true)
    private Integer reply_id;

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }
}
