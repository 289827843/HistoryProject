package com.sxun.server.platform.service.ucenter.dto.auth.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by leizheng on 12/16/2017.
 */
@ApiObject(description = "登录请求参数")
public class LoginParam {

    @NotEmpty(message = "账号不能为空")
    @ApiObjectField(description = "账号",required=true)
    private String account;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 6,max = 30,message = "密码应该在6-30位之间")
    @ApiObjectField(description = "密码",required=true)
    private String password;

    @NotEmpty(message = "客户端信息不能为空")
    @Size(min = 1,max = 30,message = "客户端信息应该在1-30位之间")
    @ApiObjectField(description = "客户端信息",required=true)
    private String client;

    @NotNull
    @ApiObjectField(description = "验证码流水号",required=true)
    private int authCode_id;


    @NotEmpty(message = "验证码信息不能为空")
    @Size(min = 6,max = 6,message = "验证码信息在6位")
    @ApiObjectField(description = "验证码",required=true)
    private String authCode_name;


    public Integer getSys_id() {
        return sys_id;
    }

    public void setSys_id(Integer sys_id) {
        this.sys_id = sys_id;
    }

    @ApiObjectField(description = "子系统id",required=true)

    private Integer sys_id;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getAuthCode_id() {
        return authCode_id;
    }

    public void setAuthCode_id(int authCode_id) {
        this.authCode_id = authCode_id;
    }

    public String getAuthCode_name() {
        return authCode_name;
    }

    public void setAuthCode_name(String authCode_name) {
        this.authCode_name = authCode_name;
    }
}
