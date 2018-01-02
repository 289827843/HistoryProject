package com.sxun.server.platform.service.ucenter.dto.user.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(description = "用户对应权限列表")
public class UserPermissionResult {

    @ApiObjectField(description = "权限id")
    private int permission_id;

    @ApiObjectField(description = "权限名称")
    private String name;

    @ApiObjectField(description = "权限类型")
    private String type_name;

    @ApiObjectField(description = "地址路径")
    private String link_url;

    @ApiObjectField(description = "所属子系统id")
    private int sys_id;


    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public int getSys_id() {
        return sys_id;
    }

    public void setSys_id(int sys_id) {
        this.sys_id = sys_id;
    }
}
