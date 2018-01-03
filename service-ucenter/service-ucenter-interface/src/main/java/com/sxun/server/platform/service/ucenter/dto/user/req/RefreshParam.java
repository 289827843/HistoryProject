package com.sxun.server.platform.service.ucenter.dto.user.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(description = "令牌刷新请求对象")
public class RefreshParam {


    @NotEmpty
    @ApiObjectField(description = "ref_token",required = true)
    private String ref_token;
    @ApiObjectField(description = "sec_key",required = true)
    @NotEmpty
    private String sec_key;


    public String getRef_token() {
        return ref_token;
    }

    public void setRef_token(String ref_token) {
        this.ref_token = ref_token;
    }

    public String getSec_key() {
        return sec_key;
    }

    public void setSec_key(String sec_key) {
        this.sec_key = sec_key;
    }
}
