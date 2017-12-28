package com.sxun.server.platform.service.ucenter.service.impl;


import com.github.pagehelper.PageHelper;
import com.sxun.server.common.util.IpUtil;
import com.sxun.server.common.util.MD5Util;
import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.Util.Tools;
import com.sxun.server.platform.service.ucenter.dao.UcenterUserMapper;
import com.sxun.server.platform.service.ucenter.dto.user.req.*;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.*;
import com.sxun.server.platform.service.ucenter.model.UcenterUser;
import com.sxun.server.platform.service.ucenter.model.UcenterUserAvatar;
import com.sxun.server.platform.service.ucenter.model.UcenterUserDetail;
import com.sxun.server.platform.service.ucenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by CodeGenerator on 2017/12/10.
 */
@Service
@Transactional
public class UcenterUserServiceImpl extends AbstractService<UcenterUser> implements UcenterUserService {

    @Autowired
    private UcenterUserDetailService userDetailService;

    @Autowired
    private UcenterUserLogService userLogService;

    @Autowired
    private HttpServletRequest request;

    @Resource
    private UcenterUserMapper ucenterUserMapper;
    @Resource
    private UcenterUserAvatarService ucenterUserAvatarService;

    private   Map<String,Object> map = new HashMap<String, Object>();

    private String account ,name ,nickname ,password ,mobile ,email;
    int sex;

    @Override
    public int checkUserPwd(String account, String pwd) {
        UcenterUser user=this.findBy("account",account);
        if (user==null)
            return -1;

       if (user.getPwd().toLowerCase().equals(MD5Util.MD5(pwd+account).toLowerCase()))
           return user.getUserId();
       else
           return -1;

    }

    /**
     * 用户的添加
     */
    @Override
    public Map<String,Object> addUser(AddUserParam param) {

        account = param.getAccount();
        name = param.getName();
        nickname = param.getNickname();
        sex = param.getSex();
        password = param.getPassword();
        mobile = param.getMobile();
        email = param.getEmail();

        UcenterUser ucenters = ucenterUserMapper.findbyaccount(account);
         if (ucenters != null){

             map.put("fail", "账号已经存在");
             return map;
         }

        UcenterUser ucenterUser = new UcenterUser();
        ucenterUser.setPwd(MD5Util.MD5(password+account));
        ucenterUser.setAccount(account);
        ucenterUser.setName(name);
        ucenterUser.setCreateTime(new Date());
        ucenterUser.setNickname(nickname);
        ucenterUser.setSex((byte) sex);
        ucenterUser.setStatus((byte) 1);
        ucenterUser.setAvatarImgId(Integer.valueOf(account));
        this.save(ucenterUser);

        UcenterUserDetail userDetail = new UcenterUserDetail();
        userDetail.setUserId(ucenterUser.getUserId());
        userDetail.setEmail(email);
        userDetail.setMobile(mobile);
        userDetailService.save(userDetail);

        userLogService.logAddUser(param,ucenterUser.getUserId(), IpUtil.getIpAddr(request));
        map.put("success", ucenterUser.getUserId());
        return map;

    }
    /**
     * 更新用户
     * */
    @Override
    public Map<String, Object> updateUser(UpdateUserParam param) {

         UcenterUser ucenterUser = this.findById(param.getUser_id());

         if (ucenterUser == null ){

             map.put("fail","要修改的用户不存在");
             return map;
         }
         UcenterUser user = new UcenterUser();
         user.setName(param.getName());
         user.setNickname(param.getNickname());
         user.setUserId(param.getUser_id());
         user.setSex((byte)param.getSex());
         user.setUserId(param.getUser_id());
         this.update(user);

         UcenterUserDetail userDetail = new UcenterUserDetail();
         userDetail.setUserId(param.getUser_id());
         userDetail.setEmail(param.getEmail());
         userDetail.setMobile(param.getMobile());
         userDetailService.update(userDetail);

         userLogService.logUpdateUser(param,IpUtil.getIpAddr(request));

         map.put("success","success");
         return map;
    }


    /**
     *  更新用户的状态
     * */
    @Override
    public Map<String, Object> changeUserStatus(ChangeUserStatusParam param) {

        UcenterUser ucenterUser = this.findById(param.getUser_id());
         if (ucenterUser == null){

             map.put("fail","要更改的用户不存在");
             return map;
         }
         UcenterUser ucenter = new UcenterUser();
         ucenter.setUserId(param.getUser_id());
         ucenter.setStatus((byte)param.getStatus());
         this.update(ucenter);

         userLogService.logChangeUserStatus(param,IpUtil.getIpAddr(request));

         map.put("success","success");
         return map;
    }

    @Override
    public Map<String, Object> userListResult(SearchUserParam param) {

         PageHelper.startPage(param.getCurrent_page(),param.getPage_size());

         List<UserDetail> listUserDatail = new ArrayList<UserDetail>();
         UserListResult userListResult = new UserListResult();

         List<UserDetail> list1 = ucenterUserMapper.userListResult(param);

           for (int i = 0 ; i < list1.size(); i ++){

               UserDetail user = list1.get(i);
               UserDetail userDetail = new UserDetail();
               userDetail.setUser_id(user.getUser_id());
               userDetail.setAccount(user.getAccount());
               userDetail.setName(user.getName());
               userDetail.setSex(user.getSex());
               userDetail.setStatus(user.getStatus());
               userDetail.setNickname(user.getNickname());
               userDetail.setCreate_time(user.getCreate_time());
               userDetail.setEmail(user.getEmail());
               userDetail.setMobile(user.getMobile());

               listUserDatail.add(userDetail);

           }

           if (listUserDatail.isEmpty()){

               map.put("fail","无用户");
               return  map;

           }

//            PageInfo pageInfo = new PageInfo(listUserDatail);
           if (param.getPage_size() <= 0){

               param.setPage_size(1);
           }

            userListResult.setList(listUserDatail);
            userListResult.setTotal_count(list1.size()); //总计数
            userListResult.setTotal_page(list1.size()/param.getPage_size());
            userListResult.setCurrent_page(param.getCurrent_page()>0?param.getCurrent_page():1);
            userListResult.setPage_size(param.getPage_size()>0?param.getPage_size():1);

            map.put("success",userListResult);
            return map;

    }

    @Override
    public Map<String, Object> changeUserPassword(ChangeUserPasswordParam param) {

              UcenterUser user = this.findById(param.getUser_id());
              if (user == null){

                  map.put("fail","用户不存在");

                  return map;
              }
              if (!user.getPwd().equals(MD5Util.MD5(param.getOld_pwd()+user.getAccount()))){

                  map.put("fail","旧密码输入不正确");

                  return map;
              }

              UcenterUser ucenterUser = new UcenterUser();
              ucenterUser.setUserId(param.getUser_id());
              ucenterUser.setPwd(MD5Util.MD5(param.getNew_pwd()+user.getAccount()));
              this.save(ucenterUser);

              userLogService.logChangeUserPassword(param,IpUtil.getIpAddr(request));
              map.put("success","success");

              return map;
    }


    @Override
    public Map<String, Object> resetUserPassword(ResetUserPasswordParam param) {

        UcenterUser user = this.findById(param.getUser_id());

           if (user == null){

               map.put("fail","用户不存在");
               return map;
           }

         UcenterUser ucenterUser = new UcenterUser();
         ucenterUser.setUserId(param.getUser_id());
         String pwd = Tools.getRandomPwd(6)+user.getAccount();
         ucenterUser.setPwd(MD5Util.MD5(pwd));
         this.update(ucenterUser);

         userLogService.logResetUserPassword(param,IpUtil.getIpAddr(request));

         map.put("success","success");
         return map;
    }

    @Override
    public Map<String, Object> updateAvatar(UpdateAvatarParam param) {

        UcenterUser user = this.findById(param.getUser_id());

        if (user == null){

            map.put("fail","用户不存在");
            return map;
        }

        UcenterUserAvatar userAvatar = new UcenterUserAvatar();
        userAvatar.setImgData(param.getAvatar_base64().getBytes());
        userAvatar.setUserId(param.getUser_id());

        UcenterUserAvatar userAvatar1 =ucenterUserAvatarService.findById(param.getUser_id());

        if (userAvatar1 == null ){

            ucenterUserAvatarService.save(userAvatar);
        }else{

            ucenterUserAvatarService.update(userAvatar);
        }

         userLogService.logUpdateAvatar(param,IpUtil.getIpAddr(request));

         map.put("success",userAvatar.getUserId());
         return map;
    }


    @Override
    public Map<String, Object> userDetail(Integer user_id) {

        if (user_id == null){

            map.put("fail","userId不能为空");
            return map;
        }

        UserDetail userDetail = ucenterUserMapper.userDetail(user_id);

        if (userDetail == null){

            map.put("fail","用户不存在");
            return map;

        }

        map.put("success",userDetail);
        return map;

    }


    @Override
    public Map<String, Object> userRole(Integer user_id) {

       if (user_id == null){

           map.put("fail","userId不能为空");
           return map;
       }
        List<List> arrayList = new ArrayList<List>();

        List<UserRoleResult> roleResults = ucenterUserMapper.userRole(user_id);  //角色列表
        List<UserPermissionResult> permissionResults = ucenterUserMapper.userPermission(user_id);  //去重后的权限列表

        arrayList.add(roleResults);
        arrayList.add(permissionResults);
        map.put("success",arrayList);
        return map;
    }

    @Override
    public Map<String, Object> userRoleUpdate(UpdateUserRoleParam param) {

          UserRoleId userRoleId = ucenterUserMapper.selectUserRole(param);

          if (userRoleId == null){

              map.put("fail","用户角色不存在 请输入正确user_i、role_id、sys_id");
              return map;

          }
          UcenterRole ucenterRole = new UcenterRole();
          ucenterRole.setRole_id(param.getRole_id());
          ucenterRole.setSys_id(param.getSys_id());
          ucenterRole.setDesc(param.getDesc());
          ucenterRole.setName(param.getName());

          ucenterUserMapper.updateRole(ucenterRole);

           map.put("success","success");
           return map;
     }
}














