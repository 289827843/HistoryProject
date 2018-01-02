package com.sxun.server.platform.service.ucenter.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lz on 2017/12/22.
 */
@Table(name = "ucenter_role_permission")
public class UcenterRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_permission_id")
    private Integer rolePermissioId;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "permission_id")
    private Integer permissionId;
    @Column(name = "`create_time`")
    private Date createTime;
    @Column(name = "`modify_time`")
    private Date modifyTime;

    public Integer getRolePermissioId() {
        return rolePermissioId;
    }

    public void setRolePermissioId(Integer rolePermissioId) {
        this.rolePermissioId = rolePermissioId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
