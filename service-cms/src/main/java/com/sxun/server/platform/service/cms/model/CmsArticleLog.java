package com.sxun.server.platform.service.cms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cms_article_log")
public class CmsArticleLog {
    @Id
    @Column(name = "article_log_id")
    private Integer articleLogId;

    /**
     * 操作者id
     */
    @Column(name = "opr_user_id")
    private Integer oprUserId;

    /**
     * 操作内容 中文，需要描述 操作了什么
     */
    @Column(name = "opr_content")
    private String oprContent;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 操作的文章id
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * @return article_log_id
     */
    public Integer getArticleLogId() {
        return articleLogId;
    }

    /**
     * @param articleLogId
     */
    public void setArticleLogId(Integer articleLogId) {
        this.articleLogId = articleLogId;
    }

    /**
     * 获取操作者id
     *
     * @return opr_user_id - 操作者id
     */
    public Integer getOprUserId() {
        return oprUserId;
    }

    /**
     * 设置操作者id
     *
     * @param oprUserId 操作者id
     */
    public void setOprUserId(Integer oprUserId) {
        this.oprUserId = oprUserId;
    }

    /**
     * 获取操作内容 中文，需要描述 操作了什么
     *
     * @return opr_content - 操作内容 中文，需要描述 操作了什么
     */
    public String getOprContent() {
        return oprContent;
    }

    /**
     * 设置操作内容 中文，需要描述 操作了什么
     *
     * @param oprContent 操作内容 中文，需要描述 操作了什么
     */
    public void setOprContent(String oprContent) {
        this.oprContent = oprContent;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取操作的文章id
     *
     * @return article_id - 操作的文章id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置操作的文章id
     *
     * @param articleId 操作的文章id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}