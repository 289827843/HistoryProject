package com.sxun.server.platform.service.cms.dao;

import com.sxun.server.common.web.core.Mapper;
import com.sxun.server.platform.service.cms.dto.dir.rsp.ListDirResult;
import com.sxun.server.platform.service.cms.model.CmsDir;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Past;
import java.util.List;

public interface CmsDirMapper extends Mapper<CmsDir> {
    int insertDir(CmsDir cmsDir);
    int findDirid (@Param("name") String name);
    int  updateDir(CmsDir cmsDir);
    int deleteDir(@Param("dir_id")Integer dir_id);
    int hasChilds(@Param("dir_id")Integer dir_id);
    List<ListDirResult> findDirs(@Param("dir_id") int dir_id,@Param("cata_id") int cata_id,@Param("parent_id") int parent_id,@Param("name") String name,@Param("is_display") boolean is_display);
}