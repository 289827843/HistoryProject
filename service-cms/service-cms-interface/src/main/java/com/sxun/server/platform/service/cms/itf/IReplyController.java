package com.sxun.server.platform.service.cms.itf;


import com.sxun.server.common.remote.Result;
import com.sxun.server.platform.service.cms.dto.reply.req.AddReplyParam;
import com.sxun.server.platform.service.cms.dto.reply.req.DelReplyParam;
import com.sxun.server.platform.service.cms.dto.reply.req.UpdateReplyParam;
import com.sxun.server.platform.service.cms.dto.reply.rsp.AddReplyResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
public interface IReplyController {
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Result<AddReplyResult> addReply(@RequestBody AddReplyParam param) ;
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Result updateReply(@RequestBody UpdateReplyParam param) ;
    @RequestMapping(path = "/del", method = RequestMethod.POST)
    public Result delReply(@RequestBody DelReplyParam param) ;
}
