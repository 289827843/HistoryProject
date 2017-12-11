package com.sxun.server.platform.service.ucenter.dto.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "创建用户结果对象")
public class AddUserResult {
    @ApiObjectField(description = "新增的用户ID")
    private int user_id=-1;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
