package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.model.CmsReply;
import org.springframework.data.repository.query.Param;

public interface CmsReplyMapper extends Mapper<CmsReply> {
    int insertReply(CmsReply cmsReply);
    int findReplyId(CmsReply cmsReply);
    int updateReply(CmsReply cmsReply);
    int deleteReply(@Param("reply_id") Integer reply_id);
}
