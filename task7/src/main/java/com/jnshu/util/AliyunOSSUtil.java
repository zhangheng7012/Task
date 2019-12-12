package com.jnshu.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AliyunOSSUtil {

    private static Logger logger = Logger.getLogger(AliyunOSSUtil.class);

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;

    // Bucket用来管理所存储Object的存储空间，详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
    private static String bucketName = "jnshu-7012";

    public AliyunOSSUtil(String endpoint, String accessKeyId, String accessKeySecret) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }

    public String upPhoto(MultipartFile multipartFile){

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 使用 UUID 给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取图片名称
        String ext = multipartFile.getOriginalFilename();
        // 获取图片的前缀名称 加 当前时间戳
//        String prefix = ext.substring(0, ext.lastIndexOf(".")) + "_" + System.currentTimeMillis();
        // 获取图片的后缀名称，含“.”
        String suffix = ext.substring(ext.lastIndexOf("."));
        String photoName = name + suffix ;

        try {

            // 判断Bucket是否存在。
            if (ossClient.doesBucketExist(bucketName)) {
                logger.info("您已经创建Bucket：" + bucketName + "。");
            } else {
                logger.info("您的Bucket不存在，创建Bucket：" + bucketName + "。");
                // 创建Bucket。
                ossClient.createBucket(bucketName);
            }

            // Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件。详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
            // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
            // oss中没有文件夹的概念，如果想传到对应的目录下，可以在object名称前添加对应的路径。
            String fileName = "minImage/" + photoName;

            // 创建PutObjectRequest对象，构造上传请求。
            // <yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
            // 数据流上传，将 MultipartFile 转为 InputStream，适用于所有的InputStream子类。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,fileName,new ByteArrayInputStream(multipartFile.getBytes()));

            // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
            ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);

            // 这里也能设置content-disposition，但是不知道设置为什么可以取消强制下载。
//            metadata.setContentDisposition();
            // 指定Content-Type
            // metadata.setContentType("application/octet-stream");
            metadata.setContentType("image");
            putObjectRequest.setMetadata(metadata);
            // 上传文件
            ossClient.putObject(putObjectRequest);

            // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
            // 数据流上传，将 MultipartFile 转为 InputStream，适用于所有的InputStream子类。
//            ossClient.putObject(bucketName,fileName,new ByteArrayInputStream(multipartFile.getBytes()));

            // 关闭OSSClient。
            ossClient.shutdown();
            // 添加图片处理样式有两种方式，此处是添加样式对应的代码（等比缩小为30%），还可以添加样式的名称，如“ ?x-oss-process=style/30suoluetu ”
            String url = "https://jnshu-7012.oss-cn-beijing.aliyuncs.com/" + fileName + "?x-oss-process=image/auto-orient,1/resize,p_30/quality,q_90";
//            String url2 = "https://jnshu-7012.oss-cn-beijing.aliyuncs.com/" + fileName + "?x-oss-process=style/30suoluetu";
            return url;

        } catch (OSSException oe) {
            logger.error("出现异常1，异常为：" + oe.getMessage());
        } catch (ClientException ce) {
            logger.error("出现异常2，异常为：" + ce.getMessage());
        } catch (Exception e) {
            logger.error("出现异常3，异常为：" + e.getMessage());
        }
        return null;
    }
}
