package com.sxun.server.platform.service.ucenter.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ucenter_user_auth")
public class UcenterUserAuth {
    @Id
    @Column(name = "user_auth_id")
    private Integer userAuthId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 认证方式id
     */
    @Column(name = "auth_type_id")
    private Integer authTypeId;

    /**
     * 第三方id
     */
    @Column(name = "open_id")
    private Integer openId;

    /**
     * 绑定状态 0 解绑 1绑定
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * @return user_auth_id
     */
    public Integer getUserAuthId() {
        return userAuthId;
    }

    /**
     * @param userAuthId
     */
    public void setUserAuthId(Integer userAuthId) {
        this.userAuthId = userAuthId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取认证方式id
     *
     * @return auth_type_id - 认证方式id
     */
    public Integer getAuthTypeId() {
        return authTypeId;
    }

    /**
     * 设置认证方式id
     *
     * @param authTypeId 认证方式id
     */
    public void setAuthTypeId(Integer authTypeId) {
        this.authTypeId = authTypeId;
    }

    /**
     * 获取第三方id
     *
     * @return open_id - 第三方id
     */
    public Integer getOpenId() {
        return openId;
    }

    /**
     * 设置第三方id
     *
     * @param openId 第三方id
     */
    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    /**
     * 获取绑定状态 0 解绑 1绑定
     *
     * @return status - 绑定状态 0 解绑 1绑定
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置绑定状态 0 解绑 1绑定
     *
     * @param status 绑定状态 0 解绑 1绑定
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后更新时间
     *
     * @return modify_time - 最后更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param modifyTime 最后更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}