package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "更新用户状态对象")
public class ChangeUserStatusParam {
    @ApiObjectField(description = "操作员ID,自己更新则是自身userid",required=true)
    @NotNull(message = "opr_user_id 不能为空")
    private int opr_user_id;
    @ApiObjectField(description = "需要更新的用户id",required=true)
    @NotNull(message = "要更新的user_id不能为空")
    private int user_id;
    @ApiObjectField(description = "账号状态，0=未验证 1=正常 2=禁用",required=true)
    @Min(value = 0 ,message = "status 账号状态，0=未验证 1=正常 2=禁用")
    @Max(value = 2 ,message = "status 账号状态，0=未验证 1=正常 2=禁用")
    @NotNull(message = "status 账号状态，0=未验证 1=正常 2=禁用")
    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
