package com.sxun.server.platform.service.ucenter.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.platform.service.ucenter.dto.permission.req.AddPermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.AddPermissionResult;
import com.sxun.server.platform.service.ucenter.itf.IPermissionController;
import com.sxun.server.platform.service.ucenter.model.UcenterPermission;
import com.sxun.server.platform.service.ucenter.service.UcenterPermissionService;
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


/**
 * Created by lz on 2017/12/22.
 */
@Api(name = "权限服务",description = "权限相关服务",group = "ucenter")
@RestController
@RequestMapping("/permission")
public class PermissionController implements IPermissionController{
    @Resource
    private UcenterPermissionService ucenterPermissionService;

    @ApiMethod(description = "权限添加")
    @RequestMapping(path = "/add",method = RequestMethod.POST)
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
}
