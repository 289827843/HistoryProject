package com.sxun.server.platform.service.cms.dto.file.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "附件添加请求对象")
public class AddFileParam {
    @ApiObjectField(description = "文件名称")
    private String name;
    @ApiObjectField(description = "文件后缀")
    private String ext;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "文件内容",required=true)
    private String base64_str;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getBase64_str() {
        return base64_str;
    }

    public void setBase64_str(String base64_str) {
        this.base64_str = base64_str;
    }


}
