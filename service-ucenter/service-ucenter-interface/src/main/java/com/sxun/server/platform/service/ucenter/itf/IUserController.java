package com.sxun.server.platform.service.ucenter.itf;

import com.sxun.server.common.remote.Result;

import com.sxun.server.platform.service.ucenter.dto.user.req.*;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.*;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by leizheng on 12/9/2017.
 */

@RestController
@RequestMapping("/user")
public interface IUserController {
    @RequestMapping(path="/add", method= RequestMethod.POST)
    public  Result<AddUserResult> addUer(@RequestBody AddUserParam param);

    @RequestMapping(path="/update", method= RequestMethod.POST)
    public  Result updateUser(@RequestBody UpdateUserParam param);

    @RequestMapping(path="/change_status", method= RequestMethod.POST)
    public Result changeStatus(@RequestBody ChangeUserStatusParam param);

    @RequestMapping(path="/change_pwd", method= RequestMethod.POST)
    public Result changePassword(@RequestBody ChangeUserPasswordParam param);

    @RequestMapping(path="/reset_ped", method= RequestMethod.POST)
    public Result resetPassword(@RequestBody ResetUserPasswordParam param);

    @RequestMapping(path="/update_avatar", method= RequestMethod.POST)
    public Result updateAvatar(@RequestBody UpdateAvatarParam param);

    @RequestMapping(path="/list", method= RequestMethod.POST)
    public  Result<UserListResult> list(@RequestBody SearchUserParam param);

    @RequestMapping(path="/detail/{id}", method= RequestMethod.GET)
    public  Result<UserDetail> detail(@PathVariable Integer id);

     @RequestMapping(path="/user_role/list/{id}", method= RequestMethod.POST)
     public @ApiResponseObject Result<List> userRole(@ApiPathParam(name="id",description = "用户id") @PathVariable Integer id);

    @RequestMapping(path="/user_role/update/", method= RequestMethod.POST)
    public @ApiResponseObject Result userRoleUpdate(@ApiBodyObject @RequestBody @Valid UpdateUserRoleParam param);

    @RequestMapping(path="/avatar/{avatar_id}", method= RequestMethod.POST)
    public @ApiResponseObject Result avatar(@ApiPathParam(name="user_avatar_id",description = "頭像id") @PathVariable Integer avatar_id , HttpServletResponse response);

    @RequestMapping(path = "/reg",method = RequestMethod.POST)
    public @ApiResponseObject Result<RegUserResult> regUser(@RequestBody RegUserParam param);
}
