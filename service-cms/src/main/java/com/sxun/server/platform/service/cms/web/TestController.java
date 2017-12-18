package com.sxun.server.platform.service.cms.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.platform.service.cms.dto.req.TestParam;
import com.sxun.server.platform.service.cms.itf.ITestController;
import com.sxun.server.platform.service.cms.model.CmsCatagory;
import com.sxun.server.platform.service.cms.service.CmsCatagoryService;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by leizheng on 12/17/2017.
 */
@Api(name = "登录授权", description = "登录授权相关服务", group = "ucenter")
@RestController
@RequestMapping("/test")
public class TestController implements ITestController {

    @Autowired
    private CmsCatagoryService cms_service;

    @ApiMethod(description = "授权测试")
    @RequestMapping(path="/do_test", method= RequestMethod.POST)
    @Override
    public @ApiResponseObject Result<String> test(@ApiBodyObject @RequestBody @Valid TestParam param) {

        CmsCatagory cc=cms_service.findById(1);
        if (cc !=null)
            return ResultGenerator.genSuccessResult(cc.getName());
        else
            return  ResultGenerator.genFailResult("未找到");
    }
}
