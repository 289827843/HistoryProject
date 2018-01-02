package com.sxun.server.platform.service.ucenter.dto.role.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * created by lz on 2017/12/19
 */

@ApiObject(description = "角色查询结果")
public class RoleListResult {
    @ApiObjectField(description =  "角色id")
    private Integer role_id;
    @ApiObjectField(description =  "角色名称")
    private String name;
    @ApiObjectField(description =  "角色描述")
    private String desc;
    @ApiObjectField(description =  "角色所属子系统 1=前台角色 2=后台角色")
    private Integer sys_id;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
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

    public Integer getSys_id() {
        return sys_id;
    }

    public void setSys_id(Integer sys_id) {
        this.sys_id = sys_id;
    }
}
