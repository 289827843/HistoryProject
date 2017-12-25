package com.sxun.server.platform.service.ucenter.service.impl;

import com.sxun.server.common.web.core.AbstractService;
import com.sxun.server.platform.service.ucenter.dao.UcenterUserAvatarMapper;
import com.sxun.server.platform.service.ucenter.model.UcenterUserAvatar;
import com.sxun.server.platform.service.ucenter.service.UcenterUserAvatarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class UcenterUserAvatarServiceImpl extends AbstractService<UcenterUserAvatar> implements UcenterUserAvatarService {


    @Resource
    private UcenterUserAvatarMapper userAvatarMapper;

    private Map<String,Object> map = new HashMap<String, Object>();
    @Override
    public Map<String, Object> outPutAvatar(HttpServletResponse response, Integer integer) {


          UcenterUserAvatar ucenterUserAvatar = this.findById(integer);

          if (ucenterUserAvatar == null){

              map.put("fail","用戶頭像ID不正確");
              return map;

          }

        BufferedImage  bufferedImage = null;
        OutputStream   outputStream  = null;
        String url = new String(ucenterUserAvatar.getImgData());

        try {

            bufferedImage = ImageIO.read(new URL(url));
            outputStream =  new FileOutputStream(new File("D:\\image"));
            ImageIO.write(bufferedImage,  "jpg", outputStream);

        }catch (Exception e){
             e.printStackTrace();
        }finally {
            try {
                if(bufferedImage != null)
                {
                    bufferedImage.flush();
                }
                if(outputStream != null){
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (Exception e) {
               e.printStackTrace();
            }

        }



       map.put("success",outputStream);

        return map;
    }
}
