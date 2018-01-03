package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.platform.service.cms.dao.CmsCoverMapper;
import com.sxun.server.platform.service.cms.model.CmsCover;
import com.sxun.server.platform.service.cms.service.CmsCoverService;
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
public class CmsCoverServiceImpl extends AbstractService<CmsCover> implements CmsCoverService {
    @Resource
    private CmsCoverMapper cmsCoverMapper;

    @Override
    public void saveCover(CmsCover cmsCover) {
        if(cmsCover!=null) {
            int rows = cmsCoverMapper.insertCover(cmsCover);
        }
    }

    @Override
    public void deleteCover(Integer article_id) {
        if(article_id!=null || article_id>0){
            cmsCoverMapper.deleteCover(article_id);
        }
    }

    @Override
    public int getCounts(Integer article_id) {
        if(article_id!=null && article_id>0){
            int count=cmsCoverMapper.getCounts(article_id);
            return count;
        }

        return 0;
    }

    @Override
    public List<CmsCover> findCovers(Integer article_id) {
        if(article_id!=null && article_id>0){
            List<CmsCover> cmsCovers=cmsCoverMapper.findCovers(article_id);
            return  cmsCovers;
        }
        return null;
    }

}
