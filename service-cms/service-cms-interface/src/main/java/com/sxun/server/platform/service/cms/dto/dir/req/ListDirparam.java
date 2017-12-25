package com.sxun.server.platform.service.cms.dto.dir.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "查询目录请求对象")
public class ListDirparam {

    @ApiObjectField(description = "目录名称，在2到20字符")
    private String name;

    @ApiObjectField(description = "归属内容分类id")
    private Integer cata_id;
    @ApiObjectField(description = "上级目录id，顶级目录为-1，需要存在于cata_id之下")

    private Integer parent_id;

    @ApiObjectField(description = "是否显示")
    private boolean is_display;

    @ApiObjectField(description = "目录id")
    private Integer dir_id;

    public void setDir_id(Integer dir_id) {
        this.dir_id = dir_id;
    }

    public Integer getDir_id() {
        return dir_id;
    }

    public void setCata_id(Integer cata_id) {
        this.cata_id = cata_id;
    }

    public String getName() {
        return name;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIs_display(boolean is_display) {
        this.is_display = is_display;
    }

    public Integer getCata_id() {
        return cata_id;
    }

    public boolean isIs_display() {
        return is_display;
    }

    public Integer getParent_id() {
        return parent_id;
    }

}
