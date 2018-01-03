package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.platform.service.cms.dao.CmsArticleMapper;
import com.sxun.server.platform.service.cms.dao.CmsDirMapper;
import com.sxun.server.platform.service.cms.dto.dir.req.MoveDirParam;
import com.sxun.server.platform.service.cms.dto.dir.rsp.ListDirResult;
import com.sxun.server.platform.service.cms.model.CmsArticle;
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
    @Resource
   private CmsArticleMapper cmsArticleMapper;
    @Override
    public int saveDir(CmsDir cmsDir) {
        int dirId=-1;
        int row=-1;
        int rows = cmsDirMapper.insertDir(cmsDir);
        if (rows > 0) {
            dirId = cmsDirMapper.findDirid(cmsDir);
            String path = "\r\n/" + cmsDir.getCataId() + "/" + cmsDir.getParentDirId() + "/" + dirId;
            cmsDir.setPath(path);
            if(cmsDir.getParentDirId()==-1){
                cmsDir.setLevel(2);
            }else{
            cmsDir.setLevel(3);
            }
            cmsDir.setDirId(dirId);
            if (cmsDir != null) {
               row = cmsDirMapper.updatePath(cmsDir);

            }

        }
         if(row>0 && dirId>0){
            return dirId;
         }else{
             return -1;
         }

    }


    @Override
    public int updateDir(CmsDir cmsDir) {
        int rows=-1;
        if(cmsDir!=null){
             rows=cmsDirMapper.updateDir(cmsDir);


        }
        if(rows>0){
            return rows;
        }else{
            return 0;
        }
    }

    @Override
    public int deleteDir(Integer dir_id) {


         int count = cmsArticleMapper.findArticles(dir_id);
          int  counts = cmsDirMapper.hasChilds(dir_id);
          if(count>0 || counts>0){
              return -1;
          }else{
              cmsDirMapper.deleteDir(dir_id);
              return 1;
          }
    }



    @Override
    public List<CmsDir> findDirs(CmsDir cmsDir) {
        List<CmsDir> results=cmsDirMapper.findDirs(cmsDir);
        return results;
    }

    @Override
    public int moveDirs(MoveDirParam param) {
        List<CmsArticle> cmsArticles=null;
        List<CmsDir> cmsDirList=null;
        int row=-1;
        int rows=-1;
        CmsDir cmsDir=cmsDirMapper.findDir(param.getDir_id());
        if(cmsDir!=null) {
            CmsDir cmsDir1 = new CmsDir();
            cmsDir1.setDirId(param.getDir_id());
            cmsDir1.setParentDirId(param.getParent_id());
            cmsDir1.setCataId(param.getCata_id());
            String path = "\r\n/" + param.getCata_id() + "/" + param.getParent_id() + "/" + param.getDir_id();
            cmsDir1.setPath(path);
            if (param.getParent_id() == -1) {
                cmsDir1.setLevel(2);
            } else {
                cmsDir1.setLevel(3);
            }
            cmsDir1.setDirId(param.getDir_id());
            if (cmsDir1 != null) {
                row = cmsDirMapper.updateCataId(cmsDir1);
            }
        }
            cmsDirList = cmsDirMapper.findChilds(param.getDir_id());
            if(cmsDirList!=null) {
                for (CmsDir a : cmsDirList) {
                    CmsDir cmsDir2 = new CmsDir();
                    cmsDir2.setDirId(a.getDirId());
                    cmsDir2.setParentDirId(param.getDir_id());
                    cmsDir2.setCataId(param.getCata_id());
                    String path1 = "\r\n/" + param.getCata_id() + "/" + param.getDir_id() + "/" + a.getDirId();
                    cmsDir2.setPath(path1);
                    cmsDir2.setLevel(3);
                   rows=cmsDirMapper.updateCataId(cmsDir2);
                }

            }
            if(row>0 || rows>0){
                return 1;
            }else{
                return -1;
            }

    }

}
