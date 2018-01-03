package com.sxun.server.platform.service.ucenter.dto.permission.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by lz on 2017/12/23
 */

@ApiObject(description = "权限查询")
public class SearchPermissionParam {

    @NotNull
    @Size(min = 2,max = 20,message = "权限名称在2到20位")
    @ApiObjectField(description = "权限名称",required = true)
    private String name;
    @NotNull
    @Min(value = 1,message = "权限类型1-3可选")
    @Max(value = 3,message = "权限类型1-3可选")
    @ApiObjectField(description = "权限类型 1-菜单 2-页面 3-接口操作")
    private Integer typeName;
    @ApiObjectField(description = "地址路径")
    private String linkUrl;
    @NotNull
    @ApiObjectField(description = "所属子系统id")
    private Integer sysId;
    @NotNull
    @ApiObjectField(description = "查询页")
    private Integer currentPage;
    @NotNull
    @ApiObjectField(description = "每页数量")
    private Integer pageSize;

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

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
