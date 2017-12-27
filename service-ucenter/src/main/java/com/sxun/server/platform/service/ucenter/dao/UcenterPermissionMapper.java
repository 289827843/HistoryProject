package com.sxun.server.platform.service.ucenter.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.ucenter.dto.permission.req.SearchPermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.PermissionInfo;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.SelectRolePerParam;
import com.sxun.server.platform.service.ucenter.dto.rolper.rsp.PermissionListResult;
import com.sxun.server.platform.service.ucenter.model.UcenterPermission;

import java.util.List;

/**
 * Created by lz on 2017/12/22.
 */
public interface UcenterPermissionMapper extends Mapper<UcenterPermission>{

    //查询制定的name+sys_id 是否唯一
    public List<UcenterPermission> selectIsUnique(UcenterPermission ucenterPermission);
    //执行修改语句时查询name+sys_id是否唯一
    public int checkUnique(UcenterPermission ucenterPermission);

    //权限查询
    public List<PermissionInfo> selectPermission(SearchPermissionParam param);

    //角色对应权限查询
    public List<PermissionListResult> selectPermissions(SelectRolePerParam param);

    //根据权限id查询角色权限对应表是否存在该记录,判断权限是否被角色引用
    public int selectRolePermissionByPerId(Integer permission_id);

}
