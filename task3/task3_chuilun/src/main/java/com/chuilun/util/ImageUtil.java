package com.chuilun.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ImageUtil {

    // 上传图片，尝试后发现视频也可以上传
    public static String upload(MultipartFile pictureFile) throws IOException {
        // 装配图片地址
        String imgPath = null;
        // 判断pictureFile不为空，则上传图片
        if (pictureFile != null && !pictureFile.isEmpty()) {
            // 使用 UUID 给图片重命名，并去掉四个“-”
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            // 获取图片的后缀名称
            String ext = pictureFile.getOriginalFilename();

/*            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=user.getFile().getContentType();*/

            // 设置图片上传路径，这里是获得物理路径的 webapp 所在路径，并设置
/*            String url = request.getSession().getServletContext()
                    .getRealPath("/upload");*/

            // 设置图片上传路径，我是将图片存在本地的文件夹中
            String url = "/task3_image";
            // 检验文件夹是否存在，不存在则创建一个文件夹，即路径必须正确
            isFolderExists(url);
            // 将重名命后的图片上传到图片上传路径
            pictureFile.transferTo(new File(url, name + "." + ext));
            // 装配后的图片地址，包含图片名称、后缀，若使用nginx代理，则不加虚拟路径
            imgPath = name + "." + ext;
        }
        return imgPath;
    }

    // 验证文件夹是否存在，不存在则创建一个文件夹，即路径必须正确
    public static boolean isFolderExists(String strFolder) {
        File file = new File(strFolder);
        if (!file.exists()) {
            if (file.mkdir()) {
                return true;
            } else {
                return false;
            }
        }
        System.out.println("-----------------文件上传路径：" + strFolder);
        return true;
    }
}
