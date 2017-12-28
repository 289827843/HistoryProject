package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.*;

/**
 * Created by leizheng on 12/10/2017.
 */
@ApiObject(description = "更新用户请求对象")
public class UpdateUserParam {
    @ApiObjectField(description = "操作员ID,自己更新则是自身userid",required=true)
    @NotNull(message = "不能为空")
    @Pattern(regexp = "^[0-9]*$",message = "格式输入错误，注意数字类型")
    private Integer opr_user_id;
    @ApiObjectField(description = "需要更新的用户id",required=true)
    @NotNull(message = "不能为空")
    @Pattern(regexp = "^[0-9]*$",message = "格式输入错误，注意数字类型")
    private Integer user_id;
    @Size(min = 2,max = 5,message = "姓名,最小2位，最大5位")
    @ApiObjectField(description = "姓名,最小2位，最大5位")
    @NotNull(message = "name不能为空")
    private String name;
    @Size(min = 3 ,max = 10 ,message = "昵称,最小3位，最大10位")
    @NotNull(message = "nickname不能为空")
    @ApiObjectField(description = "昵称,最小3位，最大10位")
    private String nickname;
    @NotNull(message = "sex不能为空")
    @ApiObjectField(description = "性别 0=未知 1=男 2=女 ",allowedvalues ={"0","1","2"})
    @Pattern(regexp = "^[0-2]*$",message = "格式输入错误，注意数字类型")
    private Integer sex;
    @NotNull(message = "mobile不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_+-]{11,12}$" ,message = "电话号码11位 数字 “+” “-”")
    @ApiObjectField(description = "电话号码 11位")
    private String mobile;
    @Email(message = "电子邮箱 格式 111@xx.xx")
    @NotNull(message = "email不能为空")
    @ApiObjectField(description = "电子邮箱 格式 111@xx.xx")
    private String email;

    public int getOpr_user_id() {
        return opr_user_id;
    }

    public void setOpr_user_id(int opr_user_id) {
        this.opr_user_id = opr_user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
