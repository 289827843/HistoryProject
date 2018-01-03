package com.sxun.server.platform.service.cms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cms_file")
public class CmsFile {
    @Id
    @Column(name = "file_id")
    private String fileId;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件后缀
     */
    @Column(name = "file_ext")
    private String fileExt;

    /**
     * @return file_id
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * @param fileId
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     * @return file_path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取文件名
     *
     * @return file_name - 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名
     *
     * @param fileName 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取文件后缀
     *
     * @return file_ext - 文件后缀
     */
    public String getFileExt() {
        return fileExt;
    }

    /**
     * 设置文件后缀
     *
     * @param fileExt 文件后缀
     */
    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }
}