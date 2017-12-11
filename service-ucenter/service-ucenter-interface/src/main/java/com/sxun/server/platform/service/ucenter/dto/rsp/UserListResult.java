package com.sxun.server.platform.service.ucenter.dto.rsp;

import com.github.pagehelper.PageInfo;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.List;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "用户查询列表")
public class UserListResult {
    @ApiObjectField(description = "分页结果")
    private PageInfo<List<UserDetail>> list;

    public PageInfo<List<UserDetail>> getList() {
        return list;
    }

    public void setList(PageInfo<List<UserDetail>> list) {
        this.list = list;
    }
}
