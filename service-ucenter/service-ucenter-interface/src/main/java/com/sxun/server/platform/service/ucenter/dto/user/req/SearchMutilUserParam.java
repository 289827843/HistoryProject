package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.List;

/**
 * Created by lz on 2018/1/2.
 */
@ApiObject(description = "多个用户查询参数对象")
public class SearchMutilUserParam {

    @NotEmpty(message = "请输入用户id")
    @ApiObjectField(description = "用户id数组",required = true)
    private List<Integer> userIdList;

    public List<Integer> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Integer> userIdList) {
        this.userIdList = userIdList;
    }
}
