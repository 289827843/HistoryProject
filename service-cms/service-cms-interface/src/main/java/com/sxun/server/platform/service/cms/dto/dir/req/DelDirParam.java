package com.sxun.server.platform.service.cms.dto.dir.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "删除目录请求对象")
public class DelDirParam {
//    @NotNull(message = "不能为空")
    @ApiObjectField(description = "目录id",required=true)
    private int dir_id;

    public int getDir_id() {
        return dir_id;
    }

    public void setDir_id(int dir_id) {
        this.dir_id = dir_id;
    }
}
