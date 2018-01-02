package com.sxun.server.platform.service.ucenter.dto.role.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * created by lz on 2017/12/21.
 */

@ApiObject(description = "角色删除参数")
public class DeleteRoleParam {
    @ApiObjectField(description = "角色id",required = true)
    private Integer role_id;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
