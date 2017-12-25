package com.sxun.server.platform.service.ucenter.service;

import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.dto.role.req.AddRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.req.SearchRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.rsp.RoleListResult;
import com.sxun.server.platform.service.ucenter.model.UcenterRole;

import java.util.List;

/**
 * created by lz on 2017/12/19.
 */
public interface UcenterRoleService extends Service<UcenterRole>{
    //角色查询
    public List<RoleListResult> selectRole(SearchRoleParam param);

    //角色添加
    public int addRole(UcenterRole role);

    //角色修改
    public int updateRole(UcenterRole role);

    //角色删除
    public int deleteRole(UcenterRole role);
}
