package com.dxz.home.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class TimeUtil {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    // 获取 昨天零点零分零秒 时间戳
    public Long yesterdayZeroTime(){
        Calendar cal = Calendar.getInstance();
        // 获取年，如果在clear()方法后获取，将获取1970年
        int year = cal.get(Calendar.YEAR);
        // 获取月份，clear()之后，再获取月份就是0，即一月
        int month = cal.get(Calendar.MONTH);
        // 获取昨天天数，clear()之后，再获取天数就是1，即一号
        int day = cal.get(Calendar.DAY_OF_MONTH) -1;
        // 在使用set方法之前，必须先clear一下，否则很多信息会继承自系统当前时间
        cal.clear();
        cal.set(Calendar.YEAR,year);//控制年
        // 控制月份，0表示1月份，这里设置为当月
        cal.set(Calendar.MONTH,month);
        // 控制天，这里设置为昨天的天数，1号也可以设置成上个月末
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);//控制时
        cal.set(Calendar.MINUTE, 0);//控制分
        cal.set(Calendar.SECOND, 0);//控制秒
        cal.set(Calendar.MILLISECOND, 0);//控制毫秒
        Long yesterdayTime = cal.getTimeInMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("昨天零点零分零秒 时间戳：{}ms，{}",yesterdayTime,sdf.format(cal.getTime()));
        return yesterdayTime;
    }

    // 获取 今天零点零分零秒 时间戳
    public Long todayZeroTime(){
        Calendar ca2 = Calendar.getInstance();
        int year2 = ca2.get(Calendar.YEAR);
        int month2 = ca2.get(Calendar.MONTH);
        int day2 = ca2.get(Calendar.DAY_OF_MONTH);
        ca2.clear();
        ca2.set(Calendar.YEAR,year2);
        ca2.set(Calendar.MONTH,month2);
        // 获取当天天数
        ca2.set(Calendar.DAY_OF_MONTH, day2);
        ca2.set(Calendar.HOUR_OF_DAY, 0);
        ca2.set(Calendar.MINUTE, 0);
        ca2.set(Calendar.SECOND, 0);
        ca2.set(Calendar.MILLISECOND, 0);
        Long todayTime = ca2.getTimeInMillis();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("今天零点零分零秒 时间戳：{}ms，{}",todayTime,sdf2.format(ca2.getTime()));
        return todayTime;
    }

    // 获取 上个月一号零点零分零秒 时间戳
    public Long oldMonthZeroTime(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        // 0表示1月份，这里设置为上个月
        int month = cal.get(Calendar.MONTH) -1;
        cal.clear();
        cal.set(Calendar.YEAR,year);
        // 控制月份
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH, 1 );
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("上个月一号零点零分零秒 时间戳：{}ms，{}",cal.getTimeInMillis(),sdf.format(cal.getTime()));
        return cal.getTimeInMillis();
    }

    // 获取 当月一号零点零分零秒 时间戳
    public Long nowMonthZeroTime(){
        Calendar ca2 = Calendar.getInstance();
        int year2 = ca2.get(Calendar.YEAR);
        int month2 = ca2.get(Calendar.MONTH);
        ca2.clear();
        ca2.set(Calendar.YEAR,year2);
        // 控制月份，0表示1月份，这里设置为当月
        ca2.set(Calendar.MONTH, month2 );
        ca2.set(Calendar.DAY_OF_MONTH, 1 );
        ca2.set(Calendar.HOUR_OF_DAY, 0);
        ca2.set(Calendar.MINUTE, 0);
        ca2.set(Calendar.SECOND, 0);
        ca2.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("当月一号零点零分零秒 时间戳：{}ms，{}",ca2.getTimeInMillis(),sdf.format(ca2.getTime()));
        return ca2.getTimeInMillis();
    }
}
