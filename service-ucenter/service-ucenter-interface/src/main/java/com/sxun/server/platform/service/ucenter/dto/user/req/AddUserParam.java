package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "创建用户请求对象")
public class AddUserParam {
    @ApiObjectField(description = "操作员ID,具有权限的操作员ID",required=true)
    private int opr_user_id;

    @ApiObjectField(description = "账号,最小3位 最大20位 数字和英文",required=true)
    private String account;

    @ApiObjectField(description = "姓名,最小2位，最大5位")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiObjectField(description = "昵称,最小3位，最大10位")
    private String nickname;
    @ApiObjectField(description = "性别 0=未知 1=男 2=女 ",allowedvalues ={"0","1","2"})
    private int sex;

    @ApiObjectField(description = "密码 最小6位,最大30位")
    private String password;

    @ApiObjectField(description = "电话号码 11位")
    private String mobile;
    @ApiObjectField(description = "电子邮箱 格式 111@xx.xx")
    private String email;

    public int getOpr_user_id() {
        return opr_user_id;
    }

    public void setOpr_user_id(int opr_user_id) {
        this.opr_user_id = opr_user_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
