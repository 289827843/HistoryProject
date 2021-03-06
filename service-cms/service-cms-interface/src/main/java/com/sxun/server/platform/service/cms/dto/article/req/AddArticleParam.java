package com.sxun.server.platform.service.cms.dto.article.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.web.servlet.resource.ContentVersionStrategy;

import javax.validation.constraints.NotNull;
import java.sql.Array;
import java.util.List;

@ApiObject(description = "创建文章请求对象")
public class AddArticleParam {

    @NotNull(message = "不能为空")
    @ApiObjectField(description = "操作员ID,具有权限的操作员ID",required=true)
    private int opr_user_id;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "文章标题",required=true)
    private String title;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "文章来源",required=true)
    private String source;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "文章作者",required=true)
    private String author;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "文章类型",required=true,allowedvalues ={"0","1","2","3"})
    private String article_type;
    @NotNull(message = "不能为空")
     @ApiObjectField(description = "所属目录id",required=true)
    private Integer dir_id;
    @ApiObjectField(description = "封面图片列表")
    private List<Cover> cover_list;

    @ApiObjectField(description = "内容列表")
    private List<Content> content_List;


    public int getOpr_user_id() {
        return opr_user_id;
    }

    public void setOpr_user_id(int opr_user_id) {
        this.opr_user_id = opr_user_id;
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

    public List<Cover> getCover_list() {
        return cover_list;
    }

    public void setCover_list(List<Cover> cover_list) {
        this.cover_list = cover_list;
    }

    public List<Content> getContent_List() {
        return content_List;
    }

    public void setContent_List(List<Content> content_List) {
        this.content_List = content_List;
    }
}
