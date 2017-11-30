package com.sxun.server.platform.service.ucenter.dto.user.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by lz on 2017/12/28.
 */
@ApiObject(description = "注册用户结果对象")
public class RegUserResult {

    @ApiObjectField(description = "成功新增的用户id")
    private Integer user_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public RegUserResult(Integer user_id){
        this.user_id = user_id;
    }
}
