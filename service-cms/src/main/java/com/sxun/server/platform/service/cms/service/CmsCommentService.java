package com.sxun.server.platform.service.cms.service;

import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.cms.dto.comment.rsp.ListCommentResult;
import com.sxun.server.platform.service.cms.model.CmsComment;



import java.util.List;

public interface CmsCommentService extends Service<CmsComment> {
    int saveComment(CmsComment cmsComment);
    int updateComment(CmsComment cmsComment);
    int delComment(int comment_id);
    List<ListCommentResult> findComments(int article_id, int is_display,int is_del, String columnName);
}
