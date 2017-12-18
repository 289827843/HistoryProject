package com.sxun.server.platform.service.cms.model;

import javax.persistence.*;

@Table(name = "cms_catagory")
public class CmsCatagory {
    @Id
    @Column(name = "cata_id")
    private Integer cataId;

    private String name;

    /**
     * @return cata_id
     */
    public Integer getCataId() {
        return cataId;
    }

    /**
     * @param cataId
     */
    public void setCataId(Integer cataId) {
        this.cataId = cataId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}