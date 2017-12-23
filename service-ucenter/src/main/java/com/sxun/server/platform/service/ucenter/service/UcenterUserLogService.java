package com.sxun.server.platform.service.ucenter.service;


import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.dto.user.req.AddUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.ChangeUserStatusParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.UpdateUserParam;
import com.sxun.server.platform.service.ucenter.model.UcenterUserLog;

/**
 * Created by CodeGenerator on 2017/12/10.
 */
public interface UcenterUserLogService extends Service<UcenterUserLog> {


    public void logAddUser(AddUserParam param,int id ,String ip);

    public void logUpdateUser(UpdateUserParam param ,String ip);

    public void logChangeUserStatus(ChangeUserStatusParam param ,String ip);

}
