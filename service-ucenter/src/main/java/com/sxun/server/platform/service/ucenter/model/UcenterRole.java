package com.sxun.server.platform.service.ucenter.model;

import javax.persistence.*;

/**
 * created by lz on 2017/12/19.
 */

@Table(name = "ucenter_role")
public class UcenterRole {
    /**
     * 角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    /**
     * 角色名称
     */
    @Column(name = "`name`")
    private String name;
    /**
     * 角色描述
     */
    @Column(name = "`desc`")
    private String desc;
    /**
     * 角色所属子系统 1-前台角色 2-后台角色
     */
    @Column(name = "sys_id")
    private  Integer sysId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }
}
