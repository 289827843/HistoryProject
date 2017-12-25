package com.sxun.server.platform.service.ucenter.service;

import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.dto.permission.req.SearchPermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.PerListResult;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.SelectRolePerParam;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.UpdateRolePermissionParam;
import com.sxun.server.platform.service.ucenter.dto.rolper.rsp.PermissionListResult;
import com.sxun.server.platform.service.ucenter.model.UcenterPermission;

import java.util.List;

/**
 * Created by lz on 2017/12/22.
 */
public interface UcenterPermissionService extends Service<UcenterPermission>{
    //权限添加
    public int addPermission(UcenterPermission permission);

    //权限修改
    public int updatePermission(UcenterPermission permission);

    //权限删除
    public int deletePermission(UcenterPermission permission);

    //权限查询
    public List<PerListResult> selectPermission(SearchPermissionParam param);

    //角色对应权限查询
    public List<PermissionListResult> selectRolePermission(SelectRolePerParam param);


}
