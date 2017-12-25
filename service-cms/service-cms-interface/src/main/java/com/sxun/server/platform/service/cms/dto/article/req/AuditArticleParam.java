package com.sxun.server.platform.service.cms.dto.article.req;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.validation.constraints.NotNull;

@ApiObject(description = "文章审核请求对象")
public class AuditArticleParam {
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "操作员ID,具有权限的操作员ID",required=true)
    private int opr_user_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "文章id",required=true)
    private Number article_id;
    @NotNull(message = "不能为空")
    @ApiObjectField(description = "审核结果",required=true)
    private Boolean audit_result;
    @NotEmpty(message = "不能为空")
    @ApiObjectField(description = "审核备注")
    private String audit_memo;

    public Number getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Number article_id) {
        this.article_id = article_id;
    }

    public Boolean getAudit_result() {
        return audit_result;
    }

    public void setAudit_result(Boolean audit_result) {
        this.audit_result = audit_result;
    }

    public String getAudit_memo() {
        return audit_memo;
    }

    public void setAudit_memo(String audit_memo) {
        this.audit_memo = audit_memo;
    }

    public int getOpr_user_id() {
        return opr_user_id;
    }

    public void setOpr_user_id(int opr_user_id) {
        this.opr_user_id = opr_user_id;
    }
}
