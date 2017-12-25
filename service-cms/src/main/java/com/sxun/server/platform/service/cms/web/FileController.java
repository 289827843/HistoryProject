package com.sxun.server.platform.service.cms.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.cms.dto.file.req.AddFileParam;
import com.sxun.server.platform.service.cms.dto.file.req.DelFileparam;
import com.sxun.server.platform.service.cms.dto.file.req.OutputFileParam;
import com.sxun.server.platform.service.cms.dto.file.rsp.AddFileResult;
import com.sxun.server.platform.service.cms.itf.IFileConterller;
import com.sxun.server.platform.service.cms.service.CmsArticleService;
import com.sxun.server.platform.service.cms.service.CmsFileService;
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

@Api(name = "附件管理", description = "内容管理相关服务", group = "cms")
@RestController
@RequestMapping("/file")
public class FileController  implements IFileConterller{
    @Autowired
    private CmsFileService cmsFileService;
    @ApiMethod(description = "添加附件")
    @RequestMapping(path ="/add", method = RequestMethod.POST)
    @Override
    public@ApiResponseObject Result<AddFileResult> addFile(@ApiBodyObject @RequestBody@Valid AddFileParam param) {
        return null;
    }
    @ApiMethod(description = "删除附件")
    @RequestMapping(path ="/del", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result addFile(@ApiBodyObject @RequestBody@Valid DelFileparam param) {
        return null;
    }
    @ApiMethod(description = "附件输出流")
    @RequestMapping(path ="/{file_id}", method = RequestMethod.POST)
    @Override
    public@ApiResponseObject
    Result OutputFile(@ApiBodyObject @RequestBody@Valid OutputFileParam param) {
        return null;
    }
}
