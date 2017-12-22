package com.sxun.server.platform.service.ucenter.dto.role.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.Size;

/**
 * created by lz on 2017/12/20.
 */
@ApiObject(description = "角色添加")
public class AddRoleParam {
    //@ApiObjectField(description = "角色id")
    //private  int role_id;
    @Size(min = 2,max = 20,message = "角色名称应该在2到20位")
    @ApiObjectField(description = "角色名称 2到20位",required = true)
    private String name;
    @Size(max = 50,message = "角色描述应该在0到50位")
    @ApiObjectField(description = "角色描述 0到50位",required = true)
    private String desc;
    @ApiObjectField(description = "角色所属子系统",required = true)
    private Integer sys_id;

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

    public Integer getSys_id() {
        return sys_id;
    }

    public void setSys_id(Integer sys_id) {
        this.sys_id = sys_id;
    }
}
