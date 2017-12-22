package com.sxun.server.platform.service.ucenter.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.ucenter.model.UcenterRolePermission;

/**
 * Created by lz on 2017/12/22.
 */
public interface UcenterRolePermissionMapper extends Mapper<UcenterRolePermission>{
    //根据role_id删除表
    public int deleteRolePermissionByRoleId(Integer roleId);
}
