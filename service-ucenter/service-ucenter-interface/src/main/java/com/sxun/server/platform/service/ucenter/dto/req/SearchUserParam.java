package com.sxun.server.platform.service.ucenter.dto.req;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "查询用户请求")
public class SearchUserParam {

    @ApiObjectField(description = "当前页，从0开始",required=true)
    private int current_page;
    @ApiObjectField(description =  "每页记录数",required=true)
    private int page_size;
    @ApiObjectField(description =  "账号")
    private String account;
    @ApiObjectField(description =  "姓名")
    private String name;
    @ApiObjectField(description =  "昵称")
    private String nickname;
    @ApiObjectField(description =  "状态")
    private int status;
    @ApiObjectField(description =  "手机号码")
    private String mobile;
    @ApiObjectField(description =  "电子邮箱")
    private String email;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
