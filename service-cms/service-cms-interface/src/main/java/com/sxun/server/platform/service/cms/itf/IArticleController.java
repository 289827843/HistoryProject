package com.sxun.server.platform.service.cms.itf;

import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.cms.dto.article.req.*;
import com.sxun.server.platform.service.cms.dto.article.rsp.AddArticleResult;
import com.sxun.server.platform.service.cms.dto.dir.req.AddDirParam;
import com.sxun.server.platform.service.cms.dto.dir.rsp.AddDirResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public interface IArticleController {
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Result<AddArticleResult> addArticle(@RequestBody AddArticleParam param) ;
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Result updateArticle(@RequestBody UpdateArticleParam param) ;
    @RequestMapping(path = "/sumbit", method = RequestMethod.POST)
    public Result sumbitArticle(@RequestBody SumbitArticleParam param) ;
    @RequestMapping(path = "/audit", method = RequestMethod.POST)
    public Result auditArticle(@RequestBody AuditArticleParam param) ;
    @RequestMapping(path = "/deatil", method = RequestMethod.POST)
    public Result detailArticle(@RequestBody DetailArticleParam param) ;
    @RequestMapping(path = "/close", method = RequestMethod.POST)
    public Result closeArticle(@RequestBody CloseArticleParam param) ;
    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public Result listArticle(@RequestBody ListArticleParam param) ;
}
