package com.sxun.server.platform.service.cms.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.platform.service.cms.dto.article.req.*;
import com.sxun.server.platform.service.cms.dto.article.rsp.AddArticleResult;
import com.sxun.server.platform.service.cms.itf.IArticleController;
import com.sxun.server.platform.service.cms.model.CmsArticle;
import com.sxun.server.platform.service.cms.model.CmsArticleLog;
import com.sxun.server.platform.service.cms.model.CmsContent;
import com.sxun.server.platform.service.cms.model.CmsCover;
import com.sxun.server.platform.service.cms.service.CmsArticleLogService;
import com.sxun.server.platform.service.cms.service.CmsArticleService;
import com.sxun.server.platform.service.cms.service.CmsContentService;
import com.sxun.server.platform.service.cms.service.CmsCoverService;
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
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Api(name = "文章管理", description = "内容管理相关服务", group = "cms")
@RestController
@RequestMapping("/article")
public class ArticleController implements IArticleController {
    @Autowired
    private CmsArticleService cmsArticleService;
    private CmsCoverService cmsCoverService;
    private CmsContentService cmsContentService;
    private CmsArticleLogService cmsArticleLogService;

    @ApiMethod(description = "添加文章")
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @Override

    public @ApiResponseObject
    Result<AddArticleResult>  addArticle(@ApiBodyObject @RequestBody@Valid AddArticleParam param) {

        int AritcleId = cmsArticleService.saveArticle(param);;

        if (AritcleId > 0) {

            AddArticleResult addArticleResult = new AddArticleResult();
            addArticleResult.setArticle_id(AritcleId);
            return ResultGenerator.genSuccessResult(addArticleResult);
        }
        return ResultGenerator.genFailResult("文章创建失败");
    }

    @ApiMethod(description = "更新文章")
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject
    Result updateArticle(@ApiBodyObject @RequestBody@Valid UpdateArticleParam param) {

        if (param.getArticle_id().intValue() > 0) {
          int article_id= cmsArticleService.updateArticle(param);

            AddArticleResult addArticleResult = new AddArticleResult();
            addArticleResult.setArticle_id(article_id);
            return ResultGenerator.genSuccessResult(addArticleResult);

        }

        return ResultGenerator.genFailResult("文章修改失败");
    }

    @ApiMethod(description = "提交文章")
    @RequestMapping(path = "/sumbit", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject
    Result sumbitArticle(@ApiBodyObject @RequestBody @Valid SumbitArticleParam param) {
        int result=cmsArticleService.sumbitArticle(param.getArticle_id().intValue(),param.getOpr_user_id());
        if(result==1){
            ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("提交失败");
    }


    @ApiMethod(description = "审核文章")
    @RequestMapping(path ="/audit", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result auditArticle(@ApiBodyObject @RequestBody@Valid AuditArticleParam param) {
        int result=cmsArticleService.auditArticle(param);
       if(result==1){
          return ResultGenerator.genSuccessResult();
       }
        return ResultGenerator.genFailResult("审核操作失败");
    }
    @ApiMethod(description = "文章详情")
    @RequestMapping(path ="/detail", method = RequestMethod.POST)
    @Override
    public  @ApiResponseObject Result detailArticle(@ApiBodyObject @RequestBody@Valid DetailArticleParam param) {
        Map<String,Object> map=cmsArticleService.detailArticle(param.getArticle_id().intValue());
        if(map!=null) {
            return ResultGenerator.genSuccessResult(map);
        }

        return ResultGenerator.genFailResult("操作失败");
    }
    @ApiMethod(description = "文章下架")
    @RequestMapping(path ="/close", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result closeArticle(@ApiBodyObject @RequestBody@Valid CloseArticleParam param) {
        int result=cmsArticleService.closeArticle(param.getArticle_id().intValue());
        if(result==1){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("下架失败");
    }
    @ApiMethod(description = "文章查询")
    @RequestMapping(path ="/close", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result listArticle(@ApiBodyObject @RequestBody@Valid ListArticleParam param) {
        Map<String,Object> map=cmsArticleService.listArticle(param);
        if(map!=null) {
            return ResultGenerator.genSuccessResult(map);
        }

        return ResultGenerator.genFailResult("查询失败");
    }
}
