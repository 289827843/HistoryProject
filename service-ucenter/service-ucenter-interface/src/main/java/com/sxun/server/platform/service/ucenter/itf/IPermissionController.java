package com.sxun.server.platform.service.ucenter.itf;

import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.ucenter.dto.permission.req.AddPermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.AddPermissionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lz on 2017/12/22.
 */

@RestController
@RequestMapping("/permission")
public interface IPermissionController {
    //权限添加
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public Result<AddPermissionResult> addPermission(@RequestBody AddPermissionParam param);

}
