package com.sxun.server.platform.service.ucenter.util;

import com.alibaba.fastjson.JSON;
import com.sxun.server.common.remote.session.LoginInfo;
import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

/**
 * Created by leizheng on 12/16/2017.
 */
public class SessionUtil {
    public static LoginInfo getLoginInfo(String auth_str){
        if (StringUtils.isEmpty(auth_str)){
            return null;
        }else{
            return JSON.parseObject(new String(Base64.decodeBase64(auth_str)).replace("token ",""),LoginInfo.class);
        }
    }
}
