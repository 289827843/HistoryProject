package com.sxun.server.platform.service.ucenter.dto.rolper.rsp;


import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by lz on 2017/12/23.
 */

@ApiObject(description = "角色对应权限查询结果")
public class PermissionListResult {
    @ApiObjectField(description = "权限id")
    private Integer permission_id;
    @ApiObjectField(description = "权限名称")
    private String name;
    @ApiObjectField(description = "权限类型 1-菜单 2-页面 3-接口操作")
    private Integer type_name;
    @ApiObjectField(description = "地址路径")
    private String link_url;
    @ApiObjectField(description = "所属子系统id")
    private Integer sys_id;
    @ApiObjectField(description = "创建时间")
    private String create_time;
    @ApiObjectField(description = "修改时间")
    private String modify_time;

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType_name() {
        return type_name;
    }

    public void setType_name(Integer type_name) {
        this.type_name = type_name;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public Integer getSys_id() {
        return sys_id;
    }

    public void setSys_id(Integer sys_id) {
        this.sys_id = sys_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }
}
