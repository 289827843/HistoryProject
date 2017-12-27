package com.sxun.server.platform.service.ucenter.dto.role.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.Size;

/**
 * created by lz on 2017/12/20.
 */

@ApiObject(description = "角色修改")
public class UpdateRoleParam {
    @ApiObjectField(description = "角色id",required = true)
    private Integer role_id;
    @Size(min = 2,max = 20,message = "角色名称应该在2到20位")
    @ApiObjectField(description = "角色名称",required = true)
    private String name;
    @Size(max = 50,message = "角色描述应该在0到50位")
    @ApiObjectField(description = "角色描述",required = true)
    private String desc;
    //@ApiObjectField(description = "所属子系统")
    //private int sys_id;
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
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

    //public int getSys_id() {
  //      return sys_id;
   // }

   // public void setSys_id(int sys_id) {
   //     this.sys_id = sys_id;
  //  }
}
