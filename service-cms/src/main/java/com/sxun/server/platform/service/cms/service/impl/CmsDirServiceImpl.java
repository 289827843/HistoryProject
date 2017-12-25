package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.platform.service.cms.dao.CmsArticleMapper;
import com.sxun.server.platform.service.cms.dao.CmsDirMapper;
import com.sxun.server.platform.service.cms.dto.dir.rsp.ListDirResult;
import com.sxun.server.platform.service.cms.model.CmsDir;
import com.sxun.server.platform.service.cms.service.CmsDirService;
import com.sxun.server.common.web.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
@Service
@Transactional
public class CmsDirServiceImpl extends AbstractService<CmsDir> implements CmsDirService {
    @Resource
    private CmsDirMapper cmsDirMapper;
   private CmsArticleMapper cmsArticleMapper;
    @Override
    public int saveDir(CmsDir cmsDir,String name) {
          int rows = cmsDirMapper.insertDir(cmsDir);
          if(rows>0){
              int dirId = cmsDirMapper.findDirid(name);
              return dirId;

          }
      return -1;
    }

    @Override
    public int findDirId(String name) {
        if(name!=null) {
            int dirId = cmsDirMapper.findDirid(name);
            return dirId;
        }
      return -1;
    }

    @Override
    public void updateDir(CmsDir cmsDir) {
        if(cmsDir!=null){
            int rows=cmsDirMapper.updateDir(cmsDir);
        }
    }

    @Override
    public int deleteDir(Integer dir_id) {

        int count=cmsArticleMapper.findArticles(dir_id);
        int counts=cmsDirMapper.hasChilds(dir_id);

        if(count>0 && counts>0){
          return -1;
        }
        cmsDirMapper.deleteDir(dir_id);
        return 1;
    }

    @Override
    public int haschilds(Integer dir_id) {
        if(dir_id!=null || dir_id>0){
            int count=cmsDirMapper.hasChilds(dir_id);
            if(count>0) {
                return count;
            }
        }
        return 0;
    }

    @Override
    public List<ListDirResult> findDirs(int dir_id, int cata_id, int parent_id, String name, boolean is_display) {
        List<ListDirResult> results=cmsDirMapper.findDirs(dir_id,cata_id,parent_id,name,is_display);
        return results;
    }

}
