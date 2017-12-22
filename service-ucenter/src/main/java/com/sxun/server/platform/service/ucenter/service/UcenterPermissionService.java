package com.sxun.server.platform.service.ucenter.service;

import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.ucenter.model.UcenterPermission;

/**
 * Created by lz on 2017/12/22.
 */
public interface UcenterPermissionService extends Service<UcenterPermission>{
    //权限添加
    public int addPermission(UcenterPermission permission);
}
