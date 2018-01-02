package com.sxun.server.platform.service.ucenter.itf;

import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.ucenter.dto.permission.req.AddPermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.req.DeletePermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.req.SearchPermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.req.UpdatePermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.AddPermissionResult;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.PerListResult;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.SelectRolePerParam;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.UpdateRolePermissionParam;
import com.sxun.server.platform.service.ucenter.dto.rolper.rsp.PermissionListResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lz on 2017/12/22.
 */

@RestController
//@RequestMapping("/permission")
public interface IPermissionController {
    //权限添加
    @RequestMapping(path = "/permission/add",method = RequestMethod.POST)
    public Result<AddPermissionResult> addPermission(@RequestBody AddPermissionParam param);
    //权限修改
    @RequestMapping(path = "/permission/update",method = RequestMethod.POST)
    public Result<String> updatePermission(@RequestBody UpdatePermissionParam param);
    //权限删除
    @RequestMapping(path = "/permission/del",method = RequestMethod.POST)
    public Result<String> deletePermission(@RequestBody DeletePermissionParam param);
    //权限查询
    @RequestMapping(path = "/permission/list",method = RequestMethod.POST)
    public Result<List<PerListResult>> selectPermission(@RequestBody SearchPermissionParam param);

    //角色对应权限查询
    @RequestMapping(path = "/role_per/list",method = RequestMethod.POST)
    public Result<List<PermissionListResult>> selectRolePermission(@RequestBody SelectRolePerParam param);

    //角色对应权限更新
    @RequestMapping(path = "/role_per/update",method = RequestMethod.POST)
    public Result<String> updateRolePermission(@RequestBody UpdateRolePermissionParam param);
}
