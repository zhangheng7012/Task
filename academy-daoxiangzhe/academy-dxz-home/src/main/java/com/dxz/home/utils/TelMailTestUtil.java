package com.dxz.home.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TelMailTestUtil {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private JedisUtil jedisUtil = new JedisUtil();

    // 第一次获取验证码后，可获取验证码有限次数的时间
    private final static int TIME_LIMIT = 60*5;
    // 短时间已获取验证码有限次数后，限制再次获取验证码的时间
    private final static int LAST_TIME_LIMIT = 60*5;
    // 周期时间可获取验证码的次数
    private final static int MOST_TIMES = 5;
    // 周期时间，获取验证码号的添加标识符
    private final static String TIMES = "_TIMES";
    // 限制再次获取验证码时间，获取验证码号的添加标识符
    private final static String LAST_TIMES = "_LAST_TIMES";

    // 检查获取验证码次数是否符合要求
    public boolean timesTest(String telMail){

        // 周期时间的获取验证码号标识符
        String telMailTimes = telMail + TIMES;
        // 限制再次获取验证码时间的标识符
        String telMailLastTimes = telMail + LAST_TIMES;

        // 表示获取验证码超过次数后，已经过限制时间 LAST_TIME_LIMIT
        if(jedisUtil.ttl(telMailLastTimes) == -2){
            // 周期时间获取验证码号的注册次数
            Long times = jedisUtil.incr(telMailTimes);
            log.info("获取验证码次数为："+ times +" 次");
            // 第一次获取验证码，设置过期时间，分钟
            if(times == 1){
                jedisUtil.expire(telMailTimes,TIME_LIMIT);
                return true;
            }
            // 周期时间获取验证码号，还未过期
            if(jedisUtil.ttl(telMailTimes) != null && jedisUtil.ttl(telMailTimes) >= 0){
                log.info("距离第一次获取验证码过期时间还有"+ jedisUtil.ttl(telMailTimes) +"秒，可进行获取验证码。");
                // 周期时间内，达到获取验证码次数
                if(times == MOST_TIMES){
                    // 设置再次获取验证码的间隔时间，即此处的过期时间
                    jedisUtil.setex(telMailLastTimes,LAST_TIME_LIMIT,String.valueOf(times));
                    log.info("已获取验证码"+ times +"次，再次获取验证码需要等待。");
                }
                return true;
            }
            // 未达上诉条件，均返回false
            return false;
        }
        log.info("距离获取验证码限时还有"+ jedisUtil.ttl(telMailLastTimes) +"秒，不可获取验证码。");
        // 获取验证码超过次数后，未过限制时间，返回false
        return false;
    }
}
