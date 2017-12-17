package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.common.remote.session.LoginInfo;
import com.sxun.server.common.remote.session.RefTokenInfo;
import com.sxun.server.common.remote.session.SessionInfo;
import com.sxun.server.platform.service.ucenter.dao.UcenterSessionMapper;
import com.sxun.server.platform.service.ucenter.model.UcenterSession;
import com.sxun.server.platform.service.ucenter.model.UcenterSessionRefToken;
import com.sxun.server.platform.service.ucenter.service.UcenterSessionRefTokenService;
import com.sxun.server.platform.service.ucenter.service.UcenterSessionService;
import com.sxun.server.platform.service.ucenter.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * Created by CodeGenerator on 2017/12/16.
 */
@Service
@Transactional
public class UcenterSessionServiceImpl extends AbstractService<UcenterSession> implements UcenterSessionService {
    @Resource
    private UcenterSessionMapper ucenterSessionMapper;

    @Autowired
    private UcenterSessionRefTokenService refTokenService;

    @Value("${sxun.service.login.session_exp_time}")
    private int session_exp_time;

    @Value("${sxun.service.login.ref_token_exp_time}")
    private int ref_token_exp_time;

    @Override
    public LoginInfo createSession(int user_id, int sys_id,String client,String ip) {
        LoginInfo login_info=new LoginInfo();

        //生成会话
        UcenterSession session=new UcenterSession();
        session.setClient(client);
        Date current_date=new Date();
        session.setCreateTime( current_date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(current_date);
        cal.add(Calendar.HOUR, session_exp_time);// 24小时制
        Date exp_time = cal.getTime();
        session.setExpTime(exp_time);

        session.setCreateType("account");
        session.setSysId(sys_id);
        session.setUserId(user_id);
        session.setSessionToken(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
        session.setSecKey(UUID.randomUUID().toString().replaceAll("-", ""));
        session.setIp(ip);

        //生成刷新令牌
        UcenterSessionRefToken ref=new UcenterSessionRefToken();
        ref.setCreateTime(current_date);
        ref.setUserId(user_id);
        ref.setSysId(sys_id);

        Calendar cal_ref = Calendar.getInstance();
        cal_ref.setTime(current_date);
        cal_ref.add(Calendar.HOUR, ref_token_exp_time);// 24小时制
        Date ref_exp_time = cal_ref.getTime();
        ref.setExpTime(ref_exp_time);
        String ref_toekn=UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        ref.setRefToken(ref_toekn);
        session.setRefToken(ref_toekn);

        ref.setSecKey(UUID.randomUUID().toString().replaceAll("-", ""));

        this.save(session);
        refTokenService.save(ref);

        // 映射到返回接口
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        login_info.setSys_id(sys_id);
        login_info.setUser_id(user_id);
        login_info.setSession(new SessionInfo());
        login_info.setRef_token(new RefTokenInfo());
        login_info.getSession().setCreate_time(formatter.format(current_date));
        login_info.getSession().setExp_time(formatter.format(session.getExpTime()));
        login_info.getSession().setSec_key(session.getSecKey());
        login_info.getSession().setSession_token(session.getSessionToken());

        login_info.getRef_token().setSec_key(ref.getRefToken());
        login_info.getRef_token().setCreate_time(formatter.format(ref.getCreateTime()));
        login_info.getRef_token().setExp_time(formatter.format(ref.getExpTime()));
        login_info.getRef_token().setRef_token (ref.getRefToken());

        return login_info;
    }

    @Override
    public void removeSession(String session_token) {

    }

    @Override
    public void refSession(String ref_token) {

    }
}
