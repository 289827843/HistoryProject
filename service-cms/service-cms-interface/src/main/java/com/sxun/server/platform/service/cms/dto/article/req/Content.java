package com.sxun.server.platform.service.cms.dto.article.req;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "content")
public class Content {

    @Column(name = "seq_no")
    private Integer seqNo;


    @Column(name = "content_type")
    private Integer contentType;


    @Column(name = "file_id")
    private Integer fileId;


    /**
     * HTML内容 
     */
    private String content;


    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}