package com.sxun.server.platform.service.cms.dto.dir.rsp;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "查询目录结果对象")
public class ListDirResult {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "目录id",required=true)
    private Number dir_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "归属内容分类id",required=true)
    private Number cata_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "上级目录id，顶级目录为-1，需要存在于cata_id之下",required=true)
    private Number parent_id;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "目录名称，在2到20字符",required=true)
    private String name;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "是否显示",required=true)
    private boolean is_display;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "目录层级",required=true)
    private  int level;

    public Number getParent_id() {
        return parent_id;
    }

    public boolean isIs_display() {
        return is_display;
    }

    public Number getCata_id() {
        return cata_id;
    }

    public void setIs_display(boolean is_display) {
        this.is_display = is_display;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Number getDir_id() {
        return dir_id;
    }

    public void setParent_id(Number parent_id) {
        this.parent_id = parent_id;
    }

    public void setCata_id(Number cata_id) {
        this.cata_id = cata_id;
    }

    public void setDir_id(Number dir_id) {
        this.dir_id = dir_id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
