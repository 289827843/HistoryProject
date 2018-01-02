package com.sxun.server.platform.service.cms.itf;

import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.cms.dto.dir.req.AddDirParam;
import com.sxun.server.platform.service.cms.dto.dir.rsp.AddDirResult;
import com.sxun.server.platform.service.cms.dto.file.req.AddFileParam;
import com.sxun.server.platform.service.cms.dto.file.req.DelFileparam;
import com.sxun.server.platform.service.cms.dto.file.req.OutputFileParam;
import com.sxun.server.platform.service.cms.dto.file.rsp.AddFileResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dir")
public interface IFileConterller {
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Result<AddFileResult> addFile(@RequestBody AddFileParam param) ;
    @RequestMapping(path = "/del", method = RequestMethod.POST)
    public Result delFile(@RequestBody DelFileparam param) ;
    @RequestMapping(path = "/{file_id}", method = RequestMethod.POST)
    public Result OutputFile(@RequestBody OutputFileParam param) ;
}
