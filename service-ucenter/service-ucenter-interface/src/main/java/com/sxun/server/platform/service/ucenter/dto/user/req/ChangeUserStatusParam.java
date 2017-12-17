package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "更新用户状态对象")
public class ChangeUserStatusParam {
    @ApiObjectField(description = "操作员ID,自己更新则是自身userid",required=true)
    private int opr_user_id;
    @ApiObjectField(description = "需要更新的用户id",required=true)
    private int user_id;
    @ApiObjectField(description = "账号状态，0=未验证 1=正常 2=禁用",required=true)
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
