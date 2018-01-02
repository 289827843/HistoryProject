package com.sxun.server.platform.service.ucenter.dto.rolper.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

/**
 * Created by lz on 2017/12/23.
 */

@ApiObject(description = "角色对应权限查询")
public class SelectRolePerParam {
    @NotNull
    @ApiObjectField(description = "角色id",required = true)
    private Integer role_id;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
