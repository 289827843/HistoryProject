package com.sxun.server.platform.service.ucenter.dao;




import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.ucenter.dto.user.req.SearchMutilUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.SearchUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.UpdateUserRoleParam;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.*;
import com.sxun.server.platform.service.ucenter.model.UcenterUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UcenterUserMapper extends Mapper<UcenterUser> {

       public UcenterUser findbyaccount( String account);

       public List<UserDetail> userListResult(SearchUserParam param);

       public UserDetail userDetail(Integer user_id);

       public List<UserRoleResult> userRole(Integer user_id);

       public List<UserPermissionResult> userPermission(Integer user_id);

       public UserRoleId selectUserRole(UpdateUserRoleParam param);

       public void updateRole(UcenterRole ucenterRole);

       public List<UserDetail> mutilUser(List<Integer> ids);
}