package com.sxun.server.platform.service.ucenter.service;

import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.UpdateRolePermissionParam;
import com.sxun.server.platform.service.ucenter.model.UcenterRolePermission;

import java.util.List;

/**
 * Created by lz on 2017/12/25.
 */
public interface UcenterRolePermissionService extends Service<UcenterRolePermission>{
    //角色对应权限更新
    public int updateRolePermission(UpdateRolePermissionParam param);
}
