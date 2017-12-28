package com.sxun.server.platform.service.ucenter.itf;

import com.sxun.server.common.remote.Result;


import com.sxun.server.common.remote.session.LoginInfo;
import com.sxun.server.platform.service.ucenter.dto.auth.req.LoginParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(path="/captcha", method= RequestMethod.POST)
    public Result captcha();

}
