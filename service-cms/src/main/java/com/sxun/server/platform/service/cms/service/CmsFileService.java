package com.sxun.server.platform.service.cms.service;
import com.sxun.server.platform.service.cms.model.CmsFile;
import com.sxun.server.common.web.core.Service;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
public interface CmsFileService extends Service<CmsFile> {
    int saveFirle(CmsFile cmsFile);
    int delFirle(Integer file_id);

    CmsFile find(String file_id);
}
