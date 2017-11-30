package com.sxun.server.platform.service.cms.service;

import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.cms.dto.comment.rsp.ListCommentResult;
import com.sxun.server.platform.service.cms.model.CmsReply;

import java.util.List;

public interface CmsReplyService extends Service<CmsReply> {
    int saveReply(CmsReply cmsReply);
    int updateReply(CmsReply cmsReply);
    int delReply(int reply_id);

}
