package com.sxun.server.platform.service.cms.dto.file.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(description = "附件删除请求对象")
public class DelFileparam {
    @ApiObjectField(description = "文件id")
    private String file_id;

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }
}
