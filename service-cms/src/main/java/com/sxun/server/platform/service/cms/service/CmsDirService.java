package com.sxun.server.platform.service.cms.service;
import com.sxun.server.platform.service.cms.dto.dir.req.MoveDirParam;
import com.sxun.server.platform.service.cms.dto.dir.rsp.ListDirResult;
import com.sxun.server.platform.service.cms.model.CmsDir;
import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.cms.model.CmsFile;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
public interface CmsDirService extends Service<CmsDir> {
 int saveDir(CmsDir cmsDir);
 int updateDir(CmsDir cmsDir);
 int deleteDir(Integer dir_id);

 List<CmsDir> findDirs(CmsDir cmsDir );
int moveDirs(MoveDirParam param);
}
