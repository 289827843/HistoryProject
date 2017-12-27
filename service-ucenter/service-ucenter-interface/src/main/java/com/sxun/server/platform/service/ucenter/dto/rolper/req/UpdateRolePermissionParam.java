package com.sxun.server.platform.service.ucenter.dto.rolper.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.List;

/**
 * Created by lz on 2017/12/25.
 */
@ApiObject
public class UpdateRolePermissionParam {
    @ApiObjectField(description = "角色id")
    private Integer role_id;
    @ApiObjectField(description = "权限id集合")
    private List<Integer> permissionIdList;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public List<Integer> getPermissionIdList() {
        return permissionIdList;
    }

    public void setPermissionIdList(List<Integer> permissionIdList) {
        this.permissionIdList = permissionIdList;
    }
}
