package com.sxun.server.platform.service.cms.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cms_comment")
public class CmsComment {
    @Id
    @Column(name = "comment_id")
    private Integer commentId;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "modify_time")
    private Date modifyTime;
    @Column(name = "conent")
    private String content;
    @Column(name = "comment_user_id")
    private Integer commentUserId;
    @Column(name = "is_display")
    private Boolean isDisplay;
    @Column(name = "article_id")
    private Integer articleId;
    @Column(name = "is_del")
    private Boolean isDel;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public Boolean getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel =isDel ;
    }
}