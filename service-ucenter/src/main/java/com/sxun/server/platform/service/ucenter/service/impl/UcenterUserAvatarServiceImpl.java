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
import java.io.FileInputStream;
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

        String url = new String(ucenterUserAvatar.getImgData());
        try {
            FileInputStream fileInputStream = new FileInputStream(url);
            OutputStream outputStream = response.getOutputStream();
            int count = 0;
            byte [] bs = new byte[1024];

            while (true){

                count = fileInputStream.read(bs);
                outputStream.write(bs);
                outputStream.flush();

                if (count < 0){

                    break;
                }

            }
            fileInputStream.close();
            outputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        map.put("success","success");
        return map;
    }
}
