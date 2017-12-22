package com.sxun.server.platform.service.ucenter.model;

import javax.persistence.*;
import java.util.Date;

/**
 * created by lz on 2017/12/21.
 */
@Table(name = "ucenter_permission")
public class UcenterPermission {
    /**
     * 权限id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;
    /**
     * 权限名称
     */
    @Column(name = "`name`")
    private String name;
    /**
     * 权限类型
     */
    @Column(name = "type_name")
    private Integer typeName;

    /**
     * 地址路径
     */
    @Column(name = "`link_url`")
    private String linkUrl;
    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;
    /**
     * 修改时间
     */
    @Column(name = "`modify_time`")
    private Date modifyTime;
    /**
     * 所属子系统id
     */
    @Column(name = "sys_id")
    private Integer sysId;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeName() {
        return typeName;
    }

    public void setTypeName(Integer typeName) {
        this.typeName = typeName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
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

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }
}
