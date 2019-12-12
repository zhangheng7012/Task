package com.jnshu.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

//import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class SMSUtil {

    private static Logger logger = Logger.getLogger(SMSUtil.class);

    private String serverIP;
    private String serverPort;
    private String accountSid;
    private String accountToken;
    private String appId;

//    private CCPRestSmsSDK restAPI =null;
    private JedisUtil jedisUtil = new JedisUtil();

    // set方法注入
    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    // 构造方法注入
//    public SMSUtil(String serverIP, String serverPort, String accountSid, String accountToken, String appId){
//        this.serverIP = serverIP;
//        this.serverPort = serverPort;
//        this.accountSid = accountSid;
//        this.accountToken = accountToken;
//        this.appId = appId;
//    }

//    public void init(){
//        //初始化SDK
//        restAPI = new CCPRestSmsSDK();
//        // 初始化服务器地址和端口，格式如下，服务器地址不需要写https:
//        restAPI.init(serverIP, serverPort);
//        // 初始化主帐号和主帐号TOKEN
//        restAPI.setAccount(accountSid, accountToken);
//        // 初始化应用ID
//        restAPI.setAppId(appId);
//    }

    public boolean sendTelCode(String tel) {

        // 获取第三方要求格式的当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(new Date());
        // 使用Base64编码（开发者主账号ACCOUNT SID + 冒号 + 时间戳）其中账户Id 根据url的验证级别对应主账户
        String Authorization = accountSid + ":" + date;

        // 随机四位验证码，直接 String.valueOf() 会有小数，不是整数
        int code = (int) ((Math.random() * 8999) + 1000);

        // 使用MD5加密（账户Id + 账户授权令牌 + 时间戳）
        // 其中账户Id和账户授权令牌根据url的验证级别对应主账户，toUpperCase()将字母转为大写字母
        String SigParameter = DigestUtils.md5DigestAsHex((accountSid +
                accountToken + date).getBytes()).toUpperCase();
        // 业务URL格式：/2013-12-26/Accounts/{accountSid}/SMS/TemplateSMS?sig={SigParameter}
        String URL = "https://app.cloopen.com:8883/2013-12-26/Accounts/"+ accountSid +"/SMS/TemplateSMS?sig=";

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
        msg.put("datas", new String[]{'\t' + Integer.toString(code), '\t' + "2"});

        //组装并发送
        HttpEntity<JSONObject> request = new HttpEntity<>(msg, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(
                URL + SigParameter, request, String.class);

        logger.info("响应为：" + response.getStatusCode() + '\n' + response.getBody());
        logger.info(String.valueOf(response.getStatusCode()) + '\n' + SigParameter);
        // 请求状态码，取值000000（成功），返回验证码
        if (response.getStatusCode().is2xxSuccessful() && response.getBody().contains("000000")) {
            // 将手机号为key，验证码为value，存储缓存，设置过期时间2分钟
            String result = jedisUtil.setex(tel, 120, String.valueOf(code));
            if ("OK".equals(result)) {
                logger.info("手机号、验证码缓存成功");
            }
            return true;
        } else {
            logger.info("验证码发送失败");
            return false;
        }
    }

//    public boolean sendTelCode(String tel){
//
//        HashMap<String, Object> result = null;
//        String templateId="1";
//        // 随机四位验证码，直接 String.valueOf() 会有小数，不是整数
//        int code = (int)((Math.random() * 8999) + 1000);
//
//        String[] content=new String[]{String.valueOf(code),"2"};
//
//        // 调用发送模板短信的接口发送短信
//        // 测试模板的内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入
//        // 参数分别是：手机号（多个手机号间隔“,”），模板id，模板内容1（验证码）、2（过期时间）
//        // 返回是data（templateSMS创建时间，smsMessageSid）、statusCode状态码
//        // 如果发送不成功，还会返回statusMsg状态码对应的错误信息
//        result = restAPI.sendTemplateSMS(tel,templateId ,content);
//        logger.info("短信验证发送结果 = " + result);
//
//        // statusCode状态码为000000，即为发送成功
//        if("000000".equals(result.get("statusCode"))){
//
//            // 将手机号为key，验证码为value，存储缓存，设置过期时间2分钟
//            String redis = jedisUtil.setex(tel,120,String.valueOf(code));
//            if("OK".equals(redis)){
//                logger.info("手机号、验证码缓存成功");
//            }
//            logger.info("验证码：" + code);
//
//            // 正常返回输出data包体信息（map）
//            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
//            // 获取data中的key
//            Set<String> keySet = data.keySet();
//            // 遍历key，通过key得到对应的值，输出
//            for(String key:keySet){
//                Object object = data.get(key);
//                logger.info(key +" = "+object);
//            }
//            return true;
//        }else{
//            //异常返回输出错误码和错误信息
//            logger.info("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
//        }
//        return false;
//    }

}
