package com.sxun.server.platform.service.ucenter.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ucenter_session")
public class UcenterSession {
    @Id
    @Column(name = "session_token")
    private String sessionToken;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 过期时间
     */
    @Column(name = "exp_time")
    private Date expTime;

    @Column(name = "sys_id")
    private Integer sysId;

    /**
     * 客户端信息  移动端、桌面端 填客户端版本号; 后台 填浏览器 agent
     */
    private String client;

    /**
     * 创建方式
account = 账号登录
third= 第三方登录 ref=会话刷新
     */
    @Column(name = "create_type")
    private String createType;

    @Column(name = "sec_key")
    private String secKey;

    /**
     * 刷新token 刷新对应的token
     */
    @Column(name = "ref_token")
    private String refToken;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "ip")
    private String ip;

    /**
     * @return session_token
     */
    public String getSessionToken() {
        return sessionToken;
    }

    /**
     * @param sessionToken
     */
    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取过期时间
     *
     * @return exp_time - 过期时间
     */
    public Date getExpTime() {
        return expTime;
    }

    /**
     * 设置过期时间
     *
     * @param expTime 过期时间
     */
    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    /**
     * @return sys_id
     */
    public Integer getSysId() {
        return sysId;
    }

    /**
     * @param sysId
     */
    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    /**
     * 获取客户端信息  移动端、桌面端 填客户端版本号; 后台 填浏览器 agent
     *
     * @return client - 客户端信息  移动端、桌面端 填客户端版本号; 后台 填浏览器 agent
     */
    public String getClient() {
        return client;
    }

    /**
     * 设置客户端信息  移动端、桌面端 填客户端版本号; 后台 填浏览器 agent
     *
     * @param client 客户端信息  移动端、桌面端 填客户端版本号; 后台 填浏览器 agent
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * 获取创建方式
account = 账号登录
third= 第三方登录 ref=会话刷新
     *
     * @return create_type - 创建方式
account = 账号登录
third= 第三方登录 ref=会话刷新
     */
    public String getCreateType() {
        return createType;
    }

    /**
     * 设置创建方式
account = 账号登录
third= 第三方登录 ref=会话刷新
     *
     * @param createType 创建方式
account = 账号登录
third= 第三方登录 ref=会话刷新
     */
    public void setCreateType(String createType) {
        this.createType = createType;
    }

    /**
     * @return sec_key
     */
    public String getSecKey() {
        return secKey;
    }

    /**
     * @param secKey
     */
    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }

    /**
     * 获取刷新token 刷新对应的token
     *
     * @return ref_token - 刷新token 刷新对应的token
     */
    public String getRefToken() {
        return refToken;
    }

    /**
     * 设置刷新token 刷新对应的token
     *
     * @param refToken 刷新token 刷新对应的token
     */
    public void setRefToken(String refToken) {
        this.refToken = refToken;
    }



}