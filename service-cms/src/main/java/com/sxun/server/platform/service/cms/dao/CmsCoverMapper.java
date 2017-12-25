package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.model.CmsCover;
import com.sxun.server.platform.service.cms.model.CmsDir;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsCoverMapper extends Mapper<CmsCover> {
    int insertCover(CmsCover cmsCover);
    int deleteCover(Integer article_id);
    int getCounts(Integer article_id);
    List<CmsCover> findCovers(Integer article_id);
}