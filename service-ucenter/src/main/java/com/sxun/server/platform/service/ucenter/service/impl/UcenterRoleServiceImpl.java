package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.dao.UcenterRoleMapper;
import com.sxun.server.platform.service.ucenter.dao.UcenterRolePermissionMapper;
import com.sxun.server.platform.service.ucenter.dto.role.req.AddRoleParam;
import com.sxun.server.platform.service.ucenter.model.UcenterRole;
import com.sxun.server.platform.service.ucenter.service.UcenterRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * created by lz on 2017/12/19.
 */
@Service
@Transactional
public class UcenterRoleServiceImpl extends AbstractService<UcenterRole> implements UcenterRoleService{

    @Resource
    private UcenterRoleMapper ucenterRoleMapper;
    @Resource
    private UcenterRolePermissionMapper ucenterRolePermissionMapper;

    /**
     * 角色查询
     * @param role
     * @return UcenterRole集合
     */
    @Override
    public List<UcenterRole> selectRole(UcenterRole role) {
        List<UcenterRole> roleList = new ArrayList<UcenterRole>();
        UcenterRole ucenterRole = new UcenterRole();
        //给UcenterRole赋初值
        ucenterRole.setRoleId(null);
        ucenterRole.setName(null);
        ucenterRole.setDesc(null);
        ucenterRole.setSysId(null);
        //判断前台是根据sys_id查询还是role_id查询角色
        //如果role_id为空,则不使用role_id查询，根据sys_id查询；否则根据role_id查询，不管sys_id值是多少
        //如果sys_id为空,则查询所有角色
        if(role.getRoleId().equals("")||role.getRoleId()==null||role.getRoleId()==0){
            if(role.getSysId().equals("")||role.getSysId()==null||role.getSysId()==0){
                roleList = this.findAll();//查询所有角色
                if(roleList.size()<0){
                    roleList.add(ucenterRole);
                }
            }else {
                roleList = ucenterRoleMapper.selectRoleBySysId(role);//根据sys_id查询
                if (roleList.size()<0){
                    roleList.add(ucenterRole);
                }
            }

        }else{
            UcenterRole roleResult = this.findById(role.getRoleId());//根据role_id查询
            if (roleResult==null){
                roleList.add(ucenterRole);
            }else{
                roleList.add(roleResult);
            }

        }

        return  roleList;
    }

    /**
     * 角色添加
     * @param role
     * @return 1或者0 1代表角色添加成功 0代表角色添加失败
     */
    @Override
    public int addRole(UcenterRole role) {
        //先根据角色名称查询是否已经存在该角色，如果结果大于0则返回0，代表失败,否则执行插入语句
        List<UcenterRole> roleList = new ArrayList<UcenterRole>();
        roleList = ucenterRoleMapper.selectRoleByName(role);
        if(roleList.size()>0){
            return 0;
        }else {
            this.save(role);

            return role.getRoleId();

        }

    }

    /**
     * 角色修改
     * @param role
     * @return 1或者0 1代表角色修改成功 0代表角色修改失败
     */
    @Override
    public int updateRole(UcenterRole role) {
        //先根据角色名称查询是否已经存在该角色，如果结果大于0则返回0，代表失败,否则执行修改语句
        List<UcenterRole> roleList = new ArrayList<UcenterRole>();
        roleList = ucenterRoleMapper.selectRoleByName(role);
        if(roleList.size()>0){
            return 0;
        }else {
            int roleResult = ucenterRoleMapper.updateByPrimaryKey(role);
            //如果修改语句执行结果>0,即修改成功。否则返回0，修改失败
            if(roleResult>0){
                return roleResult;
            }else {
                return 0;
            }
        }
    }

    /**
     * 角色删除
     * @param role
     * @return 1或者0 1代表角色删除成功 0代表角色删除失败
     */

    @Override
    public int deleteRole(UcenterRole role) {


        //删除角色表
        int roleResult1 = ucenterRoleMapper.deleteRoleByKey(role);
        //删除角色权限对应表
        int roleResult2 = ucenterRolePermissionMapper.deleteRolePermissionByRoleId(role.getRoleId());
        if(roleResult1>0 && roleResult2>0){
            return 1;//删除成功
        }else {
            return 0;//删除失败
        }

    }
}
