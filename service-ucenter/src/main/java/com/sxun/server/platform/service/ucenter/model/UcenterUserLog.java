package com.sxun.server.platform.service.ucenter.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ucenter_user_log")
public class UcenterUserLog {
    @Id
    @Column(name = "user_log_id")
    private Integer userLogId;

    /**
     * 操作人id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 操作api url
     */
    @Column(name = "action_api_url")
    private String actionApiUrl;

    /**
     * 详细操作内容
     */
    @Column(name = "action_content")
    private String actionContent;


    @Column(name = "opr_userid")
    private int oprUserId;


    /**
     * 发生时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 操作ip
     */
    private String ip;

    /**
     * @return user_log_id
     */
    public Integer getUserLogId() {
        return userLogId;
    }

    /**
     * @param userLogId
     */
    public void setUserLogId(Integer userLogId) {
        this.userLogId = userLogId;
    }

    /**
     * 获取操作人id
     *
     * @return user_id - 操作人id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置操作人id
     *
     * @param userId 操作人id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取操作api url
     *
     * @return action_api_url - 操作api url
     */
    public String getActionApiUrl() {
        return actionApiUrl;
    }

    /**
     * 设置操作api url
     *
     * @param actionApiUrl 操作api url
     */
    public void setActionApiUrl(String actionApiUrl) {
        this.actionApiUrl = actionApiUrl;
    }

    /**
     * 获取详细操作内容
     *
     * @return action_content - 详细操作内容
     */
    public String getActionContent() {
        return actionContent;
    }

    /**
     * 设置详细操作内容
     *
     * @param actionContent 详细操作内容
     */
    public void setActionContent(String actionContent) {
        this.actionContent = actionContent;
    }

    /**
     * 获取发生时间
     *
     * @return create_time - 发生时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发生时间
     *
     * @param createTime 发生时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取操作ip
     *
     * @return ip - 操作ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置操作ip
     *
     * @param ip 操作ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }




    public int getOprUserId() {
        return oprUserId;
    }

    public void setOprUserId(int oprUserId) {
        this.oprUserId = oprUserId;
    }


}