package com.sxun.server.platform.service.ucenter.model;

import javax.persistence.*;

@Table(name = "ucenter_auth_type")
public class UcenterAuthType {
    @Id
    @Column(name = "auth_type_id")
    private Integer authTypeId;

    /**
     * 认证方式名称
     */
    private String name;

    /**
     * @return auth_type_id
     */
    public Integer getAuthTypeId() {
        return authTypeId;
    }

    /**
     * @param authTypeId
     */
    public void setAuthTypeId(Integer authTypeId) {
        this.authTypeId = authTypeId;
    }

    /**
     * 获取认证方式名称
     *
     * @return name - 认证方式名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置认证方式名称
     *
     * @param name 认证方式名称
     */
    public void setName(String name) {
        this.name = name;
    }
}