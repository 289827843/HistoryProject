package com.sxun.server.platform.service.ucenter.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ucenter_session_ref_token")
public class UcenterSessionRefToken {
    @Id
    @Column(name = "ref_token")
    private String refToken;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "exp_time")
    private Date expTime;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "sys_id")
    private Integer sysId;

    @Column(name = "sec_key")
    private String secKey;

    @Column(name = "state")
    private int state;


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    /**
     * @return ref_token
     */
    public String getRefToken() {
        return refToken;
    }

    /**
     * @param refToken
     */
    public void setRefToken(String refToken) {
        this.refToken = refToken;
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
     * @return exp_time
     */
    public Date getExpTime() {
        return expTime;
    }

    /**
     * @param expTime
     */
    public void setExpTime(Date expTime) {
        this.expTime = expTime;
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
}