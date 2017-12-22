package com.sxun.server.platform.service.ucenter.dto.role.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * created by lz on 2017/12/20.
 */
@ApiObject(description = "角色添加结果对象")
public class AddRoleResult {
    @ApiObjectField(description = "新增的角色id")
    private Integer role_id;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
