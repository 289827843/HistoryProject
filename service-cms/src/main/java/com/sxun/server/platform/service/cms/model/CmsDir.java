package com.sxun.server.platform.service.cms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cms_dir")
public class CmsDir {
    @Id
    @Column(name = "dir_id")
    private Integer dirId;

    /**
     * 上级目录id  顶级值为-1
     */
    @Column(name = "parent_dir_id")
    private Integer parentDirId;

    /**
     * 归属类别id
     */
    @Column(name = "cata_id")
    private Integer cataId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 目录名称
     */
    private String name;

    /**
     * 是否显示  0=否 1=是
     */
    @Column(name = "is_display")
    private Boolean isDisplay;

    /**
     * 目录所处层级
     */
    private Integer level;

    /**
     * 目录路径，/分隔
方便查询
例如： 
/101/102/103;
leve 为3;
父 id 为102; 

目录移动时需要同时更新所有子目录
     */
    private String path;

    /**
     * @return dir_id
     */
    public Integer getDirId() {
        return dirId;
    }

    /**
     * @param dirId
     */
    public void setDirId(Integer dirId) {
        this.dirId = dirId;
    }

    /**
     * 获取上级目录id  顶级值为-1
     *
     * @return parent_dir_id - 上级目录id  顶级值为-1
     */
    public Integer getParentDirId() {
        return parentDirId;
    }

    /**
     * 设置上级目录id  顶级值为-1
     *
     * @param parentDirId 上级目录id  顶级值为-1
     */
    public void setParentDirId(Integer parentDirId) {
        this.parentDirId = parentDirId;
    }

    /**
     * 获取归属类别id
     *
     * @return cata_id - 归属类别id
     */
    public Integer getCataId() {
        return cataId;
    }

    /**
     * 设置归属类别id
     *
     * @param cataId 归属类别id
     */
    public void setCataId(Integer cataId) {
        this.cataId = cataId;
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
     * 获取目录名称
     *
     * @return name - 目录名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置目录名称
     *
     * @param name 目录名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取是否显示  0=否 1=是
     *
     * @return is_display - 是否显示  0=否 1=是
     */
    public Boolean getIsDisplay() {
        return isDisplay;
    }

    /**
     * 设置是否显示  0=否 1=是
     *
     * @param isDisplay 是否显示  0=否 1=是
     */
    public void setIsDisplay(Boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    /**
     * 获取目录所处层级
     *
     * @return level - 目录所处层级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置目录所处层级
     *
     * @param level 目录所处层级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取目录路径，/分隔
方便查询
例如： 
/101/102/103;
leve 为3;
父 id 为102; 

目录移动时需要同时更新所有子目录
     *
     * @return path - 目录路径，/分隔
方便查询
例如： 
/101/102/103;
leve 为3;
父 id 为102; 

目录移动时需要同时更新所有子目录
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置目录路径，/分隔
方便查询
例如： 
/101/102/103;
leve 为3;
父 id 为102; 

目录移动时需要同时更新所有子目录
     *
     * @param path 目录路径，/分隔
方便查询
例如： 
/101/102/103;
leve 为3;
父 id 为102; 

目录移动时需要同时更新所有子目录
     */
    public void setPath(String path) {
        this.path = path;
    }
}