package com.sxun.server.platform.service.ucenter.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.platform.service.ucenter.dto.role.req.AddRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.req.DeleteRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.req.SearchRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.req.UpdateRoleParam;
import com.sxun.server.platform.service.ucenter.dto.role.rsp.AddRoleResult;
import com.sxun.server.platform.service.ucenter.dto.role.rsp.RoleListResult;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserListResult;
import com.sxun.server.platform.service.ucenter.itf.IRoleController;
import com.sxun.server.platform.service.ucenter.model.UcenterRole;
import com.sxun.server.platform.service.ucenter.service.UcenterRoleService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * created by lz on 2017/12/19.
 */

@Api(name = "角色服务",description ="角色相关服务", group = "ucenter")
@RestController
@RequestMapping("/role")
public class RoleController implements IRoleController{
    @Autowired
    private UcenterRoleService ucenterRoleService;

    @ApiMethod(description = "角色查询")
    @RequestMapping(path = "/list",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<List<RoleListResult>> selectRole(@ApiBodyObject @RequestBody @Valid SearchRoleParam param) {

        List<RoleListResult> results = ucenterRoleService.selectRole(param);
        if(results.size()==0){
            return ResultGenerator.genFailResult("未查询到指定角色");
        }else {
            Result<List<RoleListResult>> result = ResultGenerator.genSuccessResult();
            result.setDataObj(results);
            return result;
        }

    }

    @ApiMethod(description = "角色添加")
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<AddRoleResult> addRole(@ApiBodyObject @RequestBody @Valid AddRoleParam param) {

            UcenterRole urole = new UcenterRole();
            urole.setName(param.getName());
            urole.setDesc(param.getDesc());
            urole.setSysId(param.getSys_id());
            int addResult = ucenterRoleService.addRole(urole);
            if(addResult==0){
                return ResultGenerator.genFailResult("角色添加失败");
            }else {
                AddRoleResult addRoleResult = new AddRoleResult();
                addRoleResult.setRole_id(addResult);
                Result<AddRoleResult> re = ResultGenerator.genSuccessResult();
                re.setDataObj(addRoleResult);//返回新增的角色id
                return re;
            }

    }

    @ApiMethod(description = "角色修改")
    @RequestMapping(path = "/update",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result updateRole(@ApiBodyObject @RequestBody @Valid UpdateRoleParam param) {
        UcenterRole urole = new UcenterRole();
        urole.setRoleId(param.getRole_id());
        urole.setName(param.getName());
        urole.setDesc(param.getDesc());
        UcenterRole ucenterRole = ucenterRoleService.findById(param.getRole_id());
        if (ucenterRole!=null){
            urole.setSysId(ucenterRole.getSysId());//拿到sys_id
        }
        int updateResult = ucenterRoleService.updateRole(urole);
        if(updateResult==0){
            return ResultGenerator.genFailResult("角色修改失败");
        }else {
            return ResultGenerator.genSuccessResult("角色修改成功");
        }
    }

    @ApiMethod(description = "角色删除")
    @RequestMapping(path = "/del",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<String> deleteRole(@ApiBodyObject @RequestBody DeleteRoleParam param) {
        UcenterRole urole = new UcenterRole();
        urole.setRoleId(param.getRole_id());
        int delResult = ucenterRoleService.deleteRole(urole);
        if(delResult==0){
            return ResultGenerator.genFailResult("角色删除失败");
        }else if (delResult==2){
            return ResultGenerator.genFailResult("角色被用户引用不能删除");
        }else {
            return ResultGenerator.genSuccessResult("角色删除成功");
        }

    }

}
