package com.sxun.server.platform.service.ucenter.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;

import com.sxun.server.platform.service.ucenter.dto.user.req.*;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.AddUserResult;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.AvatarResult;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserDetail;

import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserListResult;
import com.sxun.server.platform.service.ucenter.itf.IUserController;
import com.sxun.server.platform.service.ucenter.util.IpUtil;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by leizheng on 12/10/2017.
 */
@Api(name = "用户账号服务", description = "用户账号相关服务", group = "ucenter")
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {

    @Autowired
    private HttpServletRequest request;

    @ApiMethod(description = "添加用户账号")
    @RequestMapping(path="/add", method= RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<AddUserResult> addUer(@ApiBodyObject @RequestBody AddUserParam param) {

        Result<AddUserResult> re= ResultGenerator.genSuccessResult(new AddUserResult());
        re.setMessage(IpUtil.getIpAddr(request));
        return re;
    }

    @ApiMethod(description = "更新用户")
    @RequestMapping(path="/update", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result updateUser(@ApiBodyObject @RequestBody UpdateUserParam param) {
        return null;
    }

    @ApiMethod(description = "改变用户状态")
    @RequestMapping(path="/change_status", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result changeStatus(@ApiBodyObject @RequestBody ChangeUserStatusParam param) {
        return null;
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
    public  @ApiResponseObject Result<AvatarResult> updateAvatar( @ApiBodyObject @RequestBody UpdateAvatarParam param) {
        return null;
    }

    @ApiMethod(description = "查询用户列表")
    @RequestMapping(path="/list", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result<UserListResult> list(@ApiBodyObject @RequestBody SearchUserParam param){
        return null;
    }

    @ApiMethod(description = "获取用户详情")
    @RequestMapping(path="/detail/{id}", method= RequestMethod.GET)
    @Override
    public  @ApiResponseObject Result<UserDetail> detail(@ApiPathParam(name="id",description = "用户id") @PathVariable Integer id) {
        return null;
    }


//    @ApiMethod(description = "22222")
//    @RequestMapping(path="/add", method= RequestMethod.POST)
//    public void addUer(String tt) {
//        return ;
//    }
}
