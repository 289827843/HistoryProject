package com.sxun.server.platform.service.cms.itf;

import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.cms.dto.comment.req.AddCommentParam;
import com.sxun.server.platform.service.cms.dto.comment.req.DelCommentParam;
import com.sxun.server.platform.service.cms.dto.comment.req.ListCommentParam;
import com.sxun.server.platform.service.cms.dto.comment.req.UpdateCommentParam;
import com.sxun.server.platform.service.cms.dto.comment.rsp.AddCommentResult;
import com.sxun.server.platform.service.cms.dto.dir.req.UpdateDirparam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment" )
public interface ICommentController {
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Result<AddCommentResult> addComment(@RequestBody AddCommentParam param) ;
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Result updateComment(@RequestBody UpdateCommentParam param) ;
    @RequestMapping(path = "/del", method = RequestMethod.POST)
    public Result delComment(@RequestBody DelCommentParam param) ;
    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public Result listComment(@RequestBody ListCommentParam param) ;
}
