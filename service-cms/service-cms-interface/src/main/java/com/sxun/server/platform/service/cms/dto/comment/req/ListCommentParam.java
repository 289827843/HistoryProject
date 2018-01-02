package com.sxun.server.platform.service.cms.dto.comment.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "文章评论查询请求对象")
public class ListCommentParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "文章id",required=true)
    private Integer article_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "是否显示",required=true)
    private Integer is_display;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "是否删除",required=true)
    private Integer is_del;
    @ApiObjectField(description = "排序字段",required=true)
    private String[] order_field;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getIs_display() {
        return is_display;
    }

    public void setIs_display(Integer is_display) {
        this.is_display = is_display;
    }

    public Integer getIs_del() {
        return is_del;
    }

    public void setIs_del(Integer is_del) {
        this.is_del = is_del;
    }

    public String[] getOrder_field() {
        return order_field;
    }

    public void setOrder_field(String[] order_field) {
        this.order_field = order_field;
    }
}
