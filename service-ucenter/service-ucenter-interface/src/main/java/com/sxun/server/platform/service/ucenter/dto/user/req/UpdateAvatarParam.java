package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "上传并更新用户头像请求")
public class UpdateAvatarParam {
    @ApiObjectField(description = "操作员ID,自己更新则是自身userid",required=true)
    private int opr_user_id;
    @ApiObjectField(description = "需要更新的用户id",required=true)
    private int user_id;
    @ApiObjectField(description = "头像base64字符串 不能超过500*500",required=true)
    private String avatar_base64;


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

    public String getAvatar_base64() {
        return avatar_base64;
    }

    public void setAvatar_base64(String avatar_base64) {
        this.avatar_base64 = avatar_base64;
    }
}
