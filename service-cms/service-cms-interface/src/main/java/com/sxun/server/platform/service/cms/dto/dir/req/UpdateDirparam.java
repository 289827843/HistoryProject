package com.sxun.server.platform.service.cms.dto.dir.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "修改目录请求对象")
public class UpdateDirparam {
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "目录名称，在2到20字符",required=true)
    private String name;
    @ApiObjectField(description = "目录id",required=true)
    @NotNull(message = "不能为空")
    private int dir_id;
    @ApiObjectField(description = "是否显示",required=true)
    @NotNull(message = "不能为空")
    private boolean is_display;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDir_id() {
        return dir_id;
    }

    public void setDir_id(int dir_id) {
        this.dir_id = dir_id;
    }

    public boolean isIs_display() {
        return is_display;
    }

    public void setIs_display(boolean is_display) {
        this.is_display = is_display;
    }
}
