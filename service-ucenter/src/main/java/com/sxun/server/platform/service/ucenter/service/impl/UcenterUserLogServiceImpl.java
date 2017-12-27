package com.sxun.server.platform.service.ucenter.service.impl;


import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.dao.UcenterUserLogMapper;
import com.sxun.server.platform.service.ucenter.dto.user.req.*;
import com.sxun.server.platform.service.ucenter.model.UcenterUserLog;
import com.sxun.server.platform.service.ucenter.service.UcenterUserLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by CodeGenerator on 2017/12/10.
 */
@Service
@Transactional
public class UcenterUserLogServiceImpl extends AbstractService<UcenterUserLog> implements UcenterUserLogService {
    @Resource
    private UcenterUserLogMapper ucenterUserLogMapper;

    @Override
    public void logAddUser(AddUserParam param, int user_id ,String ip) {

        UcenterUserLog userLog = new UcenterUserLog();
        userLog.setCreateTime(new Date());
        userLog.setUserId(user_id);
        userLog.setActionApiUrl("/user/add");
        userLog.setActionContent("添加用户");
        userLog.setIp(ip);
        userLog.setOprUserId(param.getOpr_user_id());
        this.save(userLog);


    }


    @Override
    public void logUpdateUser(UpdateUserParam param, String ip) {

        UcenterUserLog userLog = new UcenterUserLog();
        userLog.setCreateTime(new Date());
        userLog.setOprUserId(param.getOpr_user_id());
        userLog.setIp(ip);
        userLog.setActionApiUrl("/user//update");
        userLog.setUserId(param.getUser_id());
        userLog.setActionContent("修改用户");
        this.save(userLog);


    }

    @Override
    public void logChangeUserStatus(ChangeUserStatusParam param, String ip) {

        UcenterUserLog userLog = new UcenterUserLog();
        userLog.setCreateTime(new Date());
        userLog.setUserId(param.getUser_id());
        userLog.setOprUserId(param.getOpr_user_id());
        userLog.setActionContent("更新用户状态");
        userLog.setActionApiUrl("user/change_status");
        userLog.setIp(ip);
        this.save(userLog);

    }

    @Override
    public void logChangeUserPassword(ChangeUserPasswordParam param, String ip) {

        UcenterUserLog userLog = new UcenterUserLog();
        userLog.setCreateTime(new Date());
        userLog.setUserId(param.getUser_id());
        userLog.setOprUserId(param.getOpr_user_id());
        userLog.setActionContent("用户修改密码");
        userLog.setActionApiUrl("user/change_pwd");
        userLog.setIp(ip);
        this.save(userLog);

    }


    @Override
    public void logResetUserPassword(ResetUserPasswordParam param, String ip) {

        UcenterUserLog userLog = new UcenterUserLog();
        userLog.setCreateTime(new Date());
        userLog.setUserId(param.getUser_id());
        userLog.setOprUserId(param.getOpr_user_id());
        userLog.setActionContent("用户重置密码");
        userLog.setActionApiUrl("user/reset_ped");
        userLog.setIp(ip);
        this.save(userLog);

    }

    @Override
    public void logUpdateAvatar(UpdateAvatarParam param, String ip) {

        UcenterUserLog userLog = new UcenterUserLog();
        userLog.setCreateTime(new Date());
        userLog.setUserId(param.getUser_id());
        userLog.setOprUserId(param.getOpr_user_id());
        userLog.setActionContent("用户更新头像");
        userLog.setActionApiUrl("user/update_avatar");
        userLog.setIp(ip);
        this.save(userLog);

    }
}
