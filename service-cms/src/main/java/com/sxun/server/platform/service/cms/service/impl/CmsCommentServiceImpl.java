package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.cms.dao.CmsCommentMapper;
import com.sxun.server.platform.service.cms.dto.comment.rsp.ListCommentResult;
import com.sxun.server.platform.service.cms.model.CmsComment;
import com.sxun.server.platform.service.cms.service.CmsCommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class CmsCommentServiceImpl extends AbstractService<CmsComment> implements CmsCommentService {
    @Resource
    private CmsCommentMapper cmsCommentMapper;
    @Override
    public int saveComment(CmsComment cmsComment) {
        int row=-1;
        if(cmsComment!=null) {
             row=cmsCommentMapper.insertComment(cmsComment);
        }
        if(row>0){
            int commentId=cmsCommentMapper.findCommentId(cmsComment);
            return commentId;
        }else {
            return 0;
        }
    }

    @Override
    public int updateComment(CmsComment cmsComment) {
         int row=-1;
        if(cmsComment!=null){
            row=cmsCommentMapper.updateComment(cmsComment);

        }
        if(row>0){
            return 1;
        }else{
            return 0;
        }

    }

    @Override
    public int delComment(int comment_id) {
        int row=-1;
        if(comment_id>0){
            row=cmsCommentMapper.deleteComment(comment_id);

        }
        if(row>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<ListCommentResult> findComments(int article_id,int is_display, int is_del, String columnName) {
        List<ListCommentResult> listCommentResults=cmsCommentMapper.listComment(article_id,is_display,is_del,columnName);
        if(listCommentResults!=null){
            return  listCommentResults;
        }else {
            return null;
        }
    }
}
