package com.sxun.server.platform.service.cms.dto.dir.rsp;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "创建目录结果对象")
public class AddDirResult {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "新增的目录ID")
    private Number dir_id;

    public Number getDir_id() {
        return dir_id;
    }

    public void setDir_id(Number dir_id) {
        this.dir_id = dir_id;
    }
}
