package com.sxun.server.platform.service.ucenter.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.common.remote.session.LoginInfo;
import com.sxun.server.common.util.IpUtil;
import com.sxun.server.common.util.SessionUtil;
import com.sxun.server.platform.service.ucenter.Util.ResultMsg;
import com.sxun.server.platform.service.ucenter.Util.Tools;
import com.sxun.server.platform.service.ucenter.dto.auth.req.LoginParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.RefreshParam;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.AuthCode;
import com.sxun.server.platform.service.ucenter.itf.IAuthController;
import com.sxun.server.platform.service.ucenter.service.UcenterSessionService;
import com.sxun.server.platform.service.ucenter.service.UcenterUserAuthService;
import com.sxun.server.platform.service.ucenter.service.UcenterUserService;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

        System.out.println(session.getAttribute("authCode_name")+"--------------------------------------------------");

        if (!session.getAttribute("authCode_name").equals(param.getAuthCode_name())){

            return ResultGenerator.genFailResult("验证码输入错误，请重输验证码");
        }

        int user_id=user_service.checkUserPwd(param.getAccount(),param.getPassword());
        if (user_id!=-1){
            LoginInfo login_info=session_service.createSession(user_id,param, IpUtil.getIpAddr(request));
            return ResultGenerator.genSuccessResult(login_info);
        }
        else{
            return ResultGenerator.genFailResult("密码错误");
        }
    }


    @ApiMethod(description = "图形验证码")
    @RequestMapping(path="/captcha", method= RequestMethod.GET)
    @Override
    public  @ApiResponseObject Result captcha(){

        AuthCode authCode =  authService.getAuthCode();
        session.setAttribute("authCode_id",authCode.getAuthCode_id());
        session.setAttribute("authCode_name",authCode.getAuthCode_name());

        return  ResultGenerator.genSuccessResult(authCode);
    }



     @ApiMethod(description = "用户注销")
     @RequestMapping(path="/cancel/{session_token}", method= RequestMethod.POST)
     @Override
     public @ApiResponseObject  Result cancel(@ApiPathParam(name="session_token",description = "用户session_token")
                                                   @PathVariable @NotEmpty(message = "session_token不能为空") String session_token){

       ResultMsg msg = session_service.cancel(session_token);
       if (msg.getKey().equals("fail")){

           return ResultGenerator.genFailResult(msg.getValue().toString());
       }
        return ResultGenerator.genSuccessResult(msg.getValue().toString());
     }

     @ApiMethod(description = "令牌刷新")
     @RequestMapping(path="/refresh", method= RequestMethod.POST)
     @Override
     public @ApiResponseObject Result refresh(@ApiBodyObject  @RequestBody @Valid RefreshParam param){

      System.out.print(param.getRef_token()+"--------");




        return null;
     }


     @ApiMethod(description = "令牌校验")
     @RequestMapping(path="/token", method= RequestMethod.POST)
     @Override
     public @ApiResponseObject Result token(){







        return null;
     }



}

















