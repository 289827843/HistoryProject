package com.sxun.server.platform.service.ucenter.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ucenter_user_avatar")
public class UcenterUserAvatar {


    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "img_data")
    private byte[] imgData;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] getImgData() {
        return imgData;
    }

    public void setImgData(byte[] imgData) {
        this.imgData = imgData;
    }



}
