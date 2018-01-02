package com.sxun.server.platform.service.ucenter.dto.user.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.List;

/**
 * Created by lz on 2018/1/2.
 */
@ApiObject(description = "多用户查询结果")
public class SearchMutilUserResult {

    @ApiObjectField(description = "用户详情集合")
    private List<UserDetail> userDetailList;

    public List<UserDetail> getUserDetailList() {
        return userDetailList;
    }

    public void setUserDetailList(List<UserDetail> userDetailList) {
        this.userDetailList = userDetailList;
    }
}
