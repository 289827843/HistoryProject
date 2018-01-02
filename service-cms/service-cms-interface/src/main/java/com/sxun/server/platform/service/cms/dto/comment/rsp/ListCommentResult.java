package com.sxun.server.platform.service.cms.dto.comment.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.util.List;

@ApiObject(description = "文章查询评论结果对象")
public class ListCommentResult {
    @ApiObjectField(description = "评论id",required=true)
    private Integer commentId;
    @ApiObjectField(description = "文章id",required=true)
    private Integer articleId;
    @ApiObjectField(description = "评论人id",required=true)
    private Integer commentUserId;
    @ApiObjectField(description = "评论人昵称",required=true)
    private String nickname;
    @ApiObjectField(description = "评论人头像id",required=true)
    private Integer avatarImgId;
    @ApiObjectField(description = "评论内容",required=true)
    private String content;
    @ApiObjectField(description = "是否显示",required=true)
    private Boolean isDisplay;
    @ApiObjectField(description = "是否删除",required=true)
    private Boolean isDel;
    @ApiObjectField(description = "创建时间",required=true)
    private String createTime;
    @ApiObjectField(description = "修改时间",required=true)
    private String modifyTime;
    @ApiObjectField(description = "回复信息",required=true)
    private List<CmsReply> reply_list;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAvatarImgId() {
        return avatarImgId;
    }

    public void setAvatarImgId(Integer avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDisplay() {
        return isDisplay;
    }

    public void setDisplay(Boolean display) {
        isDisplay = display;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<CmsReply> getReply_list() {
        return reply_list;
    }

    public void setReply_list(List<CmsReply> reply_list) {
        this.reply_list = reply_list;
    }
}
