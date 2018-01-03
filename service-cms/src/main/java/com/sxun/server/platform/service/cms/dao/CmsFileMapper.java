package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.model.CmsFile;
import org.springframework.data.repository.query.Param;

public interface CmsFileMapper extends Mapper<CmsFile> {
    int insertFile(CmsFile cmsFile);
    int findFirleId(CmsFile cmsFile);
    int deleteFirle(Integer file_id);
     CmsFile findByFileId(@Param("file_id") String file_id);

}