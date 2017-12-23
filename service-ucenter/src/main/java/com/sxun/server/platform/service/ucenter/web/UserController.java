package com.sxun.server.platform.service.ucenter.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.common.util.IpUtil;
import com.sxun.server.platform.service.ucenter.dto.user.req.*;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.AddUserResult;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.AvatarResult;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserDetail;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserListResult;
import com.sxun.server.platform.service.ucenter.itf.IUserController;
import com.sxun.server.platform.service.ucenter.service.UcenterUserLogService;
import com.sxun.server.platform.service.ucenter.service.UcenterUserService;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by leizheng on 12/10/2017.
 */
@Api(name = "用户账号服务", description = "用户账号相关服务", group = "ucenter")
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UcenterUserService ucenterUserService;
    @Autowired
    private UcenterUserLogService userLogService;


    private  String key ;
    private  Object value;

    @ApiMethod(description = "添加用户账号")
    @RequestMapping(path="/add", method= RequestMethod.POST)
    @Override
    public @ApiResponseObject
    Result<AddUserResult> addUer(@ApiBodyObject @RequestBody @Valid  AddUserParam param ) {

        Map<String,Object> map = ucenterUserService.addUser(param);
        for (Map.Entry<String,Object> entry: map.entrySet()) {

              key = entry.getKey();
              value = entry.getValue();
        }

        if (key.equals("success")){

            return ResultGenerator.genSuccessResult(new AddUserResult(Integer.valueOf(value.toString())));

        }else{
            return ResultGenerator.genFailResult(value.toString());
        }

    }

    @ApiMethod(description = "更新用户")
    @RequestMapping(path="/update", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result updateUser(@ApiBodyObject @RequestBody @Valid UpdateUserParam param) {

      Map<String ,Object> map = ucenterUserService.updateUser(param);
        for (String s: map.keySet()) {
              key = s;
        }

        if (key.equals("success")){

           return ResultGenerator.genSuccessResult(map.get(key).toString());

        }else {

            return ResultGenerator.genFailResult(map.get(key).toString());
        }

    }

    @ApiMethod(description = "改变用户状态")
    @RequestMapping(path="/change_status", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result changeStatus(@ApiBodyObject @RequestBody @Valid ChangeUserStatusParam param) {

        Map<String,Object> map = ucenterUserService.changeUserStatus(param);

        for (String s: map.keySet()) {

            key = s;
        }

        if(key.equals("success")){

            return ResultGenerator.genSuccessResult(map.get(key).toString());
        }else{

            return ResultGenerator.genFailResult(map.get(key).toString());
        }

    }

    @ApiMethod(description = "修改密码")
    @RequestMapping(path="/change_pwd", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result changePassword(@ApiBodyObject @RequestBody ChangeUserPasswordParam param) {
        return null;
    }

    @ApiMethod(description = "重置密码")
    @RequestMapping(path="/reset_ped", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result resetPassword(@ApiBodyObject @RequestBody ResetUserPasswordParam param) {
        return null;
    }

    @ApiMethod(description = "更新头像")
    @RequestMapping(path="/update_avatar", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result<AvatarResult> updateAvatar(@ApiBodyObject @RequestBody UpdateAvatarParam param) {
        return null;
    }

    @ApiMethod(description = "查询用户列表")
    @RequestMapping(path="/list", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result<UserListResult> list(@ApiBodyObject @RequestBody SearchUserParam param){

        Map<String ,Object> map = ucenterUserService.userListResult(param);

        for (String s: map.keySet()) {

             key = s;
        }
        if (key.equals("success")){

            return ResultGenerator.genSuccessResult((UserListResult)map.get(key));
        }else {

            return ResultGenerator.genFailResult("无用户信息");
        }

    }

    @ApiMethod(description = "获取用户详情")
    @RequestMapping(path="/detail/{id}", method= RequestMethod.GET)
    @Override
    public  @ApiResponseObject Result<UserDetail> detail(@ApiPathParam(name="id",description = "用户id") @PathVariable Integer id) {
        return null;
    }


}
