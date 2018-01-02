package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.dto.dir.rsp.ListDirResult;
import com.sxun.server.platform.service.cms.model.CmsDir;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Past;
import java.util.List;

public interface CmsDirMapper extends Mapper<CmsDir> {
    int insertDir(CmsDir cmsDir);
    int findDirid ( String name, Integer cataId, Integer parentDirId);
    int  updateDir(CmsDir cmsDir);
    int deleteDir(@Param("dir_id")Integer dir_id);
    int hasChilds(Integer dir_id);
    List<CmsDir> findDirs(CmsDir cmsDir );
    int updatePath(CmsDir cmsDir);
    CmsDir findDir(@Param("dir_id")Integer dir_id);
    List<CmsDir> findChilds(@Param("dir_id")Integer dir_id);
    int updateCataId(CmsDir cmsDir);

}