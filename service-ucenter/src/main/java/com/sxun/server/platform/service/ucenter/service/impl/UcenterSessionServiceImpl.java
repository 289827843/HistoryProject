package com.sxun.server.platform.service.ucenter.service.impl;


import com.sxun.server.common.remote.session.LoginInfo;
import com.sxun.server.common.remote.session.RefTokenInfo;
import com.sxun.server.common.remote.session.SessionInfo;
import com.sxun.server.common.util.MD5Util;
import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.Util.ResultMsg;
import com.sxun.server.platform.service.ucenter.dao.UcenterSessionMapper;
import com.sxun.server.platform.service.ucenter.dao.UcenterSessionRefTokenMapper;
import com.sxun.server.platform.service.ucenter.dto.auth.req.LoginParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.RefreshParam;
import com.sxun.server.platform.service.ucenter.model.UcenterSession;
import com.sxun.server.platform.service.ucenter.model.UcenterSessionRefToken;
import com.sxun.server.platform.service.ucenter.service.UcenterSessionRefTokenService;
import com.sxun.server.platform.service.ucenter.service.UcenterSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    @Autowired
    private UcenterSessionRefTokenMapper refTokenMapper;

    @Value("${sxun.service.login.session_exp_time}")
    private int session_exp_time;

    @Value("${sxun.service.login.ref_token_exp_time}")
    private int ref_token_exp_time;

    @Override
    public LoginInfo createSession(int user_id, LoginParam param, String ip) {
        LoginInfo login_info=new LoginInfo();

        //生成会话
        UcenterSession session=new UcenterSession();
        session.setClient(param.getClient());
        Date current_date=new Date();
        session.setCreateTime(current_date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(current_date);
        cal.add(Calendar.HOUR, session_exp_time);// 24小时制
        Date exp_time = cal.getTime();
        session.setExpTime(exp_time);

        session.setCreateType("account");
        session.setSysId(param.getSys_id());
        session.setUserId(user_id);
        session.setSessionToken(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
        session.setSecKey(UUID.randomUUID().toString().replaceAll("-", ""));
        session.setIp(ip);
        session.setState(0);


        //生成刷新令牌
        UcenterSessionRefToken ref=new UcenterSessionRefToken();
        ref.setCreateTime(current_date);
        ref.setUserId(user_id);
        ref.setSysId(param.getSys_id());

        Calendar cal_ref = Calendar.getInstance();
        cal_ref.setTime(current_date);
        cal_ref.add(Calendar.DATE, ref_token_exp_time);// 60天制
        Date ref_exp_time = cal_ref.getTime();
        ref.setExpTime(ref_exp_time);
        String ref_toekn=UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        ref.setRefToken(ref_toekn);
        session.setRefToken(ref_toekn);

        ref.setSecKey(UUID.randomUUID().toString().replaceAll("-", ""));
        ref.setState(0);       //状态 0：正常 1：禁用

        refTokenService.save(ref);
        this.save(session);

        // 映射到返回接口
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        login_info.setSys_id(param.getSys_id());
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

/*    @Override
    public void removeSession(String session_token) {

    }

    @Override
    public void refSession(String ref_token) {

    }*/

    @Override
    public ResultMsg cancel(String session_token) {

        System.out.print(session_token+"---------------------");
        ResultMsg msg = new ResultMsg();
       UcenterSession session = ucenterSessionMapper.findBySession_token(session_token);
       if (session == null){

           msg.setKey("fail");
           msg.setValue("session_token不存在");
           return msg;
       }
       Date overdue = new Date();
       session.setState(1);
       session.setExpTime(overdue);

       UcenterSessionRefToken refToken = refTokenMapper.findByReftoken(session.getRefToken());
       refToken.setState(1);
       refToken.setExpTime(overdue);

       this.update(session);
       refTokenService.update(refToken);

       msg.setKey("success");
       msg.setValue("success");
       return msg;
    }


    @Override
    public ResultMsg refresh(RefreshParam param) {

          ResultMsg msg = new ResultMsg();
          UcenterSessionRefToken refToken  = refTokenService.findBy("ref_token",param.getRef_token());
          String ref = MD5Util.MD5(refToken.getRefToken()+refToken.getSecKey());
          String ref2 = MD5Util.MD5(param.getRef_token()+param.getSec_key());
          if (!ref.equals(ref2)){

              msg.setKey("fail");
              msg.setValue("令牌输入有误");
              return msg;
          }














        return null;
    }
}













