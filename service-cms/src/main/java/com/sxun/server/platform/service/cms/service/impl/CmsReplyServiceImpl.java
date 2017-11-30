package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.cms.dao.CmsReplyMapper;
import com.sxun.server.platform.service.cms.model.CmsReply;
import com.sxun.server.platform.service.cms.service.CmsReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
@Transactional
public class CmsReplyServiceImpl extends AbstractService<CmsReply> implements CmsReplyService{
    @Resource
    private CmsReplyMapper cmsReplyMapper;
    @Override
    public int saveReply(CmsReply cmsReply) {
        int row=-1;
        if(cmsReply!=null){
            row=cmsReplyMapper.insertReply(cmsReply);
        }
        if(row>0){
            int replyId=cmsReplyMapper.findReplyId(cmsReply);
            return replyId;
        }else {
            return 0;
        }
    }

    @Override
    public int updateReply(CmsReply cmsReply) {
        int row=-1;
        if(cmsReply!=null){
            row=cmsReplyMapper.updateReply(cmsReply);
        }
        if(row>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int delReply(int reply_id) {
        int row=-1;
        if(reply_id>0){
            row=cmsReplyMapper.deleteReply(reply_id);
        }
        if(row>0){
            return 1;
        }else {
            return 0;
        }
    }
}
