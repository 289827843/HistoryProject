package com.sxun.server.platform.service.ucenter.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.common.remote.session.LoginInfo;
import com.sxun.server.common.util.IpUtil;
import com.sxun.server.common.util.SessionUtil;
import com.sxun.server.platform.service.ucenter.Util.Tools;
import com.sxun.server.platform.service.ucenter.dto.auth.req.LoginParam;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.AuthCode;
import com.sxun.server.platform.service.ucenter.itf.IAuthController;
import com.sxun.server.platform.service.ucenter.service.UcenterSessionService;
import com.sxun.server.platform.service.ucenter.service.UcenterUserAuthService;
import com.sxun.server.platform.service.ucenter.service.UcenterUserService;

import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by leizheng on 12/16/2017.
 */
@Api(name = "登录授权", description = "登录授权相关服务", group = "ucenter")
@RestController
@RequestMapping("/auth")
public class AuthController  implements IAuthController {

    @ApiMethod(description = "授权测试")
    @RequestMapping(path="/test", method= RequestMethod.POST)
    @ApiAuthToken(scheme = "token")
    @Override public @ApiResponseObject Result<String> tokenTest() {
        LoginInfo login_info= SessionUtil.getLoginInfo(request.getHeader("auth_str"));
        if (login_info==null)
            return  ResultGenerator.genFailResult("找不到令牌 ");
        else
            return ResultGenerator.genSuccessResult(login_info.getSession().getSession_token());
    }

    @Autowired
    private UcenterSessionService session_service;

    @Autowired
    private UcenterUserService user_service;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UcenterUserAuthService authService;

    @Autowired
    private HttpSession session;

    @ApiMethod(description = "账号密码登录")
    @RequestMapping(path="/login", method= RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<LoginInfo> login(@ApiBodyObject  @RequestBody @Valid LoginParam param) {
        int user_id=user_service.checkUserPwd(param.getAccount(),param.getPassword());
        if (user_id!=-1){
            LoginInfo login_info=session_service.createSession(user_id,param.getSys_id(),param.getClient(), IpUtil.getIpAddr(request));
            return ResultGenerator.genSuccessResult(login_info);
        }
        else{
            return ResultGenerator.genFailResult("密码错误");
        }
    }


    @ApiMethod(description = "图形验证码")
    @RequestMapping(path="/captcha", method= RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result captcha(){

        AuthCode authCode =  authService.getAuthCode();

        return  ResultGenerator.genSuccessResult(authCode);
    }










}
