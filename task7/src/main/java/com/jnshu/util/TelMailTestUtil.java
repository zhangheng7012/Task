package com.jnshu.util;

public class TelMailTestUtil {

    private JedisUtil jedisUtil = new JedisUtil();

    // 第一次注册后，可注册有限次数的时间
    private final static int TIME_LIMIT = 60*3;
    // 短时间已注册有限次数后，限制再次注册的时间
    private final static int LAST_TIME_LIMIT = 60*5;
    // 周期时间可注册的次数
    private final static int MOST_TIMES = 5;
    // 周期时间，注册号的添加标识符
    private final static String TIMES = "_TIMES";
    // 限制再次注册时间，注册号的添加标识符
    private final static String LAST_TIMES = "_LAST_TIMES";

    // 检查注册次数是否符合要求
    public boolean timesTest(String tel){

        // 周期时间的注册号标识符
        String telTimes = tel + TIMES;
        // 限制再次注册时间的注册号标识符
        String telLastTimes = tel + LAST_TIMES;

        // 表示注册超过次数后，已经过限制时间 LAST_TIME_LIMIT
        if(jedisUtil.ttl(telLastTimes) == -2){
            // 周期时间注册号的注册次数
            Long times = jedisUtil.incr(telTimes);
            System.out.println("该手机号注册次数为："+ times +" 次");
            // 第一次注册，设置过期时间3分钟
            if(times == 1){
                jedisUtil.expire(telTimes,TIME_LIMIT);
                return true;
            }
            // 周期时间注册号，还未过期
            if(jedisUtil.ttl(telTimes) != null && jedisUtil.ttl(telTimes) >= 0){
                System.out.println("距离第一次注册过期时间还有"+ jedisUtil.ttl(telTimes) +"秒，可进行注册。");
                // 周期时间内，达到注册次数
                if(times == MOST_TIMES){
                    // 设置再次注册的间隔时间，即此处的过期时间
                    jedisUtil.setex(telLastTimes,LAST_TIME_LIMIT,String.valueOf(times));
                    System.out.println("该手机号已注册"+ times +"次，再次注册需要等待。");
                }
                return true;
            }
            // 未达上诉条件，均返回false
            return false;
        }
        System.out.println("距离注册限时还有"+ jedisUtil.ttl(telLastTimes) +"秒，不可注册。");
        // 注册超过次数后，未过限制时间，返回false
        return false;
    }
}
