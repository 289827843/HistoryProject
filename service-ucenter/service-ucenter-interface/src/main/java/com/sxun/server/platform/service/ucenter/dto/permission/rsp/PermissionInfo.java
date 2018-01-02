package com.sxun.server.platform.service.ucenter.dto.permission.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

/**
 * Created by lz on 2017/12/23.
 */

@ApiObject(description = "权限信息")
public class PermissionInfo implements Serializable{
    @ApiObjectField(description = "权限id")
    private Integer permissionId;
    @ApiObjectField(description = "权限名称")
    private String name;
    @ApiObjectField(description = "权限类型")
    private Integer typeName;
    @ApiObjectField(description = "地址路径")
    private String linkUrl;
    @ApiObjectField(description = "所属子系统id")
    private Integer sysId;
    @ApiObjectField(description = "创建时间")
    private String createTime;
    @ApiObjectField(description = "修改时间")
    private String modifyTime;

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

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
