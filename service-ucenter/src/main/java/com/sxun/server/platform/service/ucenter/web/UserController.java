package com.sxun.server.platform.service.ucenter.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.common.util.IpUtil;
import com.sxun.server.platform.service.ucenter.dto.user.req.*;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.*;
import com.sxun.server.platform.service.ucenter.itf.IUserController;
import com.sxun.server.platform.service.ucenter.model.UcenterUserAvatar;
import com.sxun.server.platform.service.ucenter.service.UcenterUserAvatarService;
import com.sxun.server.platform.service.ucenter.service.UcenterUserLogService;
import com.sxun.server.platform.service.ucenter.service.UcenterUserService;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private UcenterUserAvatarService userAvatarService;
    private  String key ;

    @ApiMethod(description = "添加用户账号")
    @RequestMapping(path="/add", method= RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<AddUserResult> addUer(@ApiBodyObject @RequestBody @Valid  AddUserParam param ) {

        Map<String,Object> map = ucenterUserService.addUser(param);
        for (String s: map.keySet()) {
            key = s;
        }

        if (key.equals("success")){

            return ResultGenerator.genSuccessResult(new AddUserResult(Integer.valueOf(map.get(key).toString())));
        }else{
            return ResultGenerator.genFailResult(map.get(key).toString());
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
    public  @ApiResponseObject Result changePassword(@ApiBodyObject @RequestBody @Valid ChangeUserPasswordParam param) {

        Map<String,Object> map = ucenterUserService.changeUserPassword(param);

        for (String s: map.keySet()) {

            key = s;
        }
        if (map.get(key).equals("success")){

            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult(map.get(key).toString());
        }

    }

    @ApiMethod(description = "重置密码")
    @RequestMapping(path="/reset_ped", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result resetPassword(@ApiBodyObject @RequestBody @Valid ResetUserPasswordParam param) {

        Map<String,Object> map = ucenterUserService.resetUserPassword(param);

         for (String s: map.keySet()) {

            key = s;
         }
        if (map.get(key).equals("success")){

            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult(map.get(key).toString());
        }

    }

    @ApiMethod(description = "更新头像")
    @RequestMapping(path="/update_avatar", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result updateAvatar(@ApiBodyObject @RequestBody @Valid  UpdateAvatarParam param) {


        Map<String,Object> map = ucenterUserService.updateAvatar(param);

        for (String s: map.keySet()) {

            key = s;
        }
        if (map.get(key).equals("success")){

            return ResultGenerator.genSuccessResult(map.get(key).toString());
        }else{
            return ResultGenerator.genFailResult(map.get(key).toString());
        }

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
            return ResultGenerator.genFailResult(map.get(key).toString());
        }

    }

    @ApiMethod(description = "获取用户详情")
    @RequestMapping(path="/detail/{id}", method= RequestMethod.GET)
    @Override
    public  @ApiResponseObject Result<UserDetail> detail(@ApiPathParam(name="id",description = "用户id") @PathVariable Integer id) {

        Map<String ,Object> map =ucenterUserService.userDetail(id);

        for (String s: map.keySet()) {

            key = s;
        }
        if (key.equals("success")){

            return ResultGenerator.genSuccessResult((UserDetail)map.get(key));
        }else {
            return ResultGenerator.genFailResult(map.get(key).toString());
       }

    }

    @ApiMethod(description = "用户对应角色查询")
    @RequestMapping(path="/user_role/list/{id}", method= RequestMethod.GET)
    @Override
    public @ApiResponseObject Result<List> userRole(@ApiPathParam(name="id",description = "用户id") @PathVariable Integer id){

        Map<String,Object> map = ucenterUserService.userRole(id);

        for (String s: map.keySet()) {

            key = s;
        }
        if (key.equals("success")){

            return ResultGenerator.genSuccessResult(new ArrayList((ArrayList)map.get(key)));
        }else {

            return ResultGenerator.genFailResult(map.get(key).toString());
        }

   }


    @ApiMethod(description = "用户对应角色更新")
    @RequestMapping(path="/user_role/update", method= RequestMethod.POST)
    @Override
    public @ApiResponseObject Result userRoleUpdate(@ApiBodyObject @RequestBody @Valid  UpdateUserRoleParam param){


        Map<String,Object> map = ucenterUserService.userRoleUpdate(param);

        for (String s: map.keySet()) {

            key = s;
        }
        if (key.equals("success")){

            return ResultGenerator.genSuccessResult(map.get(key).toString());
        }else {
            return ResultGenerator.genFailResult(map.get(key).toString());
        }

    }

    @ApiMethod(description = "用户头像获取")
    @RequestMapping(path="/avatar/{avatar_id}", method= RequestMethod.POST)
    @Override
    public @ApiResponseObject Result avatar(@ApiPathParam(name="avatar_id",description = "用户id") @PathVariable  Integer avatar_id ,HttpServletResponse response){

        Map<String,Object> map = userAvatarService.outPutAvatar(response,avatar_id);

        for (String s: map.keySet()) {

            key = s;
        }
        if (key.equals("success")){

            return ResultGenerator.genSuccessResult(map.get(key));
        }else {
            return ResultGenerator.genFailResult(map.get(key).toString());
        }

    }


    @ApiMethod(description = "用户注册")
    @RequestMapping(path = "/reg",method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<RegUserResult> regUser(@ApiBodyObject @RequestBody @Valid RegUserParam param) {

        int regResult = ucenterUserService.regUser(param);

        if (regResult == -1)
            return ResultGenerator.genFailResult("验证码错误");
        if (regResult == 0)
            return ResultGenerator.genFailResult("该用户已存在");
        else
            return ResultGenerator.genSuccessResult(new RegUserResult(regResult));//返回新增的用户id

    }
}
