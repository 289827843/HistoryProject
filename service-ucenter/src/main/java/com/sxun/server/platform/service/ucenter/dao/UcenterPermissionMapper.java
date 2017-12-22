package com.sxun.server.platform.service.ucenter.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.ucenter.model.UcenterPermission;

import java.util.List;

/**
 * Created by lz on 2017/12/22.
 */
public interface UcenterPermissionMapper extends Mapper<UcenterPermission>{
    //查询是否存在指定的sys_id
    public List<UcenterPermission> selectSysId(UcenterPermission ucenterPermission);
    //查询制定的name+sys_id 是否唯一
    public List<UcenterPermission> selectIsUnique(UcenterPermission ucenterPermission);

}
