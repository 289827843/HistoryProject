package com.sxun.server.platform.service.ucenter.model;

import javax.persistence.*;

/**
 * Created by lz on 2017/12/22.
 */
@Table(name = "ucenter_sys")
public class UcenterSys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Integer sysId;
    @Column(name = "name")
    private String name;
    @Column(name = "desc")
    private String desc;

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
