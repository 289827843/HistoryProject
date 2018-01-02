package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.dto.comment.rsp.ListCommentResult;
import com.sxun.server.platform.service.cms.model.CmsComment;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface CmsCommentMapper extends Mapper<CmsComment> {
    int insertComment(CmsComment cmsComment);
    int findCommentId(CmsComment cmsComment);
    int updateComment(CmsComment cmsComment);
    int deleteComment(@Param("comment_id") Integer comment_id);
    List<ListCommentResult> listComment(Map<String,Object> map) ;
}
