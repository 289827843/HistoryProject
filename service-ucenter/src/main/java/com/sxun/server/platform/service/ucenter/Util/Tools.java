package com.sxun.server.platform.service.ucenter.Util;

import java.util.Random;
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

    //随机密码

    public static String getRandomPwd(Integer length) {
        int i;
        int count = 0;
        char[] str = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','J', 'K', 'L', 'M', 'N',  'P', 'Q', 'R','S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i','j', 'k', 'm', 'n',  'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while(count < length){
            i = Math.abs(r.nextInt(str.length));
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count ++;
            }
        }
        return pwd.toString();

    }


}
