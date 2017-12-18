package com.sxun.server.platform.service.ucenter.service;


import com.sxun.server.common.remote.session.LoginInfo;
import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.model.UcenterSession;

/**
 * Created by CodeGenerator on 2017/12/16.
 */
public interface UcenterSessionService extends Service<UcenterSession> {

    public LoginInfo createSession(int user_id, int sys_id, String client, String ip);
    public void removeSession(String session_token);
    public void refSession(String ref_token);
}
