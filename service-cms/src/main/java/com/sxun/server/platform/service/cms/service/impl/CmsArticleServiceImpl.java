package com.sxun.server.platform.service.cms.service.impl;

import com.github.pagehelper.PageInfo;
import com.sxun.server.platform.service.cms.dao.CmsArticleLogMapper;
import com.sxun.server.platform.service.cms.dao.CmsArticleMapper;
import com.sxun.server.platform.service.cms.dao.CmsContentMapper;
import com.sxun.server.platform.service.cms.dao.CmsCoverMapper;
import com.sxun.server.platform.service.cms.dto.article.req.*;
import com.sxun.server.platform.service.cms.model.CmsArticle;
import com.sxun.server.platform.service.cms.model.CmsArticleLog;
import com.sxun.server.platform.service.cms.model.CmsContent;
import com.sxun.server.platform.service.cms.model.CmsCover;
import com.sxun.server.platform.service.cms.service.CmsArticleService;
import com.sxun.server.common.web.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.sql.Array;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/12/17.
 */
@Service
@Transactional
public class CmsArticleServiceImpl extends AbstractService<CmsArticle> implements CmsArticleService {
    @Resource
    private CmsArticleMapper cmsArticleMapper;
    @Resource
    private CmsCoverMapper cmsCoverMapper;
    @Resource
    private CmsContentMapper cmsContentMapper;
    @Resource
    private CmsArticleLogMapper cmsArticleLogMapper;


    @Override
    public int saveArticle(AddArticleParam param) {
        int articleId = 0;
        CmsArticle cmsArticle = new CmsArticle();
        cmsArticle.setTitle(param.getTitle());
        cmsArticle.setSource(param.getSource());
        cmsArticle.setAuthor(param.getAuthor());
        cmsArticle.setArticleType(Integer.valueOf(param.getArticle_type()));
        cmsArticle.setOwnUserId(param.getOpr_user_id());
        cmsArticle.setAuditUserId(-1);
        cmsArticle.setDirId(param.getDir_id().intValue());
        int row = cmsArticleMapper.insertArticle(cmsArticle);
        if (row > 0) {
            articleId = cmsArticleMapper.findArticleid(cmsArticle);
        }
        if (articleId > 0 && param.getCover_list()!=null) {

            List<Cover> covers = param.getCover_list();
            if (covers != null) {
                for (Cover a:covers) {
                    CmsCover cmsCover = new CmsCover();
                    cmsCover.setActicleId(articleId);
                    cmsCover.setFileId(a.getFile_id());
                    cmsCoverMapper.insertCover(cmsCover);
                }
            }
        }
            List<Content> content = param.getContent_List();
            if (articleId > 0 && content != null) {
                for (Content a : content) {
                    CmsContent cmsContent = new CmsContent();
                    cmsContent.setSeqNo(a.getSeq_no());
                    cmsContent.setContentType(a.getContent_type());
                    cmsContent.setContent(a.getContent());
                    cmsContent.setFileId(a.getFile_id());
                    cmsContent.setArticleId(articleId);
                    if (cmsContent.getFileId() != null) {
                        cmsContentMapper.insertContent(cmsContent);
                    }

                }

            }
            CmsArticleLog cmsArticleLog = new CmsArticleLog();
            cmsArticleLog.setArticleId(articleId);
            cmsArticleLog.setOprUserId(param.getOpr_user_id());
            cmsArticleLog.setOprContent("文章的创建");
            if (cmsArticleLog != null) {
                cmsArticleLogMapper.insertArticleLog(cmsArticleLog);
                return articleId;
            }else {
                return -1;
            }
    }


    @Override
    public int updateArticle(UpdateArticleParam param) {
        CmsArticle cmsArticle = new CmsArticle();
        cmsArticle.setArticleId(param.getArticle_id().intValue());
        cmsArticle.setTitle(param.getTitle());
        cmsArticle.setStatus(0);
        cmsArticle.setSource(param.getSource());
        cmsArticle.setAuthor(param.getAuthor());
        cmsArticle.setArticleType(Integer.valueOf(param.getArticle_type()));
        cmsArticle.setDirId(param.getDir_id().intValue());
        Date date=new Date();
        cmsArticle.setModifyTime(date);
        if (param.getArticle_id() != null && param.getArticle_id().intValue() > 0) {
            cmsArticleMapper.updateAriticle(cmsArticle);
        }
         cmsCoverMapper.deleteCover(param.getArticle_id().intValue());

        List<Cover> covers = param.getCover_list();
         if (covers != null) {
             for (Cover a:covers) {
                CmsCover cmsCover = new CmsCover();
                cmsCover.setActicleId(param.getArticle_id());
                cmsCover.setFileId(a.getFile_id());
                cmsCoverMapper.insertCover(cmsCover);
             }
         }

            cmsContentMapper.deleteContent(param.getArticle_id().intValue());
            List<Content> content = param.getContent_List();
            if (content != null) {
                for (Content a : content) {
                    CmsContent cmsContent = new CmsContent();
                    cmsContent.setSeqNo(a.getSeq_no());
                    cmsContent.setContentType(a.getContent_type());
                    cmsContent.setContent(a.getContent());
                    cmsContent.setFileId(a.getFile_id());
                    cmsContent.setArticleId(param.getArticle_id().intValue());
                    if (cmsContent.getFileId() != null) {
                        cmsContentMapper.insertContent(cmsContent);
                    }
                }
            }

            CmsArticleLog cmsArticleLog = new CmsArticleLog();
            cmsArticleLog.setArticleId(param.getArticle_id().intValue());
            cmsArticleLog.setOprUserId(param.getOpr_user_id());
            cmsArticleLog.setOprContent("文章的修改");
            if (cmsArticleLog != null) {
                cmsArticleLogMapper.insertArticleLog(cmsArticleLog);
                return param.getArticle_id().intValue();
            }else {


                return -1;
            }
    }


    @Override
    public int sumbitArticle(Integer article_id, Integer opr_user_id) {
        int counts = -1;
        if (article_id > 0) {
            counts = cmsArticleMapper.getCounts(article_id);
        }
        if (counts == 1) {
            counts = cmsCoverMapper.getCounts(article_id);
        }
        if (counts >= 1) {
            counts = cmsContentMapper.getCounts(article_id);
        }
        if (counts >= 1) {
            CmsArticle cmsArticle = new CmsArticle();
            cmsArticle.setArticleId(article_id);
            cmsArticle.setAuditUserId(null);
            cmsArticle.setAuditMemo(null);
            cmsArticle.setStatus(1);
            cmsArticleMapper.sumbitAriticle(cmsArticle);
            CmsArticleLog cmsArticleLog = new CmsArticleLog();
            cmsArticleLog.setArticleId(article_id);
            cmsArticleLog.setOprUserId(opr_user_id);
            cmsArticleLog.setOprContent("文章的提交");
            cmsArticleLogMapper.insertArticleLog(cmsArticleLog);
            return 1;
        }else {
            return -1;
        }
    }


    @Override
    public int auditArticle(AuditArticleParam param) {
        int counts = -1;
        int status = -1;
        if (param.getArticle_id().intValue() > 0) {
            counts = cmsArticleMapper.getCounts(param.getArticle_id().intValue());
        }
        if (counts == 1) {
            status = cmsArticleMapper.getStatus(param.getArticle_id().intValue());
        }
        if (status == 1) {
            if (param.getAudit_result()) {
                CmsArticle cmsArticle = new CmsArticle();
                cmsArticle.setArticleId(param.getArticle_id().intValue());
                cmsArticle.setStatus(2);
                cmsArticle.setAuditUserId(param.getOpr_user_id());
                cmsArticle.setAuditMemo("");
                cmsArticleMapper.sumbitAriticle(cmsArticle);
            } else {
                CmsArticle cmsArticle = new CmsArticle();
                cmsArticle.setArticleId(param.getArticle_id().intValue());
                cmsArticle.setStatus(0);
                cmsArticle.setAuditUserId(param.getOpr_user_id());
                cmsArticle.setAuditMemo(param.getAudit_memo());
                cmsArticleMapper.sumbitAriticle(cmsArticle);
            }
        }
            CmsArticleLog cmsArticleLog = new CmsArticleLog();
            cmsArticleLog.setArticleId(param.getArticle_id().intValue());
            cmsArticleLog.setOprUserId(param.getOpr_user_id());
            cmsArticleLog.setOprContent("文章审核");
            if(cmsArticleLog!=null) {
                cmsArticleLogMapper.insertArticleLog(cmsArticleLog);
                return 1;
            }else {
                return 0;
            }
    }

    @Override
    public int closeArticle(Integer article_id) {
        int count=-1;
        int status=-1;
         if(article_id>0){
          count=  cmsArticleMapper.getCounts(article_id);
         }
         if(count>0){
              status=cmsArticleMapper.getStatus(article_id);
         }
         if(status==2){
             CmsArticle cmsArticle=new CmsArticle();
             cmsArticle.setArticleId(article_id);
             cmsArticle.setStatus(3);
             count =cmsArticleMapper.updateStatus(cmsArticle);
         }
         if(count>0){
             return 1;
         }else{
             return -1;
         }

    }

    @Override
    public Map<String, Object> detailArticle(Integer article_id) {
        if (article_id > 0) {
            CmsArticle cmsArticle = cmsArticleMapper.findArticle(article_id);
            List<CmsCover> coverlist = cmsCoverMapper.findCovers(article_id);
            List<CmsContent> contents = cmsContentMapper.findContents(article_id);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("CmsAriticle", cmsArticle);
            map.put("CmsContent", contents);
            map.put("CmsCover", coverlist);

            return map;
        }else {
            return null;
        }
    }

    @Override
    public Map<String, Object> listArticle(ListArticleParam param) {
        int startIndex=(param.getCurrent_page().intValue()-1)*param.getPage_size().intValue();
        param.setCurrent_page(startIndex);
        List<CmsArticle> cmsArticles=cmsArticleMapper.listAriticle(param);
        int counts=cmsArticleMapper.getAriticleCounts(param);
        int pageCount=counts/param.getPage_size().intValue();
        if(counts%param.getPage_size().intValue()!=0){
            pageCount++;
        }
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageNum(pageCount);
        pageInfo.setStartRow(startIndex);
        pageInfo.setPageSize(param.getPage_size().intValue());
        pageInfo.setSize(counts);
        CmsArticle cmsArticle = new CmsArticle();
        cmsArticle.setTitle(param.getTitle());
        cmsArticle.setSource(param.getSource());
        cmsArticle.setAuthor(param.getAuthor());
        cmsArticle.setDirId(param.getDir_id());
        cmsArticle.setArticleType(Integer.valueOf(param.getArticle_type()));
        int articleId= cmsArticleMapper.findArticleid(cmsArticle);
        List<CmsCover> cmsCovers=cmsCoverMapper.findCovers(articleId);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("CmsArticle",cmsArticles);
        map.put("pageInfo",pageInfo);
        map.put("CmsCover",cmsCovers);
        return map;

    }
}