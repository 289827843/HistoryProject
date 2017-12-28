package com.sxun.server.platform.service.ucenter.Util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tools {

    public static final int AUTHCODE_LENGTH = 4;		//验证码长度
    public static final int SINGLECODE_WIDTH = 15;	//单个验证码宽度
    public static final int SINGLECODE_HEIGHT = 30;	//单个验证码高度
    public static final int SINGLECODE_GAP = 4;		//单个验证码之间间隔
    public static final int IMG_WIDTH = AUTHCODE_LENGTH * (SINGLECODE_WIDTH + SINGLECODE_GAP);
    public static final int IMG_HEIGHT = SINGLECODE_HEIGHT;


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
    //判断int
    public static boolean booleanInt(Integer integer){

        String pattern = "^[0-9]*$";
        String s = String.valueOf(integer);

        return s.matches(pattern);
    }


    //获取验证码
    public static String getAuthCode() {
        String authCode = "";
        char[] ch = "abcdefghjklmnpqrstuvwxyz0123456789".toCharArray();
        Random r = new Random();
        int index;
        for(int i=0; i<6; i++){
            index = r.nextInt(ch.length);
            authCode += ch[index];
        }

        return authCode;
    }
    //画出的图片
    public static BufferedImage getAuthImg(String authCode) {
        //设置图片的高、宽、类型
        //RGB编码：red、green、blue
        BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_BGR);
        //得到图片上的一个画笔
        Graphics g = img.getGraphics();
        //设置画笔的颜色，用来做背景色
        g.setColor(Color.WHITE);
        //用画笔来填充一个矩形，矩形的左上角坐标，宽，高
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
        //将画笔颜色设置为黑色，用来写字
        g.setColor(Color.RED);
        //设置字体：宋体、不带格式的、字号
        g.setFont(new Font("宋体", Font.PLAIN, SINGLECODE_HEIGHT + 5));

        //输出数字
        char c;
        for(int i = 0; i < authCode.toCharArray().length; i++) {
            //取到对应位置的字符
            c = authCode.charAt(i);
            //画出一个字符串：要画的内容，开始的位置，高度
            g.drawString(c + "", i * (SINGLECODE_WIDTH + SINGLECODE_GAP)+ SINGLECODE_GAP / 2, IMG_HEIGHT);
        }
        Random random = new Random();
        //干扰素
        for(int i = 0; i < 10; i++) {
            int x = random.nextInt(IMG_WIDTH);
            int y = random.nextInt(IMG_HEIGHT);
            int x2 = random.nextInt(IMG_WIDTH);
            int y2 = random.nextInt(IMG_HEIGHT);
            g.drawLine(x, y, x + x2, y + y2);
        }
        return img;
    }





}
