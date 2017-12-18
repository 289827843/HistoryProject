package com.sxun.server.platform.service.cms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cms_article")
public class CmsArticle {
    @Id
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 标题
     */
    private String title;

    /**
     * 来源
     */
    private String source;

    /**
     * 作者 名称
     */
    private String author;

    /**
     * 状态 0=草稿 1=待审核  2=已发布 3=下架
     */
    private Integer status;

    /**
     * 类型  0=普通文章 1=图集 2=视频 3=PDF
     */
    @Column(name = "article_type")
    private Integer articleType;

    /**
     * 创作者id
     */
    @Column(name = "own_user_id")
    private Integer ownUserId;

    /**
     * 审核者id
     */
    @Column(name = "audit_user_id")
    private Integer auditUserId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 归属目录id
     */
    @Column(name = "dir_id")
    private Integer dirId;

    /**
     * @return article_id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取来源
     *
     * @return source - 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源
     *
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取作者 名称
     *
     * @return author - 作者 名称
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者 名称
     *
     * @param author 作者 名称
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取状态 0=草稿 1=待审核  2=已发布 3=下架
     *
     * @return status - 状态 0=草稿 1=待审核  2=已发布 3=下架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0=草稿 1=待审核  2=已发布 3=下架
     *
     * @param status 状态 0=草稿 1=待审核  2=已发布 3=下架
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取类型  0=普通文章 1=图集 2=视频 3=PDF
     *
     * @return article_type - 类型  0=普通文章 1=图集 2=视频 3=PDF
     */
    public Integer getArticleType() {
        return articleType;
    }

    /**
     * 设置类型  0=普通文章 1=图集 2=视频 3=PDF
     *
     * @param articleType 类型  0=普通文章 1=图集 2=视频 3=PDF
     */
    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    /**
     * 获取创作者id
     *
     * @return own_user_id - 创作者id
     */
    public Integer getOwnUserId() {
        return ownUserId;
    }

    /**
     * 设置创作者id
     *
     * @param ownUserId 创作者id
     */
    public void setOwnUserId(Integer ownUserId) {
        this.ownUserId = ownUserId;
    }

    /**
     * 获取审核者id
     *
     * @return audit_user_id - 审核者id
     */
    public Integer getAuditUserId() {
        return auditUserId;
    }

    /**
     * 设置审核者id
     *
     * @param auditUserId 审核者id
     */
    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取归属目录id
     *
     * @return dir_id - 归属目录id
     */
    public Integer getDirId() {
        return dirId;
    }

    /**
     * 设置归属目录id
     *
     * @param dirId 归属目录id
     */
    public void setDirId(Integer dirId) {
        this.dirId = dirId;
    }
}