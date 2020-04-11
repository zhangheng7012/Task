package com.dxz.home;

import com.alibaba.fastjson.JSONObject;
import com.dxz.home.dao.CourseMapper;
import com.dxz.home.dao.SignMapper;
import com.dxz.home.dao.UserMapper;
import com.dxz.home.pojo.Course;
import com.dxz.home.pojo.Sign;
import com.dxz.home.pojo.SignExample;
import com.dxz.home.pojo.User;
import com.dxz.home.result.CodeInfo;
import com.dxz.home.result.Result;
import com.dxz.home.service.CourseService;
import com.dxz.home.service.UserService;
import com.dxz.home.utils.*;
import com.mysql.jdbc.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeApplicationTests {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CourseMapper courseMapper;

    @Autowired
    TimeUtil timeUtil;

    @Autowired
    DesUtil desUtil;

    @Test
    public void co2nto3s() {
        User course = new User();
        course.setSort(2);
//        course.setStatus(2);
        List<User> courses = userMapper.findUserListSearch(course);
        List<User> courses2 = userMapper.findUserListSearch(course);
        for (User user : courses2) {
            if(user.getStatus() == 2 || user.getStatus() == 3 || user.getStatus() == 4){
                courses.remove(user);
            }
        }
        log.info("查询的列表 {} 长度：{}",courses,courses.size());// 长度为4,移除失败
        log.info("查询的列表2 {} 长度：{}",courses2,courses2.size());// 长度为4
    }

    @Test
    public void co2ntos() {
        List<Course> connections = null;
        System.out.println("haha: "+connections.size());// 空指针异常
        for (Course connection : connections) {
            System.out.println("haha: "+connection);// 空指针异常
        }

        List<Course> connections2 = new ArrayList<>();
        System.out.println("haha: "+connections2.size());// haha: 0
        for (Course connection : connections2) {
            System.out.println("enen: "+connection);// 没有输出
        }

        Course course = new Course();
        course.setSort(1);
        course.setStatus(1);
        List<Course> courses = courseMapper.findCourseBanner(course);
        log.info("查询的banner视频列表长度：{}",courses.size());// 长度为0
    }

    @Test
    public void contos() {

        Course course = courseService.findCourseById(1l);
        System.out.println("haha: "+course);
//        Course course = new Course();
//        course.setGrade(5);
//        course.setSubject(2);
//        // 视频状态，1为上架
//        course.setStatus(1);
//        List<Course> videos = courseService.findCourseListSearch(course);
//        System.out.println("haha: "+videos);

//        List<Course> banners = courseService.findCourseBanner();
//        System.out.println("haha: "+banners);

//        List<Course> courses = courseService.courseCollectList(2L);
//        System.out.println("haha: "+courses);
//        List<Course> courses2 = courseService.courseCollectList(3L);
//        System.out.println("haha222: "+courses2);
    }

    @Test
    public void decodeUserIo(){
        String code = "021A32D90sy9Wz1f6EA90iR0D90A32DF";
        String iv = "5QGf c6HiHqqocWu2NR7kg==";
        String encryptedData = "3j7qT/h5mG/17G4DWCOMOo/gZBTvkXrEq9kKe55r2HY4UqTyJVZApZV8HPKzubRxHx87hc3qvJwwuW6hcOdVvYQUyH ySypi6 3xUs V vajgHceFEbNSszkRZT1/HWzBEuE9LCgegmVv9idX/EKQI574HrfJ2ykCyjwI/IGhfO1rWegIGz2ubSepxXCYBPCCEEZkcyr7Mt7FMxVIGBuQyiYSGlgydNe4GiW/R2bX3qKa73CHL6jYkaa5z WR d8PY5eIAmUNavb3O3jCe1c0EFd40OE4fCK/PTwK/lxlk CRxvfDlZNg2 BIv7bVjag7qCKz2IvAWMkc1D8bjaWj78g16kslbZaO3k96j6lVZhfDRNOS 4AVtEfGgqUCbzBxhh/c3fAgBuWKs9qPhsP JPYgkWZRoVlkS5E h AMn7fHbMo2959dYU3FsbCLr0lzbZIz1R/GJIwZqAZieY2basvUWT496kbygZESikYHgc=";

        String code1 = "021A32D90sy9Wz1f6EA90iR0D90A32DF";
        String iv2 = "5QGf+c6HiHqqocWu2NR7kg==";
        String encryptedData2 = "3j7qT/h5mG/17G4DWCOMOo/gZBTvkXrEq9kKe55r2HY4UqTyJVZApZV8HPKzubRxHx87hc3qvJwwuW6hcOdVvYQUyH+ySypi6+3xUs+V+vajgHceFEbNSszkRZT1/HWzBEuE9LCgegmVv9idX/EKQI574HrfJ2ykCyjwI/IGhfO1rWegIGz2ubSepxXCYBPCCEEZkcyr7Mt7FMxVIGBuQyiYSGlgydNe4GiW/R2bX3qKa73CHL6jYkaa5z+WR+d8PY5eIAmUNavb3O3jCe1c0EFd40OE4fCK/PTwK/lxlk+CRxvfDlZNg2+BIv7bVjag7qCKz2IvAWMkc1D8bjaWj78g16kslbZaO3k96j6lVZhfDRNOS+4AVtEfGgqUCbzBxhh/c3fAgBuWKs9qPhsP+JPYgkWZRoVlkS5E+h+AMn7fHbMo2959dYU3FsbCLr0lzbZIz1R/GJIwZqAZieY2basvUWT496kbygZESikYHgc=";

        String w = iv.replaceAll(" ","%20");//5QGf%20c6HiHqqocWu2NR7kg==
        String w2 = iv.replaceAll(" ","+");//5QGf+c6HiHqqocWu2NR7kg==
        System.out.println("嗯嗯："+w+":嗯嗯："+w2);
        System.out.println(iv2.equals(w)+":嗯嗯："+iv2.equals(w2));// false:嗯嗯：true
    }


    //1.微信登录
    @Test
    public void decodeUserInfo() throws Exception {

        String AppId ="wx811ff5e82f15faa8";
        String AppSecret="a118211ab3e5e2c6aa4701d923ef3b2f";
        String grant_type="authorization_code";

        String code = "0614WE661t2gyR1JIc761daP6614WE65";
        String iv = "AciCMn6kmXACPQJBKTNfwQ==";
        String encryptedData = "2hm2guppUwRyr7OOvmUaWONW9Hvsk6oeBuUIf/llDn3CygmqgInV79nqD7PeS++s6CLF63lYInm1wxjb5cD2TDwVfG4zAtPPc8OiJ+F1mmQSHeemQPWdOwmjvJ1cjicY9/VNSAt0crRembXfWz/uiND8iqhKFFUNDIhbBqSquJ4B/Gpl2LybomYmgdVKGjy7buxDC5ZvvObFq3BGw9FbmHoLrYGJtSIiGudRZ9ITICkB6PqyfOyeKHLCudVvfD1IC4C9XtJAptI/ERQfvDTr/oel9v62nKv0vGLR1YC+Ny7R34aemneeQMPYMycNpRqKbH4nX3pOV1TxYCqNRf66ID1YPtIWn6Y/2Qf8MWSsZMxNBGsagohUtwmPQP1GLuwEcumwHEjCkesrQOpy4E1ip+P3JeO6Q/kG873uX3npXoDx3qInwmLVbSKxHWPtPCcBC1EgKafJjrqaXn+DyYBVTmGzklfPqCpGNg+T2NIm6kw=";

        log.error("请求登录: "+code+iv+encryptedData);
        JSONObject object = new JSONObject();
        String time_in_format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分").format(new Date(System.currentTimeMillis()));

        String params = "appid=" + AppId + "&secret=" + AppSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        String jscode2session = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);

        JSONObject json = JSONObject.parseObject(jscode2session);
        String openId = (String) json.get("openid");
        log.error("解析出的openId: "+openId);
        //若student.status=0则返回被冻结
        /*if (! studentService.checkStudentStatus(openId)){
            log.error(openId+",该用户已被冻结");
            object.put("code",2);
            object.put("message","该用户已被冻结");
        }*/


//        if (studentService.verifyOpenId(openId)){
//            log.error("该用户已注册:"+openId);
//            object.put("code","1");
//            object.put("message","请求成功,用户登录成功");
            object.put("token",desUtil.encrypt(openId+"/"+time_in_format));
//        }else {
        //注册
        log.error("正在注册用户");
        String session_key = (String) json.get("session_key");
        log.error("解析出的session_key: "+session_key);
        //解密
        String userInfo = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
        log.error("用户数据-直接解密: "+userInfo);

        JSONObject userInfoJSON = JSONObject.parseObject(userInfo);
        log.error("用户数据: "+userInfoJSON);
//            if (studentService.createStudent(userInfoJSON)) {
//                object.put("code","1");
//                object.put("message","请求成功,用户注册成功");
//                //签发token
//                object.put("token",desUtil.encrypt(openId+"/"+time_in_format));
//            }else {
//                object.put("code","0");
//                object.put("message","用户注册失败");
//            }
//        }
        System.out.println("JSONObject: " + object);
    }

    @Test
    public void contextos() {
        System.out.println(timeUtil.yesterdayZeroTime());
        System.out.println(timeUtil.todayZeroTime());
        System.out.println(timeUtil.oldMonthZeroTime());
        System.out.println(timeUtil.nowMonthZeroTime());
    }

    @Test
    public void contetos() {
        long ai = 2;
        int a = 1;
        for (Long i = 2L; i < 6; i++) {
            System.out.println(i+ai);
        }
    }
    @Test
    public void conttos() {
        Long yesterdayTime = 1582992000000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("今天零点零分零秒 时间戳："+"今天零点："+sdf.format(yesterdayTime));
        System.out.println(timeUtil.todayZeroTime());
    }


    @Resource
    SignMapper signMapper;

    @Test
    public void conteos() {
        Long todayTime = 1580486400000L;
        Long yesterdayTime = 1580400000000L;
        Sign sign = new Sign();
        sign.setUserId(5L);
        sign.setMinSignTime(yesterdayTime);
        sign.setMaxSignTime(todayTime -1);
        // 根据用户id、时间戳范围查询，左右全闭，yesterdayTime =< x =< todayTime -1
        List<Sign> signs = signMapper.findSignTimeList(sign);
        System.out.println(todayTime -1);
        System.out.println(signs);
        if(signs.size() > 0){
            // 查看用户当日是否签到，未签到为0，已签到为1
            log.info("昨天是否签到：{}",true);
        }else {
            log.info("昨天是否签到：{}",false);
        }
    }

    @Test
    public void contextLos() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);//控制时
        cal.set(Calendar.MINUTE, 0);//控制分
        cal.set(Calendar.SECOND, 0);//控制秒
        cal.set(Calendar.MILLISECOND, 0);//控制毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("今天零点零分零秒 时间戳："+cal.getTimeInMillis()+"今天零点："+sdf.format(cal.getTime()));

        Long time = System.currentTimeMillis();  //当前时间的时间戳
        long zero = time/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
        System.out.println("今天零点零分零秒："+new Timestamp(zero));//今天零点零分零秒
        System.out.println("今天零点零分零秒 时间戳："+zero);

        System.out.println("当前时间的时间戳："+time);

        long now = System.currentTimeMillis() / 1000l;
        long daySecond = 60 * 60 * 24;
        long dayTime = now - (now + 8 * 3600) % daySecond;
        System.out.println("今天零点零分零秒 时间戳："+dayTime);

        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));    //获取东八区时间
        int year = c.get(Calendar.YEAR);    //获取年
        int month = c.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
        int day = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        int first = c.getActualMinimum(c.DAY_OF_MONTH);    //获取本月最小天数
        int last = c.getActualMaximum(c.DAY_OF_MONTH);    //获取本月最大天数
        int time1 = c.get(Calendar.HOUR_OF_DAY);       //获取当前小时
        int min = c.get(Calendar.MINUTE);          //获取当前分钟
        int xx = c.get(Calendar.SECOND);          //获取当前秒

        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String curDate = s.format(c.getTime());  //当前日期
        System.out.println("当前时间："+year + "-" + month + "-"+ day + " "+time1 + ":" + min +":" + xx);
        System.out.println("第一天和最后天：" + first +"," + last);

        System.out.println("当前日期curDate====：" + curDate);
    }

    @Test
    public void sa() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);    //获取年

        System.out.println(cal.get(Calendar.MONTH));// clear()之前，获取的就是当前月份，但是数字是减一的
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));// clear()之前，获取的就是当前天数

        // 在使用set方法之前，必须先clear一下，否则很多信息会继承自系统当前时间
        cal.clear();
        cal.set(Calendar.YEAR,year);//控制年

        System.out.println(cal.get(Calendar.MONTH));// clear()之后，再获取月份就是0，即一月
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));// clear()之后，再获取天数就是1，即一号

        // 控制月份，0表示1月份，这里设置为上个月
        cal.set(Calendar.MONTH,cal.get(Calendar.MONTH));
        // 控制天，这里设置为1号
        cal.set(Calendar.DAY_OF_MONTH, 1 );
        cal.set(Calendar.HOUR_OF_DAY, 0);//控制时
        cal.set(Calendar.MINUTE, 0);//控制分
        cal.set(Calendar.SECOND, 0);//控制秒
        cal.set(Calendar.MILLISECOND, 0);//控制毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("上个月一号零点零分零秒 时间戳："+cal.getTimeInMillis()+"上个月一号零点："+sdf.format(cal.getTime()));

        Calendar ca2 = Calendar.getInstance();
        int year2 = ca2.get(Calendar.YEAR);    //获取年

        System.out.println(ca2.get(Calendar.MONTH));// clear()之前，获取的就是当前月份，但是数字是减一的
        System.out.println(ca2.get(Calendar.DAY_OF_MONTH));// clear()之前，获取的就是当前天数

        // 在使用set方法之前，必须先clear一下，否则很多信息会继承自系统当前时间
        ca2.clear();
        ca2.set(Calendar.YEAR,year2);//控制年

        System.out.println(ca2.get(Calendar.MONTH));// clear()之后，再获取月份就是0，即一月
        System.out.println(ca2.get(Calendar.DAY_OF_MONTH));// clear()之后，再获取天数就是1，即一号

        // 控制月份，0表示1月份，这里设置为当月
        ca2.set(Calendar.MONTH,ca2.get(Calendar.MONTH) + 1);
        // 控制天，这里设置为1号
        ca2.set(Calendar.DAY_OF_MONTH, 1 );
        ca2.set(Calendar.HOUR_OF_DAY, 0);//控制时
        ca2.set(Calendar.MINUTE, 0);//控制分
        ca2.set(Calendar.SECOND, 0);//控制秒
        ca2.set(Calendar.MILLISECOND, 0);//控制毫秒
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当月一号零点零分零秒 时间戳："+ca2.getTimeInMillis()+"当月一号零点："+sdf2.format(ca2.getTime()));
    }

    @Test
    public void s() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        // 获取年，如果在clear()方法后获取，将获取1970年
        int year = cal.get(Calendar.YEAR);
        System.out.println(year);
        int month = cal.get(Calendar.MONTH);   //获取月份，0表示1月份
        System.out.println(month);
        int day = cal.get(Calendar.DAY_OF_MONTH) -1;    //获取昨天天数
        System.out.println(day);
        // 在使用set方法之前，必须先clear一下，否则很多信息会继承自系统当前时间
        cal.clear();
        cal.set(Calendar.YEAR,year);//控制年
        // 控制月份，0表示1月份，这里设置为当月
        cal.set(Calendar.MONTH,month);
        // 控制天，这里设置为昨天的天数，1号也可以设置成上个月末
        cal.set(Calendar.DAY_OF_MONTH, day );
        cal.set(Calendar.HOUR_OF_DAY, 0);//控制时
        cal.set(Calendar.MINUTE, 0);//控制分
        cal.set(Calendar.SECOND, 0);//控制秒
        cal.set(Calendar.MILLISECOND, 0);//控制毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("昨天零点零分零秒 时间戳："+cal.getTimeInMillis()+"==??"+cal.getTime()+"昨天零点："+sdf.format(cal.getTime()));

        Calendar ca2 = Calendar.getInstance();
        // 获取年，如果在clear()方法后获取，将获取1970年
        int year2 = ca2.get(Calendar.YEAR);
        System.out.println(year2);
        int month2 = ca2.get(Calendar.MONTH);   //获取月份，0表示1月份
        System.out.println(month2);
        int day2 = ca2.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        System.out.println(day2);
        // 在使用set方法之前，必须先clear一下，否则很多信息会继承自系统当前时间
        ca2.clear();
        ca2.set(Calendar.YEAR,year2);//控制年
        ca2.set(Calendar.MONTH,month2);//控制月份，0表示1月份
        ca2.set(Calendar.DAY_OF_MONTH, day2 );//控制天
        ca2.set(Calendar.HOUR_OF_DAY, 0);//控制时
        ca2.set(Calendar.MINUTE, 0);//控制分
        ca2.set(Calendar.SECOND, 0);//控制秒
        ca2.set(Calendar.MILLISECOND, 0);//控制毫秒
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("今天零点零分零秒 时间戳："+ca2.getTimeInMillis()+"==??"+ca2.getTime()+"今天零点："+sdf2.format(ca2.getTime()));
    }

    // 可能是 容联 放假，测试用的短信通道无法使用
    @Autowired
    private SMSUtil smsUtil;
    @Test
    public void testSMSUtils() {
        String phone="13068791270";
        boolean i = smsUtil.sendTelCode(phone);
        if(i){
            System.out.println("哈哈哈哈哈");
        }else {
            System.out.println("ooooooo");
        }
    }

    @Test
    public void ll() {
        Long a = 10L;
        Long b = 20L;
        Long c = -20L;

        System.out.println("哈哈哈哈哈"+(a+b));
        System.out.println("ooooooo"+(a+c));
    }

    @Autowired
    private SendMailUtil sendMailUtil;
    @Test
    public void testSendMailUtil() {
        String mail="zhangheng@jnshu.com";
        boolean i = sendMailUtil.sendMailCode(mail);
        if(i){
            System.out.println("获取邮箱验证码成功");
        }else {
            System.out.println("获取邮箱验证码失败");
        }
    }

    @Test
    public void a() {
        //  Long.ValueOf(String); 返回Long包装类
        //  Long.parseLong(String); 返回long基本数据类型
        String phone="13068791270";
        Long phone2=Long.valueOf(phone);
        System.out.println("获取:"+phone2);

    }

    @Test
    public void checkFileType() {
        String fileType = "";
        // 获取图片名称
        String fileName = "shigdiabas.jPG";
        int i = fileName.lastIndexOf(".");
        System.out.println(i);
        if (i > 0) {
            fileType = fileName.substring(i + 1).toUpperCase();
            System.out.println("类型" + fileType);
        }
        if ("JPG".equals(fileType) || "PNG".equals(fileType) || "JPEG".equals(fileType)){
            System.out.println("成功！");
        }
        System.out.println("失败！");
    }

    @Test
    public void contextLoads() {
        Long id = 1L;
        User user = null;
        try {
            user = userMapper.selectByPrimaryKey(id);
            if(user == null) {
                log.info("用户 {} 不存在", id);
            }
        }catch (Exception e){
            log.error("用户信息获取失败：{}",e.getMessage());
        }
        log.info("用户 {} ", user);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(5L);
//        user.setName("哈哈哈");
        user.setAvatarUrl("sssss");
        user.setGrade(2);

        String phone="2222222222";
        Long phone2=Long.valueOf(phone);
        System.out.println("获取:"+phone2);

        user.setPhone(phone2);

        try {
            Boolean a = userService.updateUser(user);
            if (a) {
                log.info("用户 {} 信息编辑成功", user.getId());
            } else {
                log.error("用户 {} 信息编辑失败", user.getId());
            }
        }catch (Exception e){
            log.error("用户 {} 信息编辑失败：{}", user.getId() ,e.getMessage());
        }
    }

}
