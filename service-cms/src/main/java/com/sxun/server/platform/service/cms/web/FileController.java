package com.sxun.server.platform.service.cms.web;

import com.sxun.server.common.remote.Result;
import com.sxun.server.common.remote.ResultGenerator;
import com.sxun.server.platform.service.cms.dto.file.req.AddFileParam;
import com.sxun.server.platform.service.cms.dto.file.req.DelFileparam;
import com.sxun.server.platform.service.cms.dto.file.req.OutputFileParam;
import com.sxun.server.platform.service.cms.dto.file.rsp.AddFileResult;
import com.sxun.server.platform.service.cms.itf.IFileConterller;
import com.sxun.server.platform.service.cms.model.CmsFile;
import com.sxun.server.platform.service.cms.service.CmsArticleService;
import com.sxun.server.platform.service.cms.service.CmsFileService;

import org.apache.tomcat.util.codec.binary.Base64;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Api(name = "附件管理", description = "内容管理相关服务", group = "cms")
@RestController
@RequestMapping("/file")
public class FileController  implements IFileConterller{
    @Autowired
    private CmsFileService cmsFileService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Value("${sxun.service.cms.filepath.root}")
    private String root;
    @ApiMethod(description = "添加附件")
    @RequestMapping(path ="/add", method = RequestMethod.POST)
    @Override
    public@ApiResponseObject Result<AddFileResult> addFile(@ApiBodyObject @RequestBody@Valid AddFileParam param) {
        int row=-1;
        byte[] b=null;
        String fileName=null;
        if(param.getName()==null){

            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            param.setName(uuid);
        }
        String file_id=UUID.randomUUID().toString().replaceAll("-", "");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        String time=simpleDateFormat.format(date);
      String filepath=""+root+"/"+time;
       // String filepath="C:/Users/admin/Desktop/xiaxiangfuwu/service-core/"+time;
        if(param.getExt()!=null) {
            fileName = file_id + "." + param.getExt();
        }else {
            fileName=file_id;
        }
        File file = new File(filepath,fileName);

        if(!file.exists())
            //  先创建文件所在的目录
            file.getParentFile().mkdirs();
            try {
                // 创建新文件
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创建新文件时出现了错误。。。");
                e.printStackTrace();
            }



        try {
            //Base64解码
           //  b = Base64.decodeBase64(param.getBase64_str().getBytes("UTF-8"));
            b= Base64.decodeBase64(param.getBase64_str());
            for(int i=0;i<b.length;++i){
                if(b[i]<0){//调整异常数据
                    b[i]+=256;
                }
            }
            //生成文件，并保存在服务器硬盘上

            OutputStream out = new FileOutputStream(file);
            out.write(b);
            out.flush();
            out.close();

        } catch (Exception e)  {
            e.printStackTrace();

        }
        String path=""+time+"/"+fileName;
        CmsFile cmsFile=new CmsFile();
        cmsFile.setFileExt(param.getExt());
        cmsFile.setFileName(param.getName());
        cmsFile.setFilePath(path);
        cmsFile.setFileId(file_id);
        row=cmsFileService.saveFirle(cmsFile);
        if(row>0){
            AddFileResult addFileResult=new AddFileResult();
            addFileResult.setFile_id(file_id);
            return ResultGenerator.genSuccessResult(addFileResult);
        }else {
            return ResultGenerator.genFailResult("添加附件失败");
        }
    }
    @ApiMethod(description = "删除附件")
    @RequestMapping(path ="/del", method = RequestMethod.POST)
    @Override
    public @ApiResponseObject Result delFile(@ApiBodyObject @RequestBody@Valid DelFileparam param) {
        int row=cmsFileService.delFirle(Integer.valueOf(param.getFile_id()));
        if(row>0){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("删除附件失败");
        }
    }
    @ApiMethod(description = "附件输出流")
    @RequestMapping(path ="/{file_id}", method = RequestMethod.POST)
    @Override
    public@ApiResponseObject
    Result OutputFile(@ApiBodyObject @RequestBody@Valid OutputFileParam param) {
        CmsFile cmsFile=cmsFileService.find(param.getFile_id());
        OutputStream stream=null;
        String filepath=""+root+"/"+cmsFile.getFilePath();
        if(cmsFile!=null){
            File file=new File(filepath);

            try {
                FileInputStream inputStream = new FileInputStream(file);
                byte[] data = new byte[(int)file.length()];
                int length = inputStream.read(data);
                inputStream.close();
                stream = response.getOutputStream();
                stream.write(data);
                stream.flush();
                stream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return ResultGenerator.genSuccessResult(stream);

        }else {
            response.setStatus(404);
            return ResultGenerator.genFailResult("查询失败", response);
        }
    }
}
