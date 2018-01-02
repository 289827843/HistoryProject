package com.sxun.server.platform.service.ucenter.itf;

import com.sxun.server.common.remote.Result;


import com.sxun.server.common.remote.session.LoginInfo;
import com.sxun.server.platform.service.ucenter.dto.auth.req.LoginParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.RefreshParam;
import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by leizheng on 12/16/2017.
 */
@RestController
@RequestMapping("/auth")
public interface IAuthController {

    @RequestMapping(path="/login", method= RequestMethod.POST)
    public Result<LoginInfo> login(@RequestBody LoginParam param);

    @RequestMapping(path="/test", method= RequestMethod.POST)
    public Result<String> tokenTest();

    @RequestMapping(path="/captcha", method= RequestMethod.GET)
    public Result captcha();

    @RequestMapping(path="/cancel/{session_token}", method= RequestMethod.POST)
    public @ApiResponseObject  Result cancel(@ApiPathParam(name="session_token",description = "用户session_token") @PathVariable String session_token);

    @RequestMapping(path="/refresh", method= RequestMethod.POST)
    public @ApiResponseObject Result refresh(@ApiBodyObject @RequestBody @Valid RefreshParam param);

    @RequestMapping(path="/token", method= RequestMethod.POST)
    public @ApiResponseObject Result token();

}
