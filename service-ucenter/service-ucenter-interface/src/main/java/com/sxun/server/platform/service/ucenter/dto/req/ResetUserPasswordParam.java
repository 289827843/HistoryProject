package com.sxun.server.platform.service.ucenter.dto.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "重置用户密码请求对象")
public class ResetUserPasswordParam {

    @ApiObjectField(description = "操作员ID,自己更新则是自身userid",required=true)
    private int opr_user_id;
    @ApiObjectField(description = "需要更新的用户id",required=true)
    private int user_id;

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
}
