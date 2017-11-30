package com.sxun.server.platform.service.cms.dto.article.req;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "cover")
public class Cover {
    @Column(name = "file_id")
    private Integer file_id;

    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }
}
