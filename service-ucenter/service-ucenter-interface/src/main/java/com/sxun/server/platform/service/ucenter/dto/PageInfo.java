package com.sxun.server.platform.service.ucenter.dto;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leizheng on 12/14/2017.
 */
@ApiObject(description = "分页对象")
public class PageInfo<T>  {
    @ApiObjectField(description = "页面数据")
    private List<T> list;
    @ApiObjectField(description = "当前页面")
    private int current_page;
    @ApiObjectField(description = "页面尺寸")
    private int page_size;
    @ApiObjectField(description = "总记录数")
    private int total_count;
    @ApiObjectField(description = "总页数")
    private int total_page;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }
}
