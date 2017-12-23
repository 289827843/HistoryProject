package com.sxun.server.platform.service.ucenter.dao;


import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.ucenter.dto.user.req.SearchUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserDetail;
import com.sxun.server.platform.service.ucenter.model.UcenterUser;
import com.sxun.server.platform.service.ucenter.model.UcenterUserDetail;

import java.util.List;

public interface UcenterUserMapper extends Mapper<UcenterUser> {

       public UcenterUser findbyaccount(String account);

       public List<UserDetail> userListResult(SearchUserParam param);


}