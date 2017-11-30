package com.sxun.server.platform.service.cms.dto.dir.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "创建目录请求对象")
public class AddDirParam {
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "目录名称，在2到20字符",required=true)

    private String name;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "归属内容分类id",required=true)
    private Integer cata_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "上级目录id，顶级目录为-1，需要存在于cata_id之下",required=true)
    private Integer parent_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCata_id() {
        return cata_id;
    }

    public void setCata_id(Integer cata_id) {
        this.cata_id = cata_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
}
