package com.sxun.server.platform.service.cms.itf;


import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.cms.dto.article.req.UpdateArticleParam;
import com.sxun.server.platform.service.cms.dto.dir.req.*;
import com.sxun.server.platform.service.cms.dto.dir.rsp.AddDirResult;
import com.sxun.server.platform.service.cms.dto.dir.rsp.ListDirResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dir")
public interface IDirController {
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Result<AddDirResult> addDir(@RequestBody AddDirParam param) ;
    @RequestMapping(path="/update", method= RequestMethod.POST)
    public  Result updateDir(@RequestBody UpdateDirparam param);
    @RequestMapping(path="/move", method= RequestMethod.POST)
    public  Result moveDir(@RequestBody MoveDirParam param);
    @RequestMapping(path="/del", method= RequestMethod.POST)
    public  Result delDir(@RequestBody DelDirParam param);
    @RequestMapping(path="/list", method= RequestMethod.POST)
    public  Result listDir(@RequestBody ListDirparam param);
}
