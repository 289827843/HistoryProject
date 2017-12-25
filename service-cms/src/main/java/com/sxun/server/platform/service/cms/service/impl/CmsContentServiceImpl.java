package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.platform.service.cms.dao.CmsContentMapper;
import com.sxun.server.platform.service.cms.model.CmsContent;
import com.sxun.server.platform.service.cms.service.CmsContentService;
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
public class CmsContentServiceImpl extends AbstractService<CmsContent> implements CmsContentService {
    @Resource
    private CmsContentMapper cmsContentMapper;

    @Override
    public void saveContent(CmsContent cmsContent) {
        if(cmsContent!=null) {
            int rows = cmsContentMapper.insertContent(cmsContent);
        }
    }

    @Override
    public void deleteContent(Integer article_id) {
        if(article_id!=null || article_id>0){
            cmsContentMapper.deleteContent(article_id);
        }
    }

    @Override
    public int getCounts(Integer article_id) {
        if(article_id!=null && article_id>0){
            int count=cmsContentMapper.getCounts(article_id);
            return count;
        }
        return 0;
    }

    @Override
    public List<CmsContent> findContents(Integer article_id) {
        if(article_id!=null || article_id>0){
            List<CmsContent> cmsContents=cmsContentMapper.findContents(article_id);
            return  cmsContents;
        }
        return null;
    }
}
