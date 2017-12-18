package com.sxun.server.platform.service.cms.model;

import javax.persistence.*;

@Table(name = "cms_cover")
public class CmsCover {
    @Id
    @Column(name = "cover_id")
    private Integer coverId;

    @Column(name = "acticle_id")
    private Integer acticleId;

    /**
     * 文件ID
     */
    @Column(name = "file_id")
    private Integer fileId;

    /**
     * @return cover_id
     */
    public Integer getCoverId() {
        return coverId;
    }

    /**
     * @param coverId
     */
    public void setCoverId(Integer coverId) {
        this.coverId = coverId;
    }

    /**
     * @return acticle_id
     */
    public Integer getActicleId() {
        return acticleId;
    }

    /**
     * @param acticleId
     */
    public void setActicleId(Integer acticleId) {
        this.acticleId = acticleId;
    }

    /**
     * 获取文件ID
     *
     * @return file_id - 文件ID
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 设置文件ID
     *
     * @param fileId 文件ID
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
}