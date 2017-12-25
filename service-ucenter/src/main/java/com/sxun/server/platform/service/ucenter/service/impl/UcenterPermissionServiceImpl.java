package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.dao.UcenterPermissionMapper;
import com.sxun.server.platform.service.ucenter.dao.UcenterRolePermissionMapper;
import com.sxun.server.platform.service.ucenter.dao.UcenterSysMapper;
import com.sxun.server.platform.service.ucenter.dto.permission.req.SearchPermissionParam;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.PerListResult;
import com.sxun.server.platform.service.ucenter.dto.permission.rsp.PermissionInfo;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.SelectRolePerParam;
import com.sxun.server.platform.service.ucenter.dto.rolper.req.UpdateRolePermissionParam;
import com.sxun.server.platform.service.ucenter.dto.rolper.rsp.PermissionListResult;
import com.sxun.server.platform.service.ucenter.model.UcenterPermission;
import com.sxun.server.platform.service.ucenter.model.UcenterSys;
import com.sxun.server.platform.service.ucenter.service.UcenterPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private UcenterSysMapper ucenterSysMapper;

    @Resource
    private UcenterRolePermissionMapper ucenterRolePermissionMapper;

    /**
     * 权限添加
     * @param permission
     * @return 0失败或者成功new permission_id
     */
    @Override
    public int addPermission(UcenterPermission permission) {
        //查询sys_id是否存在
        UcenterSys ucenterSys = new UcenterSys();
        ucenterSys.setSysId(permission.getSysId());
        UcenterSys sys = ucenterSysMapper.selectByPrimaryKey(ucenterSys);
        //查询name+sys_id是否唯一
        List<UcenterPermission> ucenterPermissionList1 = ucenterPermissionMapper.selectIsUnique(permission);
        if (sys!=null && ucenterPermissionList1.size()==0){
            permission.setCreateTime(new Date());
            permission.setModifyTime(new Date());
            this.save(permission);//执行插入语句
            return permission.getPermissionId();
        }else {
            return 0;
        }
    }

    /**
     * 权限修改
     * @param permission
     * @return 1或者0 1代表权限修改成功 0代表权限修改失败
     */
    @Override
    public int updatePermission(UcenterPermission permission) {
        //查询修改id是否存在
        UcenterPermission ucenterPermission = this.findById(permission.getPermissionId());
        if (ucenterPermission==null){
            return 0;
        }else {
            //查询name+sys_id是否唯一
            int uniqueRes = ucenterPermissionMapper.checkUnique(permission);
            if (uniqueRes==0){
                permission.setCreateTime(ucenterPermission.getCreateTime());
                permission.setModifyTime(new Date());
                try {
                    this.update(permission);
                    return 1;
                }catch (Exception e){
                    return 0;
                }
            }else {
                return 0;
            }
        }
    }

    /**
     * 权限删除
     * @param permission
     * @return 1或者0 1代表权限删除成功 0代表权限删除失败
     */
    @Override
    public int deletePermission(UcenterPermission permission) {
        int deleteResult = ucenterPermissionMapper.deleteByPrimaryKey(permission);
        if(deleteResult>0){
            return 1;//删除成功
        }else {
            return 0;
        }
    }

    /**
     * 权限查询
     * @param param
     * @return PerListResult集合
     */
    @Override
    public List<PerListResult> selectPermission(SearchPermissionParam param) {
        List<PerListResult> perListResults = new ArrayList<PerListResult>();
        List<PermissionInfo> permissionInfoList = ucenterPermissionMapper.selectPermission(param);
        if (permissionInfoList.size()>0){
            for (int i=0;i<permissionInfoList.size();i++){
                PerListResult perListResult = new PerListResult();
                perListResult.setList(permissionInfoList);
                perListResult.setCurrent_page(param.getCurrentPage());
                perListResult.setPage_size(param.getPageSize());
                perListResults.add(perListResult);
            }
            return perListResults;
        }else {
            return null;
        }
    }

    /**
     * 角色对应权限查询
     * @param param
     * @return 权限集合
     */
    @Override
    public List<PermissionListResult> selectRolePermission(SelectRolePerParam param) {
        List<PermissionListResult> permissionListResults = ucenterPermissionMapper.selectPermissions(param);
        return permissionListResults;
    }


}
