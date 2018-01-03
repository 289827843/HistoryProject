package com.sxun.server.platform.service.cms.web;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.platform.service.cms.api.UserFeignService;
import com.sxun.server.platform.service.cms.dto.comment.req.AddCommentParam;
import com.sxun.server.platform.service.cms.dto.comment.req.DelCommentParam;
import com.sxun.server.platform.service.cms.dto.comment.req.ListCommentParam;
import com.sxun.server.platform.service.cms.dto.comment.req.UpdateCommentParam;
import com.sxun.server.platform.service.cms.dto.comment.rsp.AddCommentResult;
import com.sxun.server.platform.service.cms.dto.comment.rsp.ListCommentResult;
import com.sxun.server.platform.service.cms.itf.ICommentController;
import com.sxun.server.platform.service.cms.model.CmsComment;
import com.sxun.server.platform.service.cms.service.CmsCommentService;
import com.sxun.server.platform.service.ucenter.dto.user.req.SearchMutilUserParam;
import com.sxun.server.platform.service.ucenter.dto.user.rsp.UserDetail;
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
import java.util.*;

@Api(name = "评论管理", description = "内容管理相关服务", group = "cms")
@RestController
@RequestMapping("/comment")
public class CommentController implements ICommentController {
    @Autowired
    private CmsCommentService cmsCommentService;
    @Autowired
    private UserFeignService userFeignService;

    @ApiMethod(description = "添加评论")
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject
    Result<AddCommentResult> addComment(@ApiBodyObject @RequestBody @Valid AddCommentParam param) {
        CmsComment cmsComment=new CmsComment();
        cmsComment.setCommentUserId(param.getComment_user_id());
        cmsComment.setContent(param.getContent());
        cmsComment.setArticleId(param.getArticle_id());
        int commentId=cmsCommentService.saveComment(cmsComment);
        if(commentId>0){
            AddCommentResult addCommentResult=new AddCommentResult();
            addCommentResult.setComment_id(commentId);
            return ResultGenerator.genSuccessResult(addCommentResult);
        }else {
            return ResultGenerator.genFailResult("添加评论失败");
        }
    }
    @ApiMethod(description = "修改评论")
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result updateComment(@ApiBodyObject @RequestBody @Valid UpdateCommentParam param) {
        CmsComment cmsComment=new CmsComment();
        cmsComment.setCommentId(param.getComment_id());
        cmsComment.setContent(param.getContent());
        cmsComment.setIsDisplay(param.getIs_display());
        Date date=new Date();
        cmsComment.setModifyTime(date);
        cmsComment.setIsDel(false);
        int row=cmsCommentService.updateComment(cmsComment);
        if(row>0){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("修改评论失败");
        }
    }
    @ApiMethod(description = "删除评论")
    @RequestMapping(path = "/del", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result delComment(@ApiBodyObject @RequestBody @Valid DelCommentParam param) {
         int row=cmsCommentService.delComment(param.getComment_id());
        if(row>0){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("删除评论失败");
        }
    }
    @ApiMethod(description = "评论查询")
    @RequestMapping(path = "/list", method = RequestMethod.POST)
    @Override
    public   @ApiResponseObject Result listComment(@ApiBodyObject @RequestBody @Valid ListCommentParam param) {
        String columnName=null;
        if(param.getOrder_field()!=null) {
            String[] columnNames = param.getOrder_field();
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<columnNames.length;i++){
                stringBuilder.append(columnNames[i]).append(",");
            }
             columnName=stringBuilder.toString();
        }
        SearchMutilUserParam smup=new SearchMutilUserParam();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("article_id",param.getArticle_id());
        map.put("is_display",param.getIs_display());
        map.put("is_del",param.getIs_del());
        map.put("columnName",columnName);
        List<ListCommentResult> listCommentResults=cmsCommentService.findComments(map);
        List<Integer> userId=new ArrayList<Integer>();
        if(listCommentResults!=null) {
            for (int i = 0; i < listCommentResults.size();i++) {
                if(listCommentResults.get(i).getCommentUserId()!=null) {
                  Integer userId1=  listCommentResults.get(i).getCommentUserId();
                    userId.add(userId1);
                }
            }
        }
        smup.setUserIdList(userId);
        List<UserDetail> userDetailList = userFeignService.mutilUser(smup).getDataObj().getUserDetailList();
        Map<String,Object> maps=new HashMap<String,Object>();
        maps.put("userDetail",userDetailList);
        maps.put("Comment",listCommentResults);

        if(listCommentResults!=null){
            return ResultGenerator.genSuccessResult(maps);
        }else {
            return ResultGenerator.genFailResult("文章评论查询失败");
        }
    }
}
