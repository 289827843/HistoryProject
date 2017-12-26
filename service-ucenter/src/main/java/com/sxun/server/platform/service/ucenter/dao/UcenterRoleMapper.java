package com.sxun.server.platform.service.ucenter.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.ucenter.dto.role.req.AddRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.req.DeleteRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.req.SearchRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.rsp.RoleListResult;
import com.sxun.server.platform.service.ucenter.model.UcenterRole;

import java.util.List;

/**
 * created by lz on 2017/12/19
 */
public interface UcenterRoleMapper extends Mapper<UcenterRole>{
    public List<RoleListResult> selectRole();

    public List<RoleListResult> selectRoleByRoleId(SearchRoleParam param);
    //根据sys_id查询角色
    public List<RoleListResult> selectRoleBySysId(SearchRoleParam param);

    public List<RoleListResult> selectRoleByBoth(SearchRoleParam param);

    //根据角色名称查询角色，返回角色信息集合判断角色是否重复
    public List<UcenterRole> selectRoleByName(UcenterRole role);


    //删除角色表，根据主键删除
    public int deleteRoleByKey(UcenterRole role);

    //删除角色与权限对应表，根据角色id删除
    public int deleteRoleAndPermission(UcenterRole role);


}
