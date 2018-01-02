package com.sxun.server.platform.service.ucenter.service;


import com.sxun.server.common.remote.session.LoginInfo;
import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.Util.ResultMsg;
import com.sxun.server.platform.service.ucenter.dto.auth.req.LoginParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.RefreshParam;
import com.sxun.server.platform.service.ucenter.model.UcenterSession;

import javax.servlet.http.HttpSession;

/**
 * Created by CodeGenerator on 2017/12/16.
 */
public interface UcenterSessionService extends Service<UcenterSession> {

    public LoginInfo createSession(int user_id, LoginParam param, String ip);
/*    public void removeSession(String session_token);
    public void refSession(String ref_token);*/

    public ResultMsg cancel(String session_token);

    public ResultMsg refresh(RefreshParam param);



}
