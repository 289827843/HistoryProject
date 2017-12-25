package com.sxun.server.platform.service.ucenter.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.platform.service.ucenter.dto.permission.req.AddPermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.req.DeletePermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.req.SearchPermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.req.UpdatePermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.AddPermissionResult;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.PerListResult;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.SelectRolePerParam;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.UpdateRolePermissionParam;
import com.sxun.server.platform.service.ucenter.dto.rolper.rsp.PermissionListResult;
import com.sxun.server.platform.service.ucenter.itf.IPermissionController;
import com.sxun.server.platform.service.ucenter.model.UcenterPermission;
import com.sxun.server.platform.service.ucenter.service.UcenterPermissionService;
import com.sxun.server.platform.service.ucenter.service.UcenterRolePermissionService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


/**
 * Created by lz on 2017/12/22.
 */
@Api(name = "权限服务",description = "权限相关服务",group = "ucenter")
@RestController
//@RequestMapping("/permission")
public class PermissionController implements IPermissionController{
    @Resource
    private UcenterPermissionService ucenterPermissionService;

    @Resource
    private UcenterRolePermissionService ucenterRolePermissionService;

    @ApiMethod(description = "权限添加")
    @RequestMapping(path = "/permission/add",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<AddPermissionResult> addPermission(@ApiBodyObject @RequestBody @Valid AddPermissionParam param) {
        UcenterPermission ucenterPermission = new UcenterPermission();
        ucenterPermission.setName(param.getName());
        ucenterPermission.setTypeName(param.getType_name());
        ucenterPermission.setLinkUrl(param.getLink_url());
        ucenterPermission.setSysId(param.getSys_id());
        int addResult = ucenterPermissionService.addPermission(ucenterPermission);
        if(addResult==0){
            return ResultGenerator.genFailResult("权限添加失败");
        }else {
            AddPermissionResult addPermissionResult = new AddPermissionResult();
            addPermissionResult.setPermission_id(addResult);
            Result<AddPermissionResult> result = ResultGenerator.genSuccessResult();
            result.setDataObj(addPermissionResult);//返回新增的权限id
            return result;
        }
    }

    @ApiMethod(description = "权限修改")
    @RequestMapping(path = "/permission/update",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<String> updatePermission(@ApiBodyObject @RequestBody @Valid UpdatePermissionParam param) {
        UcenterPermission ucenterPermission = new UcenterPermission();
        ucenterPermission.setPermissionId(param.getPermission_id());
        ucenterPermission.setName(param.getName());
        ucenterPermission.setTypeName(param.getType_name());
        ucenterPermission.setLinkUrl(param.getLink_url());
        int updateResult = ucenterPermissionService.updatePermission(ucenterPermission);
        if (updateResult==0){
            return ResultGenerator.genFailResult("权限修改失败");
        }else {
            return ResultGenerator.genSuccessResult("权限修改成功");
        }
    }

    @ApiMethod(description = "权限删除")
    @RequestMapping(path = "/permission/del",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<String> deletePermission(@ApiBodyObject @RequestBody @Valid DeletePermissionParam param) {
        UcenterPermission ucenterPermission = new UcenterPermission();
        ucenterPermission.setPermissionId(param.getPermission_id());
        int deleteResult = ucenterPermissionService.deletePermission(ucenterPermission);
        if (deleteResult==0){
            return ResultGenerator.genFailResult("权限删除失败");
        }else {
            return ResultGenerator.genSuccessResult("权限删除成功");
        }
    }

    @ApiMethod(description = "权限查询")
    @RequestMapping(path = "/permission/list",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<List<PerListResult>> selectPermission(@ApiBodyObject @RequestBody @Valid SearchPermissionParam param) {
        List<PerListResult> perListResults = ucenterPermissionService.selectPermission(param);
        Result<List<PerListResult>> result = ResultGenerator.genSuccessResult();
        result.setDataObj(perListResults);
        return result;
    }

    @ApiMethod(description = "角色对应权限查询")
    @RequestMapping(path = "/role_per/list",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<List<PermissionListResult>> selectRolePermission(@ApiBodyObject @RequestBody @Valid SelectRolePerParam param) {
        List<PermissionListResult> permissionListResults = ucenterPermissionService.selectRolePermission(param);
        if (permissionListResults==null) {
            return ResultGenerator.genFailResult("没有该角色对应的权限信息");
        }else {
            Result<List<PermissionListResult>> result = ResultGenerator.genSuccessResult();
            result.setDataObj(permissionListResults);
            return result;
        }
    }

    @ApiMethod(description = "角色对应权限更新")
    @RequestMapping(path = "/role_per/update",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<String> updateRolePermission(@ApiBodyObject @RequestBody UpdateRolePermissionParam param) {
        int result = ucenterRolePermissionService.updateRolePermission(param);
        if (result==0){
            return ResultGenerator.genFailResult("角色对应权限更新失败");
        }else {
            return ResultGenerator.genSuccessResult("角色对应权限更新成功");
        }
    }
}
