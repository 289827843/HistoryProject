package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.dao.UcenterRolePermissionMapper;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.UpdateRolePermissionParam;
import com.sxun.server.platform.service.ucenter.model.UcenterRolePermission;
import com.sxun.server.platform.service.ucenter.service.UcenterRolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lz on 2017/12/25.
 */
@Service
public class UcenterRolePermissionServiceImpl extends AbstractService<UcenterRolePermission> implements UcenterRolePermissionService{

    @Resource
    private UcenterRolePermissionMapper ucenterRolePermissionMapper;

    /**
     * 角色对应权限更新
     * @param param
     * @return 1-更新成功 0-更新失败
     */
    @Transactional
    @Override
    public int updateRolePermission(UpdateRolePermissionParam param) {

        List<Integer> permisssionIdList = param.getPermissionIdList();
        Set set = new HashSet(permisssionIdList);
        //判断list里面的permission_id是否重复
        if(set.size()<permisssionIdList.size()){
            return 0;//重复返回更新失败
        }else {
            //删除指定的role_id对应的记录
            int deleteResult = ucenterRolePermissionMapper.deleteRolePermissionByRoleId(param.getRole_id());
            if (deleteResult==0){
                return 0;
            }else {
                //添加指定的role_id 和permission_id
                for (int i = 0;i<permisssionIdList.size();i++){
                    UcenterRolePermission ucenterRolePermission = new UcenterRolePermission();
                    ucenterRolePermission.setRoleId(param.getRole_id());
                    ucenterRolePermission.setPermissionId(permisssionIdList.get(i));
                    ucenterRolePermission.setCreateTime(new Date());
                    ucenterRolePermission.setModifyTime(new Date());
                    this.save(ucenterRolePermission);
                }
                return 1;
            }


        }


    }
}
