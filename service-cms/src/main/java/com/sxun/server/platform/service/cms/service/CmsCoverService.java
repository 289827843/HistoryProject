package com.sxun.server.platform.service.cms.service;
import com.sxun.server.platform.service.cms.model.CmsCover;
import com.sxun.server.common.web.core.Service;
import com.sxun.server.platform.service.cms.model.CmsDir;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
public interface CmsCoverService extends Service<CmsCover> {
    void saveCover(CmsCover cmsCover);
    void deleteCover(Integer article_id);
    int getCounts(Integer article_id);
    List<CmsCover> findCovers(Integer article_id);

}
