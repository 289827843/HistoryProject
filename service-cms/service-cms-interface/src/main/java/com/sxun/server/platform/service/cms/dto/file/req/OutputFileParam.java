package com.sxun.server.platform.service.cms.dto.file.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(description = "附件输出流请求对象")
public class OutputFileParam {
    @ApiObjectField(description = "文件id")
    private Integer file_id;

    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }
}
