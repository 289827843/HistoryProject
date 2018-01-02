package com.sxun.server.platform.service.cms.dto.article.rsp;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.sql.Array;

@ApiObject(description = "文章查询结果对象")
public class ListArticleResult {
    @ApiObjectField(description = "当前页",required=true)
    private Integer current_page;
    @ApiObjectField(description = "每页记录数",required=true)
    private Integer page_size;
    @ApiObjectField(description = "总页数",required=true)
    private Integer total_page;
    @ApiObjectField(description = "总记录数",required=true)
    private Integer tatal_count;
    @ApiObjectField(description = "文章id",required=true)
    private Integer article_id;
    @ApiObjectField(description = "文章标题",required=true)
    private String title;
    @ApiObjectField(description = "文章来源",required=true)
    private String source;
    @ApiObjectField(description = "文章作者",required=true)
    private String author;
    @ApiObjectField(description = "文章类型",required=true)
    private String article_type;
    @ApiObjectField(description = "所属目录id",required=true)
    private Integer dir_id;
    @ApiObjectField(description = "审核结果")
    private String audit_meno;
    @ApiObjectField(description = "创建时间",required=true)
    private String create_time;
    @ApiObjectField(description = "修改时间",required=true)
    private String modify_time;
    @ApiObjectField(description = "文章状态",required=true,allowedvalues ={"0","1","2","3"})
    private Integer staus;
    @ApiObjectField(description = "拥有者id",required=true)
    private Integer own_user_id;
    @ApiObjectField(description = "审核者id，-1代表还没有审核人")
    private Integer audit_user_id;
    @ApiObjectField(description = "封面图片列表")
    private Array[] cover_list;
    @ApiObjectField(description = "图片id",required=true)
    private Integer file_id;

    public Integer getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(Integer current_page) {
        this.current_page = current_page;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Integer getTotal_page() {
        return total_page;
    }

    public void setTotal_page(Integer total_page) {
        this.total_page = total_page;
    }

    public Integer getTatal_count() {
        return tatal_count;
    }

    public void setTatal_count(Integer tatal_count) {
        this.tatal_count = tatal_count;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public Integer getDir_id() {
        return dir_id;
    }

    public void setDir_id(Integer dir_id) {
        this.dir_id = dir_id;
    }

    public String getAudit_meno() {
        return audit_meno;
    }

    public void setAudit_meno(String audit_meno) {
        this.audit_meno = audit_meno;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public Integer getStaus() {
        return staus;
    }

    public void setStaus(Integer staus) {
        this.staus = staus;
    }

    public Integer getOwn_user_id() {
        return own_user_id;
    }

    public void setOwn_user_id(Integer own_user_id) {
        this.own_user_id = own_user_id;
    }

    public Integer getAudit_user_id() {
        return audit_user_id;
    }

    public void setAudit_user_id(Integer audit_user_id) {
        this.audit_user_id = audit_user_id;
    }


    public Array[] getCover_list() {
        return cover_list;
    }

    public void setCover_list(Array[] cover_list) {
        this.cover_list = cover_list;
    }

    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }
}
