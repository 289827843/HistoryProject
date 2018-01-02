package com.sxun.server.platform.service.cms.service;

import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.cms.dto.comment.rsp.ListCommentResult;
import com.sxun.server.platform.service.cms.model.CmsComment;



import java.util.List;
import java.util.Map;

public interface CmsCommentService extends Service<CmsComment> {
    int saveComment(CmsComment cmsComment);
    int updateComment(CmsComment cmsComment);
    int delComment(int comment_id);
    List<ListCommentResult> findComments(Map<String,Object> map);
}
