package com.sxun.server.platform.service.ucenter.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {


    //手机正则
    public static boolean isMobile(String str){

        String regex = "^[a-zA-Z0-9_+-]{11,12}$";
        return str.matches(regex);
    }

    //邮箱正则
    public static boolean isEail(String mail){

        Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    //密码正则
    public static boolean isPwd(String str){

        String reg = "^[a-zA-Z\\d]{6,30}$";
        return str.matches(reg);

    }


}
