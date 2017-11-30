package com.sxun.server.platform.service.cms.dto.article.req;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "content")
public class Content {

    @Column(name = "seq_no")
    private Integer seq_no;


    @Column(name = "content_type")
    private Integer content_type;


    @Column(name = "file_id")
    private Integer file_id;

    @Column(name = "content")
    private String content;


    public Integer getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(Integer seq_no) {
        this.seq_no = seq_no;
    }

    public Integer getContent_type() {
        return content_type;
    }

    public void setContent_type(Integer content_type) {
        this.content_type = content_type;
    }

    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}