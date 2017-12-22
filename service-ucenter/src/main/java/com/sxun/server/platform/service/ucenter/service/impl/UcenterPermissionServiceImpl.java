package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.dao.UcenterPermissionMapper;
import com.sxun.server.platform.service.ucenter.model.UcenterPermission;
import com.sxun.server.platform.service.ucenter.service.UcenterPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by lz on 2017/12/22.
 */
@Service
@Transactional
public class UcenterPermissionServiceImpl extends AbstractService<UcenterPermission> implements UcenterPermissionService{

    @Resource
    private UcenterPermissionMapper ucenterPermissionMapper;

    /**
     * 权限添加
     * @param permission
     * @return 0失败或者成功new permission_id
     */
    @Override
    public int addPermission(UcenterPermission permission) {
        List<UcenterPermission> ucenterPermissionList = ucenterPermissionMapper.selectSysId(permission);
        List<UcenterPermission> ucenterPermissionList1 = ucenterPermissionMapper.selectIsUnique(permission);
        if (ucenterPermissionList.size()>0 && ucenterPermissionList1.size()==0){
            permission.setCreateTime(new Date());
            permission.setModifyTime(new Date());
            this.save(permission);//执行插入语句
            return permission.getPermissionId();
        }else {
            return 0;
        }
    }
}
