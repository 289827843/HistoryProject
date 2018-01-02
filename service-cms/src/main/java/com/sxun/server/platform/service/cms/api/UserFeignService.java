package com.sxun.server.platform.service.cms.api;

import com.sxun.server.platform.service.ucenter.itf.IUserController;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by leizheng on 2018/1/2.
 */
@FeignClient(name="sxun-service-ucenter" )
public interface UserFeignService extends IUserController {
}
