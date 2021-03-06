package com.sxun.server.platform.service.ucenter.service;


import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.dto.user.req.*;
import com.sxun.server.platform.service.ucenter.model.UcenterUserLog;

/**
 * Created by CodeGenerator on 2017/12/10.
 */
public interface UcenterUserLogService extends Service<UcenterUserLog> {


    public void logAddUser(AddUserParam param,int id ,String ip);

    public void logUpdateUser(UpdateUserParam param ,String ip);

    public void logChangeUserStatus(ChangeUserStatusParam param ,String ip);

    public void logChangeUserPassword(ChangeUserPasswordParam param,String ip);

    public void logResetUserPassword(ResetUserPasswordParam param ,String ip);

    public void logUpdateAvatar(UpdateAvatarParam param, String ip);

}
