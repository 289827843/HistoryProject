package com.sxun.server.platform.service.cms.web;


import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.platform.service.cms.dto.reply.req.AddReplyParam;
import com.sxun.server.platform.service.cms.dto.reply.req.DelReplyParam;
import com.sxun.server.platform.service.cms.dto.reply.req.UpdateReplyParam;
import com.sxun.server.platform.service.cms.dto.reply.rsp.AddReplyResult;
import com.sxun.server.platform.service.cms.itf.IReplyController;
import com.sxun.server.platform.service.cms.model.CmsReply;
import com.sxun.server.platform.service.cms.service.CmsArticleService;
import com.sxun.server.platform.service.cms.service.CmsReplyService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@Api(name = "回复管理", description = "内容管理相关服务", group = "cms")
@RestController
@RequestMapping("/reply")
public class ReplyController implements IReplyController{
    @Autowired
    private CmsReplyService cmsReplyService;

    @ApiMethod(description = "添加回复")
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject
    Result<AddReplyResult> addReply(@ApiBodyObject @RequestBody @Valid AddReplyParam param) {
        CmsReply cmsReply=new CmsReply();
        cmsReply.setReplyUserId(param.getReply_user_id());
        cmsReply.setCommentId(param.getComment_id());
        cmsReply.setContent(param.getComment());
        int replyId=cmsReplyService.saveReply(cmsReply);
        if(replyId>0){

                AddReplyResult addReplyResult=new AddReplyResult();
                addReplyResult.setReply_id(replyId);
                return ResultGenerator.genSuccessResult(addReplyResult);
            }else {
                return ResultGenerator.genFailResult("回复添加失败");
            }

    }
    @ApiMethod(description = "修改回复")
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result updateReply(@ApiBodyObject @RequestBody @Valid UpdateReplyParam param) {
        CmsReply cmsReply=new CmsReply();
        cmsReply.setReplyId(param.getReply_id());
        cmsReply.setContent(param.getConment());
        cmsReply.setIsDisplay(param.getIs_display());
        Date date=new Date();
       cmsReply.setModifyTime(date);
        cmsReply.setIsDel(false);
        int row=cmsReplyService.updateReply(cmsReply);
        if(row>0){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("修改回复失败");
        }
    }
    @ApiMethod(description = "删除回复")
    @RequestMapping(path = "/del", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result delReply(@ApiBodyObject @RequestBody @Valid DelReplyParam param) {
        int row=cmsReplyService.delReply(param.getReply_id());
        if(row>0){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("删除回复失败");
        }
    }
}
