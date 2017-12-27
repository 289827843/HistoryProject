package com.sxun.server.platform.service.ucenter.service;

import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.model.UcenterUserAvatar;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UcenterUserAvatarService extends Service<UcenterUserAvatar> {


    public Map<String,Object> outPutAvatar(HttpServletResponse response , Integer integer);


}
