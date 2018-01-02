package com.sxun.server.platform.service.ucenter.dto.user.rsp;


import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(description = "用户对应角色列表")
public class UserRoleResult {

    @ApiObjectField(description = "角色id")
    private int role_id;

    @ApiObjectField(description = "角色名称")
    private String name;

    @ApiObjectField(description = "角色所属子系统")
    private String sName;


    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

}
