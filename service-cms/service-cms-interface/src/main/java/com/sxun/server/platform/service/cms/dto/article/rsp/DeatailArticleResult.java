package com.sxun.server.platform.service.cms.dto.article.rsp;

import com.sxun.server.platform.service.cms.dto.article.req.Content;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.sql.Array;
import java.util.List;

@ApiObject(description = "文章详情结果对象")
public class DeatailArticleResult {
    @ApiObjectField(description = "文章ID")
    private Number article_id;
    @ApiObjectField(description = "文章标题",required=true)
    private String title;
    @ApiObjectField(description = "文章来源",required=true)
    private String source;
    @ApiObjectField(description = "文章作者",required=true)
    private String author;
    @ApiObjectField(description = "文章类型",required=true,allowedvalues ={"0","1","2","3"})
    private String article_type;
    @ApiObjectField(description = "所属目录id",required=true)
    private Number dir_id;
    @ApiObjectField(description = "审核结果")
    private String audit_memo;
    @ApiObjectField(description = "创建时间",required=true)
    private String creatime_time;
    @ApiObjectField(description = "修改时间",required=true)
    private String modify_time;
    @ApiObjectField(description = "文章状态",required=true,allowedvalues ={"0","1","2","3"})
    private Number status;
    @ApiObjectField(description = "拥有者id",required=true)
    private Number own_user_id;
    @ApiObjectField(description = "审核者id-1代表还没有审核人")
    private Number audit_user_id;
    @ApiObjectField(description = "封面图片列表")
    private Array[] cover_list;
    @ApiObjectField(description = "内容列表")
    private List<Content> content_List;


    public Number getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Number article_id) {
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

    public Number getDir_id() {
        return dir_id;
    }

    public void setDir_id(Number dir_id) {
        this.dir_id = dir_id;
    }

    public String getAudit_memo() {
        return audit_memo;
    }

    public void setAudit_memo(String audit_memo) {
        this.audit_memo = audit_memo;
    }

    public String getCreatime_time() {
        return creatime_time;
    }

    public void setCreatime_time(String creatime_time) {
        this.creatime_time = creatime_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public Number getStatus() {
        return status;
    }

    public void setStatus(Number status) {
        this.status = status;
    }

    public Number getOwn_user_id() {
        return own_user_id;
    }

    public void setOwn_user_id(Number own_user_id) {
        this.own_user_id = own_user_id;
    }

    public Number getAudit_user_id() {
        return audit_user_id;
    }

    public void setAudit_user_id(Number audit_user_id) {
        this.audit_user_id = audit_user_id;
    }

    public Array[] getCover_list() {
        return cover_list;
    }

    public void setCover_list(Array[] cover_list) {
        this.cover_list = cover_list;
    }

    public List<Content> getContent_List() {
        return content_List;
    }

    public void setContent_List(List<Content> content_List) {
        this.content_List = content_List;
    }
}
