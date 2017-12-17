package com.sxun.server.platform.service.ucenter.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.*;

@Table(name = "ucenter_user")
public class UcenterUser {
    /**
     * 用户唯一标示
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别：(0：未知,1:男,2:女)
     */
    private Byte sex;

    /**
     * 头像对应的图片表id
     */
    @Column(name = "avatar_img_id")
    private Integer avatarImgId;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 账号状态，0=未验证 1=正常 2=禁用
     */
    private Byte status;

    /**
     * md5(密码+salt)
     */
    private String pwd;

    private String salt;

    /**
     * 获取用户唯一标示
     *
     * @return user_id - 用户唯一标示
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户唯一标示
     *
     * @param userId 用户唯一标示
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取登录账号
     *
     * @return account - 登录账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置登录账号
     *
     * @param account 登录账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取性别：(0：未知,1:男,2:女)
     *
     * @return sex - 性别：(0：未知,1:男,2:女)
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别：(0：未知,1:男,2:女)
     *
     * @param sex 性别：(0：未知,1:男,2:女)
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取头像对应的图片表id
     *
     * @return avatar_img_id - 头像对应的图片表id
     */
    public Integer getAvatarImgId() {
        return avatarImgId;
    }

    /**
     * 设置头像对应的图片表id
     *
     * @param avatarImgId 头像对应的图片表id
     */
    public void setAvatarImgId(Integer avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    /**
     * 获取注册时间
     *
     * @return create_time - 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册时间
     *
     * @param createTime 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取账号状态，0=未验证 1=正常 2=禁用
     *
     * @return status - 账号状态，0=未验证 1=正常 2=禁用
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置账号状态，0=未验证 1=正常 2=禁用
     *
     * @param status 账号状态，0=未验证 1=正常 2=禁用
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取md5(密码+salt)
     *
     * @return pwd - md5(密码+salt)
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置md5(密码+salt)
     *
     * @param pwd md5(密码+salt)
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
}