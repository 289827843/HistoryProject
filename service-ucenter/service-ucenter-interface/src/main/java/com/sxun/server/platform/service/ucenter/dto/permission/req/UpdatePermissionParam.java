package com.sxun.server.platform.service.ucenter.dto.permission.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by lz on 2017/12/23.
 */
@ApiObject(description = "权限修改")
public class UpdatePermissionParam {
    @NotNull
    @ApiObjectField(description = "权限id",required = true)
    private Integer permission_id;//权限id
    @NotNull
    @Size(min = 2,max = 20,message = "权限名称在2到20位")
    @ApiObjectField(description = "权限名称",required = true)
    private String name;//权限名称
    @NotNull
    @Min(value = 1,message = "权限类型1-3可选")
    @Max(value = 3,message = "权限类型1-3可选")
    @ApiObjectField(description = "权限类型 1-菜单 2-页面 3-接口操作",required = true)
    private Integer type_name;//权限类型 1-菜单 2-页面 3-接口操作
    @ApiObjectField(description = "地址路径")
    private String link_url;

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType_name() {
        return type_name;
    }

    public void setType_name(Integer type_name) {
        this.type_name = type_name;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }
}
