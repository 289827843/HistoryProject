package com.sxun.server.platform.service.ucenter.dto.permission.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by lz on 2017/12/22.
 */

@ApiObject(description = "权限添加结果对象")
public class AddPermissionResult {
    @ApiObjectField(description = "新增的权限id")
    private int permission_id;

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }
}
