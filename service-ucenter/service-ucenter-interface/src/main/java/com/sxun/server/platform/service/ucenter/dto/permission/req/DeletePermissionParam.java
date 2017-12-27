package com.sxun.server.platform.service.ucenter.dto.permission.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

/**
 * Created by lz on 2017/12/23
 */

@ApiObject(description = "权限删除操作")
public class DeletePermissionParam {
    @NotNull(message = "权限id不能为空")
    @ApiObjectField(description = "权限id",required = true)
    private Integer permission_id;

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }
}
