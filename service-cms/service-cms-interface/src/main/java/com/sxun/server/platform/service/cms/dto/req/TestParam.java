package com.sxun.server.platform.service.cms.dto.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by leizheng on 12/17/2017.
 */
@ApiObject(description = "测试接口参数")
public class TestParam {
    @NotEmpty(message = "testField1不能为空")
    @Size(min = 6,max = 30,message = "testField1应该在6-30位之间")
    @ApiObjectField(description = "测试参数1",required=true)
    private String testField1;

    @NotNull(message = "testField2不能为空")
    @ApiObjectField(description = "测试参数2",required=true)
    private Integer testField2;

    public String getTestField1() {
        return testField1;
    }

    public void setTestField1(String testField1) {
        this.testField1 = testField1;
    }

    public Integer getTestField2() {
        return testField2;
    }

    public void setTestField2(Integer testField2) {
        this.testField2 = testField2;
    }
}
