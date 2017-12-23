package com.sxun.server.platform.service.ucenter.service;


import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.dto.user.req.AddUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.ChangeUserStatusParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.SearchUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.UpdateUserParam;
import com.sxun.server.platform.service.ucenter.model.UcenterUser;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2017/12/10.
 */
public interface UcenterUserService extends Service<UcenterUser> {

    /**
     * Check user pwd int.
     * @param account the account
     * @param pwd     the pwd
     * @return the int  失败时返回-1 成功时返回 用户id
     */
    public int checkUserPwd(String account,String pwd);

    public Map<String,Object> addUser(AddUserParam param);

    public Map<String,Object> updateUser(UpdateUserParam param);

    public Map<String,Object> changeUserStatus(ChangeUserStatusParam param);

    public Map<String,Object> userListResult(SearchUserParam param);

}
