package com.sxun.server.platform.service.cms.dto.dir.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "移动目录请求对象")
public class MoveDirParam {
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "目录id",required=true)
    private String dir_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "归属内容分类id",required=true)
    private int cata_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "上级目录id，顶级目录为-1，需要存在于cata_id之下",required=true)
    private int parent_id;

    public void setDir_id(String dir_id) {
        this.dir_id = dir_id;
    }

    public String getDir_id() {
        return dir_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setCata_id(int cata_id) {
        this.cata_id = cata_id;
    }

    public int getCata_id() {
        return cata_id;
    }
}
