package com.jnshu.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

public class QiNiuUtil {

    private static Logger logger = Logger.getLogger(QiNiuUtil.class);

    private String accessKey;
    private String secretKey;

    private static String bucketName = "jnshu-qianniu";

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String qiNiuUpload(MultipartFile multipartFile) {

        // 构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        String imgUrl = null;
        try {
            // 数据流上传，将 MultipartFile 转为 InputStream，适用于所有的InputStream子类。
            byte[] uploadBytes = multipartFile.getBytes();
            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);

            // 使用 UUID 给图片重命名，并去掉四个“-”
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            // 获取图片名称
            String ext = multipartFile.getOriginalFilename();
            // 获取图片的后缀名称，含“.”
            String suffix = ext.substring(ext.lastIndexOf("."));
            String photoName = name + suffix ;

            // 默认不指定key的情况下，以文件内容的hash值作为文件名
            String key = "image/" + photoName;

            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucketName);

            Response response = uploadManager.put(byteInputStream, key, upToken,null, null);
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            logger.info("上传成功，key值：" + putRet.key);
            logger.info("上传成功，hash值：" + putRet.hash);

            imgUrl="http://q22kto9i4.bkt.clouddn.com/" + key;

            } catch (QiniuException ex) {
                Response r = ex.response;
                logger.error("上传失败，异常1：" + r.toString());
                try {
                    logger.error("上传失败，异常2：" + r.bodyString());
                } catch (QiniuException ex2) {
                    logger.error("上传失败，异常3：" + ex2.getMessage());
                }
            } catch (IOException e) {
            logger.error("上传失败，异常4：" + e.getMessage());
        }
        return imgUrl;
    }
}
