package com.dxz.home.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Component
public class SMSUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${SMS.serverIP}")
    private String serverIP;

    @Value("${SMS.serverPort}")
    private String serverPort;

    @Value("${SMS.accountSid}")
    private String accountSid;

    @Value("${SMS.accountToken}")
    private String accountToken;

    @Value("${SMS.appId}")
    private String appId;

    private JedisUtil jedisUtil = new JedisUtil();

    public boolean sendTelCode(String tel) {

        // 获取第三方要求格式的当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(new Date());
        // 使用Base64编码（开发者主账号ACCOUNT SID + 冒号 + 时间戳）其中账户Id 根据url的验证级别对应主账户
        String Authorization = accountSid + ":" + date;

        // 随机6位验证码，直接 String.valueOf() 会有小数，不是整数
        int code = (int) ((Math.random() * 899999) + 100000);

        // 使用MD5加密（账户Id + 账户授权令牌 + 时间戳）
        // 其中账户Id和账户授权令牌根据url的验证级别对应主账户，toUpperCase()将字母转为大写字母
        String SigParameter = DigestUtils.md5DigestAsHex((accountSid +
                accountToken + date).getBytes()).toUpperCase();

        // 业务URL格式：/2013-12-26/Accounts/{accountSid}/SMS/TemplateSMS?sig={SigParameter}
        String URL = "https://app.cloopen.com:8883/2013-12-26/Accounts/" + accountSid + "/SMS/TemplateSMS?sig=";

        //获取头消息
        HttpHeaders headers = new HttpHeaders();
        //设置请求头信息
        headers.add("Accept", "application/json;charset=utf-8");
        headers.add("Content-Type", "application/json;charset=utf-8");
        headers.add("Authorization", Base64.getEncoder().encodeToString(Authorization.getBytes()));

        //设置请求体信息
        JSONObject msg = new JSONObject();
        // 短信接收端手机号码集合，用英文逗号分开，每批发送的手机号数量不得超过200个
        msg.put("to", tel);
        // 应用Id，官网控制台应用列表获取
        msg.put("appId", appId);

        // 模板Id，官网控制台模板列表获取，测试模板id是1
        // 测试模板的内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入
        msg.put("templateId", "1");
        // 内容数据外层节点，模板如果没有变量，此参数可不传
        msg.put("datas", new String[]{'\t' + Integer.toString(code), '\t' + "5"});

        //组装并发送
        HttpEntity<JSONObject> request = new HttpEntity<>(msg, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(
                URL + SigParameter, request, String.class);

        logger.info("响应为：" + response.getStatusCode() + '\n' + response.getBody());
        logger.info(String.valueOf(response.getStatusCode()) + '\n' + SigParameter);
        // 请求状态码，取值000000（成功），返回验证码
        if (response.getStatusCode().is2xxSuccessful() && response.getBody().contains("000000")) {
            // 将手机号为key，验证码为value，存储缓存，设置过期时间5分钟
            String result = jedisUtil.setex(tel, 300, String.valueOf(code));
            if ("OK".equals(result)) {
                logger.info("手机号、验证码缓存成功");
            }
            logger.info("验证码：" + code);
            return true;
        } else {
            logger.info("验证码发送失败");
            return false;
        }
    }
}