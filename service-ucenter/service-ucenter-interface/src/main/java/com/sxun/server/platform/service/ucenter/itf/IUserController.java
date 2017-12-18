package com.sxun.server.platform.service.ucenter.itf;

import com.sxun.server.common.remote.Result;

import com.sxun.server.platform.service.ucenter.dto.user.req.*;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.AddUserResult;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.AvatarResult;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserDetail;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserListResult;
import org.springframework.web.bind.annotation.*;

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
    public Result<AvatarResult> updateAvatar(@RequestBody UpdateAvatarParam param);

    @RequestMapping(path="/list", method= RequestMethod.POST)
    public  Result<UserListResult> list(@RequestBody SearchUserParam param);

    @RequestMapping(path="/detail/{id}", method= RequestMethod.GET)
    public  Result<UserDetail> detail(@PathVariable Integer id);

}
