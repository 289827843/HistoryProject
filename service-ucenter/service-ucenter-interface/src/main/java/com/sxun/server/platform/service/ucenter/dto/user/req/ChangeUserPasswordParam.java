package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "修改用户密码请求对象")
public class ChangeUserPasswordParam {
    @ApiObjectField(description = "操作员ID,自己更新则是自身userid",required=true)
    @NotNull
    private int opr_user_id;
    @ApiObjectField(description = "需要更新的用户id",required=true)
    @NotNull
    private int user_id;
    @ApiObjectField(description = "旧密码，最小6位,最大30位",required=true)
    @NotEmpty
    @Size(min = 6,max = 30,message = "旧密码，最小6位,最大30位")
    private String old_pwd;

    @NotEmpty
    @Size(min = 6,max = 30,message = "新密码，最小6位,最大30位")
    @ApiObjectField(description = "新密码，最小6位,最大30位",required=true)
    private String new_pwd;

    public int getOpr_user_id() {
        return opr_user_id;
    }

    public void setOpr_user_id(int opr_user_id) {
        this.opr_user_id = opr_user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getOld_pwd() {
        return old_pwd;
    }

    public void setOld_pwd(String old_pwd) {
        this.old_pwd = old_pwd;
    }

    public String getNew_pwd() {
        return new_pwd;
    }

    public void setNew_pwd(String new_pwd) {
        this.new_pwd = new_pwd;
    }
}
