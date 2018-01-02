package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.*;

/**
 * Created by lz on 2017/12/28.
 */
@ApiObject(description = "用户注册请求对象")
public class RegUserParam {
    @NotEmpty(message = "mobile不能为空")
    @Pattern(regexp = "^[0-9]{11}$",message = "手机号11位数字")
    @ApiObjectField(description = "手机号码 11位",required = true)
    private String mobile;

    @NotEmpty(message = "name不能为空")
    @Size(min = 2,max = 5,message = "name 2-5位")
    @ApiObjectField(description = "姓名 2-5位",required = true)
    private String name;

    @NotEmpty(message = "nickname不能为空")
    @Size(min = 3,max = 10,message = "nickname 3-10位")
    @ApiObjectField(description = "昵称 3-10位",required = true)
    private String nickname;

    @NotNull(message = "sex不能为空")
    @Min(value = 0,message = "0未知 1男 2女")
    @Max(value = 2,message = "0未知 1男 2女")
    @ApiObjectField(description = "性别 0未知 1男 2女",required = true)
    private int sex;

    @NotEmpty(message = "password不能为空")
    @Size(min = 6,max = 30,message = "密码 6-30位")
    @ApiObjectField(description = "密码 6-30位",required = true)
    private String password;

    @NotEmpty(message = "email不能为空")
    @Email(message = "电子邮件 格式xxx@xxx.xxx")
    @ApiObjectField(description = "电子邮件 格式xxx@xxx.xxx",required = true)
    private String email;

    @NotNull(message = "请输入图形验证码")
    @ApiObjectField(description = "图形验证码id",required = true)
    private int img_captcha_id;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImg_captcha_id() {
        return img_captcha_id;
    }

    public void setImg_captcha_id(int img_captcha_id) {
        this.img_captcha_id = img_captcha_id;
    }
}
