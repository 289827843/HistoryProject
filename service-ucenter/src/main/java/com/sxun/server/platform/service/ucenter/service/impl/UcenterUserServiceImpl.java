package com.sxun.server.platform.service.ucenter.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxun.server.common.util.IpUtil;
import com.sxun.server.common.util.MD5Util;
import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.Util.Tools;
import com.sxun.server.platform.service.ucenter.dao.UcenterUserMapper;
import com.sxun.server.platform.service.ucenter.dto.user.req.AddUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.ChangeUserStatusParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.SearchUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.req.UpdateUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserDetail;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserListResult;
import com.sxun.server.platform.service.ucenter.model.UcenterUser;
import com.sxun.server.platform.service.ucenter.model.UcenterUserDetail;
import com.sxun.server.platform.service.ucenter.service.UcenterUserDetailService;
import com.sxun.server.platform.service.ucenter.service.UcenterUserLogService;
import com.sxun.server.platform.service.ucenter.service.UcenterUserService;
import org.apache.catalina.startup.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private SimpleDateFormat dateFormat = new SimpleDateFormat();

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

        Map<String, Object> map = new HashMap<String, Object>();
        account = param.getAccount();
        name = param.getName();
        nickname = param.getNickname();
        sex = param.getSex();
        password = param.getPassword();
        mobile = param.getMobile();
        email = param.getEmail();


        UcenterUser ucenters = ucenterUserMapper.findbyaccount(account);
         if (ucenters == null){

             map.put("fail", "账号已经存在");
             return map;
         }



        UcenterUser ucenterUser = new UcenterUser();
        ucenterUser.setPwd(MD5Util.MD5(password)+account);
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

         Map<String,Object> map = new HashMap<String, Object>();

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

        Map<String,Object> map = new HashMap<String, Object>();
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
         Map<String,Object> map = new HashMap<String, Object>();

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

}
