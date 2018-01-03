package com.sxun.server.platform.service.cms.dto.dir.rsp;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "创建目录结果对象")
public class AddDirResult {
    @ApiObjectField(description = "新增的目录ID")
    private Integer dir_id;

    public Integer getDir_id() {
        return dir_id;
    }

    public void setDir_id(Integer dir_id) {
        this.dir_id = dir_id;
    }
}
