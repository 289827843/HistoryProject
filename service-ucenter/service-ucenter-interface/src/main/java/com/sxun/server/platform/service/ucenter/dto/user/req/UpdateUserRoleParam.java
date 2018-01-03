package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "用户对应角色更新")
public class UpdateUserRoleParam {


    @ApiObjectField(description = "操作员ID,自己更新则是自身userid",required=true)
    @NotNull
    private int user_id;

    @NotNull
    @ApiObjectField(description = "角色ID",required=true)
    private int role_id;

    @NotEmpty
    @ApiObjectField(description = "角色名称",required=true)
    private String name;

    @NotEmpty
    @ApiObjectField(description = "desc",required=true)
    private String desc;

    @NotNull
    @ApiObjectField(description = "所属系统ID",required=true)
    private int sys_id;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSys_id() {
        return sys_id;
    }

    public void setSys_id(int sys_id) {
        this.sys_id = sys_id;
    }
}
