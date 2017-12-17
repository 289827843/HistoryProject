package com.sxun.server.platform.service.ucenter.service;
import com.alibaba.druid.stat.TableStat;
import com.sxun.server.platform.service.ucenter.model.UcenterUser;
import com.sxun.server.platform.service.ucenter.core.Service;


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
}
