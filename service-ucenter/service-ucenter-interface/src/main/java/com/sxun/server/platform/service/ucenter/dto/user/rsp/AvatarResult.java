package com.sxun.server.platform.service.ucenter.dto.user.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "用户头像结果")
public class AvatarResult {
    @ApiObjectField(description = "头像id")
    private int avatar_img_id;

    public int getAvatar_img_id() {
        return avatar_img_id;
    }

    public void setAvatar_img_id(int avatar_img_id) {
        this.avatar_img_id = avatar_img_id;
    }
}
