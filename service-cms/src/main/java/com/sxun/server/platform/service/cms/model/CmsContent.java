package com.sxun.server.platform.service.cms.model;

import javax.persistence.*;

@Table(name = "cms_content")
public class CmsContent {
    @Id
    @Column(name = "content_id")
    private Integer contentId;

    /**
     * 排序顺序 从小到大，从1开始
     */
    @Column(name = "seq_no")
    private Integer seqNo;

    /**
     * 段落类型  1= 图文内容（html)  2=1图+1文字（带格式)  3=视频+文字（带格式） 
     */
    @Column(name = "content_type")
    private Integer contentType;

    /**
     * 类型为 2时存储 图片文件id    类型为3时存储 视频文件id
     */
    @Column(name = "file_id")
    private Integer fileId;

    /**
     * 归属文章id
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * HTML内容 
     */
    private String content;

    /**
     * @return content_id
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * @param contentId
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * 获取排序顺序 从小到大，从1开始
     *
     * @return seq_no - 排序顺序 从小到大，从1开始
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     * 设置排序顺序 从小到大，从1开始
     *
     * @param seqNo 排序顺序 从小到大，从1开始
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * 获取段落类型  1= 图文内容（html)  2=1图+1文字（带格式)  3=视频+文字（带格式） 
     *
     * @return content_type - 段落类型  1= 图文内容（html)  2=1图+1文字（带格式)  3=视频+文字（带格式） 
     */
    public Integer getContentType() {
        return contentType;
    }

    /**
     * 设置段落类型  1= 图文内容（html)  2=1图+1文字（带格式)  3=视频+文字（带格式） 
     *
     * @param contentType 段落类型  1= 图文内容（html)  2=1图+1文字（带格式)  3=视频+文字（带格式） 
     */
    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    /**
     * 获取类型为 2时存储 图片文件id    类型为3时存储 视频文件id
     *
     * @return file_id - 类型为 2时存储 图片文件id    类型为3时存储 视频文件id
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 设置类型为 2时存储 图片文件id    类型为3时存储 视频文件id
     *
     * @param fileId 类型为 2时存储 图片文件id    类型为3时存储 视频文件id
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * 获取归属文章id
     *
     * @return article_id - 归属文章id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置归属文章id
     *
     * @param articleId 归属文章id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取HTML内容 
     *
     * @return content - HTML内容 
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置HTML内容 
     *
     * @param content HTML内容 
     */
    public void setContent(String content) {
        this.content = content;
    }
}