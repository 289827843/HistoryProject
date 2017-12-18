package com.sxun.server.platform.service.cms.itf;

import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.cms.dto.req.TestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leizheng on 12/17/2017.
 */
@RestController
@RequestMapping("/test")
public interface ITestController {
    @RequestMapping(path="/do_test", method= RequestMethod.POST)
    Result<String> test(@RequestBody TestParam param);
}
