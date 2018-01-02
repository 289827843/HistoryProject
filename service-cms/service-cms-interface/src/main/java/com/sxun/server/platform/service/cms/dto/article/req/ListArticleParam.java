package com.sxun.server.platform.service.cms.dto.article.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "文章查询请求对象")
public class ListArticleParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "当前页",required=true)
    private Integer current_page;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "每页记录数",required=true)
    private Integer page_size;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "所属目录id",required=true)
    private Integer dir_id;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "文章标题",required=true)
    private String title;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "文章来源",required=true)
    private String source;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "文章作者",required=true)
    private String author;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "文章类型",required=true,allowedvalues ={"0","1","2","3"})
    private String article_type;

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

    public Integer getDir_id() {
        return dir_id;
    }

    public void setDir_id(Integer dir_id) {
        this.dir_id = dir_id;
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
}
