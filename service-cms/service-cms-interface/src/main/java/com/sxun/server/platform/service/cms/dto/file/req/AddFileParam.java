package com.sxun.server.platform.service.cms.dto.file.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(description = "附件添加请求对象")
public class AddFileParam {
    @ApiObjectField(description = "文件名称")
    private Number name;
    @ApiObjectField(description = "文件后缀")
    private Number ext;
    @ApiObjectField(description = "文件内容",required=true)
    private String base64_str;

    public Number getName() {
        return name;
    }

    public void setName(Number name) {
        this.name = name;
    }

    public Number getExt() {
        return ext;
    }

    public void setExt(Number ext) {
        this.ext = ext;
    }

    public String getBase64_str() {
        return base64_str;
    }

    public void setBase64_str(String base64_str) {
        this.base64_str = base64_str;
    }
}
