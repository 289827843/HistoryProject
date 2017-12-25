package com.sxun.server.platform.service.cms.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultCode;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.common.util.IpUtil;
import com.sxun.server.platform.service.cms.dto.article.req.UpdateArticleParam;
import com.sxun.server.platform.service.cms.dto.dir.req.*;
import com.sxun.server.platform.service.cms.dto.dir.rsp.AddDirResult;
import com.sxun.server.platform.service.cms.dto.dir.rsp.ListDirResult;
import com.sxun.server.platform.service.cms.itf.IDirController;
import com.sxun.server.platform.service.cms.model.CmsDir;
import com.sxun.server.platform.service.cms.service.CmsArticleService;
import com.sxun.server.platform.service.cms.service.CmsDirService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(name = "目录管理", description = "内容管理相关服务", group = "cms")
@RestController
@RequestMapping("/dir")
public class DirController implements IDirController {
    @Autowired
    private CmsDirService cmsDirService;
    private CmsArticleService cmsArticleService;
    @ApiMethod(description = "添加目录")
    @RequestMapping(path ="/add", method = RequestMethod.POST)
    @Override

    public @ApiResponseObject
    Result<AddDirResult> addDir(@ApiBodyObject @RequestBody @Valid AddDirParam param) {
        CmsDir cmsDir = new CmsDir();
        cmsDir.setCataId(param.getCata_id());
        cmsDir.setName(param.getName());
        cmsDir.setParentDirId(param.getParent_id());
        int dir_id= cmsDirService.saveDir(cmsDir,param.getName());
        if(dir_id!=-1){
            AddDirResult addDirResult=new AddDirResult();
            addDirResult.setDir_id(dir_id);
            return ResultGenerator.genSuccessResult(addDirResult);
        }
         return ResultGenerator.genFailResult("添加目录错误");
    }

    @ApiMethod(description = "修改目录")
    @RequestMapping(path ="/update", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result updateDir(@ApiBodyObject @RequestBody @Valid UpdateDirparam param) {
        CmsDir cmsDir = new CmsDir();
        cmsDir.setName(param.getName());
        cmsDir.setDirId(param.getDir_id());
        cmsDir.setIsDisplay(param.isIs_display());
        cmsDirService.updateDir(cmsDir);

        return ResultGenerator.genSuccessResult();
    }
    @ApiMethod(description = "移动目录")
    @RequestMapping(path ="/move", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result moveDir(@ApiBodyObject @RequestBody @Valid MoveDirParam param) {

        return null;
    }
    @ApiMethod(description = "删除目录")
    @RequestMapping(path ="/del", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result delDir(@ApiBodyObject @RequestBody @Valid DelDirParam param) {

        int count= cmsDirService.deleteDir(Integer.valueOf(param.getDir_id()));
        if(count==1){
            return  ResultGenerator.genSuccessResult();

        }
        return ResultGenerator.genFailResult("删除失败");
    }
    @ApiMethod(description = "查询目录")
    @RequestMapping(path ="/list", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result listDir(@ApiBodyObject @RequestBody @Valid ListDirparam param) {
       List<ListDirResult> resultList=cmsDirService.findDirs(param.getDir_id().intValue(),param.getCata_id().intValue(),param.getParent_id().intValue(),param.getName(),param.isIs_display());

       return ResultGenerator.genSuccessResult(resultList);
    }





}
