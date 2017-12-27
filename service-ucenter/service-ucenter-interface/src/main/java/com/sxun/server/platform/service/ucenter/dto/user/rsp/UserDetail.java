package com.sxun.server.platform.service.ucenter.dto.user.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "用户详情")
public class UserDetail implements Serializable {
    @ApiObjectField(description = "用户id")
    private int user_id;

    @ApiObjectField(description = "账号")
    private String account;

    @ApiObjectField(description = "姓名")
    private String name;

    @ApiObjectField(description = "昵称")
    private String nickname;
    @ApiObjectField(description = "性别 0=未知 1=男 2=女 ")
    private int sex;

    @ApiObjectField(description = "头像id ")
    private int avatar_img_id;

    @ApiObjectField(description = "电话号码 11位")
    private String mobile;
    @ApiObjectField(description = "电子邮箱 111@xx.xx")
    private String email;

    @ApiObjectField(description = "状态")
    private int status;

    @ApiObjectField(description = "创建时间")
    private String create_time;

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAvatar_img_id() {
        return avatar_img_id;
    }

    public void setAvatar_img_id(int avatar_img_id) {
        this.avatar_img_id = avatar_img_id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
