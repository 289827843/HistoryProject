package com.sxun.server.platform.service.cms.dto.comment.rsp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cms_reply")
public class CmsReply {
    @Id
    @Column(name = "reply_id")
    private Integer replyId;
    @Column(name = "content")
    private String content;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "modify_time")
    private Date modifyTime;
    @Column(name = "comment_id")
    private Integer commentId;
    @Column(name = "reply_user_id")
    private Integer replyUserId;
    @Column(name = "is_display")
    private Boolean isDisplay;
    @Column(name = "is_del")
    private Boolean isDel ;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Boolean getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel =isDel ;
    }
}
