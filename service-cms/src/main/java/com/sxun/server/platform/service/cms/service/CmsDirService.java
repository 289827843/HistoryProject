package com.sxun.server.platform.service.cms.service;
import com.sxun.server.platform.service.cms.dto.dir.rsp.ListDirResult;
import com.sxun.server.platform.service.cms.model.CmsDir;
import com.sxun.server.common.web.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
public interface CmsDirService extends Service<CmsDir> {
 int saveDir(CmsDir cmsDir,String name);
 int findDirId(String name);
 void updateDir(CmsDir cmsDir);
 int deleteDir(Integer dir_id);
 int  haschilds(Integer dir_id);
 List<ListDirResult> findDirs( int dir_id, int cata_id, int parent_id,String name,boolean is_display);
}
