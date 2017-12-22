package com.sxun.server.platform.service.ucenter.itf;

import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.ucenter.dto.role.req.AddRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.req.DeleteRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.req.SearchRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.req.UpdateRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.rsp.AddRoleResult;
import com.sxun.server.platform.service.ucenter.dto.role.rsp.RoleListResult;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserListResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by lz on 2017/12/19
 */

@RestController
@RequestMapping("/role")
public interface IRoleController {
    //角色查询
    @RequestMapping(path = "/list",method = RequestMethod.POST)
    public Result<List<RoleListResult>> selectRole(@RequestBody SearchRoleParam param);
    //角色添加
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public Result<AddRoleResult> addRole(@RequestBody AddRoleParam param);
    //角色修改
    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public Result updateRole(@RequestBody UpdateRoleParam param);
    //角色删除
    @RequestMapping(path = "/del",method = RequestMethod.POST)
    public Result deleteRole(@RequestBody DeleteRoleParam param);

}


