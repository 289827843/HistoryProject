package com.sxun.server.platform.service.cms.service.impl;

import com.sxun.server.platform.service.cms.dao.CmsFileMapper;
import com.sxun.server.platform.service.cms.model.CmsFile;
import com.sxun.server.platform.service.cms.service.CmsFileService;
import com.sxun.server.common.web.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
@Service
@Transactional
public class CmsFileServiceImpl extends AbstractService<CmsFile> implements CmsFileService {
    @Resource
    private CmsFileMapper cmsFileMapper;

    @Override
    public int saveFirle(CmsFile cmsFile) {
        int row=cmsFileMapper.insertFile(cmsFile);

       if(row>0) {
           return row;
       }else {
           return 0;
       }

    }

    @Override
    public int delFirle(Integer file_id) {
        int row=cmsFileMapper.deleteFirle(file_id);
        if(row>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public CmsFile find(String file_id) {
        CmsFile cmsFile=cmsFileMapper.findByFileId(file_id);
        if(cmsFile!=null){
            return cmsFile;
        }else {
            return null;
        }
    }
}
