package com.jnshu.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SendMailUtil {

    private static Logger logger = Logger.getLogger(SendMailUtil.class);

    private String url;
    private String apiKey;
    private String apiUser;

    private JedisUtil jedisUtil = new JedisUtil();

    public SendMailUtil(String url, String apiKey, String apiUser) {
        this.url = url;
        this.apiKey = apiKey;
        this.apiUser = apiUser;
    }

    public boolean sendMailCode(String mail) {
        // 随机4位验证码
        int code = (int) ((Math.random() * 8999) + 1000);

        // DefaultHttpClient()已过时，替换如下
        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httpost = new HttpPost(url);

        List params = new ArrayList();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        // 发件人地址，为了更高的送达率，建议from域名后缀与发信域名一致。
        params.add(new BasicNameValuePair("from", "service@sendcloud.im"));
        // 发件人名称
        params.add(new BasicNameValuePair("fromName", ""));
        // 收件人地址，多个地址使用';'分隔
        params.add(new BasicNameValuePair("to", mail));
        // 标题，不能为空
        params.add(new BasicNameValuePair("subject", "来自jnshu的验证码！"));
        // 邮件的内容，邮件格式为 text/html
        params.add(new BasicNameValuePair("html", "您的验证码为：" + code + "，请及时注册。"));

        try {
            httpost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            // 请求
            HttpResponse response = httpclient.execute(httpost);
            // 处理响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回

                // 将手机号为key，验证码为value，存储缓存，设置过期时间2分钟
                String redis = jedisUtil.setex(mail,120,String.valueOf(code));
                if("OK".equals(redis)){
                    logger.info("邮箱、验证码缓存成功");
                }
                logger.info("验证码：" + code);

                // 读取xml文档
                String result = EntityUtils.toString(response.getEntity());
                logger.info("验证结果为：" + result);
                return true;
            } else {
                logger.error("出现错误！error！");
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("出现异常1，异常为：" + e.getMessage());
        } catch (ClientProtocolException e) {
            logger.error("出现异常2，异常为：" + e.getMessage());
        } catch (IOException e) {
            logger.error("出现异常3，异常为：" + e.getMessage());
        }
        httpost.releaseConnection();
        return false;
    }
}
