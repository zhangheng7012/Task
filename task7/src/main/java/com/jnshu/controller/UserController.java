package com.jnshu.controller;

import com.jnshu.pojo.User;
import com.jnshu.service.UserService;
import com.jnshu.util.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private SMSUtil smsUtil;
    @Autowired
    private SendMailUtil sendMailUtil;
    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;
    @Autowired
    private QiNiuUtil qiNiuUtil;

    private JedisUtil jedisUtil = new JedisUtil();
    TelMailTestUtil telMailTestUtil = new TelMailTestUtil();

    // 跳转到登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    // 用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request,HttpServletResponse response) {

        String phoneNo = user.getName();
        String psd = user.getPassword();
        //判断是邮箱还是手机号的正则表达式
        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String ph = "^[1][34578]\\d{9}$";
        //手机号登录
        if(phoneNo.matches(ph)) {
            //判断phone、password不为null，且不是空字符串
            if(phoneNo != null && !"".equals(phoneNo) && psd != null && !"".equals(psd)){
                user.setName(null);
                user.setPhone(phoneNo);
                user.setMail(null);
                // 查询，false则不存在
                if (!userService.isUserExist(user)) {
                    model.addAttribute("msg", "用户不存在！");
                    return "login";
                } else {
                    // 将输入密码MD5加密，根据名称查询数据库密码，相同则登录，不同即密码错误
                    String passwordMD5 = DesUtil.encryptMd5(psd);
                    if (passwordMD5.equals(userService.getPasswordBy(user))) {
                        // 查找用户id
                        String userId = userService.findIdBy(user);
                        // 生成token，传入用户id、过期时间，10分钟，单位，毫秒
                        String token = JwtUtil.createJwt(userId,10*60*1000);
                        Cookie tokenCookie = new Cookie("token",token);
                        //保留一天，单位，秒
                        tokenCookie.setMaxAge(60*60*24);
                        tokenCookie.setPath("/");
                        response.addCookie(tokenCookie);
                        logger.info("登录用户token："+ tokenCookie.getValue());
                        return "redirect:/home";
                    } else {
                        model.addAttribute("msg", "密码错误！");
                        return "login";
                    }
                }
            }
        }
        //邮箱登录
        if(phoneNo.matches(em)) {
            //判断mail、password不为null，且不是空字符串
            if(phoneNo != null && !"".equals(phoneNo) && psd != null && !"".equals(psd)){
                user.setName(null);
                user.setPhone(null);
                user.setMail(phoneNo);
                // 查询，false则不存在
                if (!userService.isUserExist(user)) {
                    model.addAttribute("msg", "用户不存在！");
                    return "login";
                } else {
                    // 将输入密码MD5加密，根据名称查询数据库密码，相同则登录，不同即密码错误
                    String passwordMD5 = DesUtil.encryptMd5(psd);
                    if (passwordMD5.equals(userService.getPasswordBy(user))) {
                        // 查找用户id
                        String userId = userService.findIdBy(user);
                        // 生成token，传入用户id、过期时间，10分钟，单位，毫秒
                        String token = JwtUtil.createJwt(userId,10*60*1000);
                        Cookie tokenCookie = new Cookie("token",token);
                        //保留一天，单位，秒
                        tokenCookie.setMaxAge(60*60*24);
                        tokenCookie.setPath("/");
                        response.addCookie(tokenCookie);
                        logger.info("登录用户token："+ tokenCookie.getValue());
                        return "redirect:/home";
                    } else {
                        model.addAttribute("msg", "密码错误！");
                        return "login";
                    }
                }
            }
        }
        //用户名登录
        //判断name、password不为null，且不是空字符串
        if(phoneNo != null && !"".equals(phoneNo) && psd != null && !"".equals(psd)){
            // 查询，false则不存在
            if (!userService.isUserExist(user)) {
                model.addAttribute("msg", "用户不存在！");
                return "login";
            } else {
                // 将输入密码MD5加密，根据名称查询数据库密码，相同则登录，不同即密码错误
                String passwordMD5 = DesUtil.encryptMd5(psd);
                if (passwordMD5.equals(userService.getPasswordBy(user))) {
                    // 查找用户id
                    String userId = userService.findIdBy(user);
                    // 生成token，传入用户id、过期时间，10分钟，单位，毫秒
                    String token = JwtUtil.createJwt(userId,10*60*1000);

                    Cookie tokenCookie = new Cookie("token",token);
                    //保留一天，单位，秒
                    tokenCookie.setMaxAge(60*60*24);
                    tokenCookie.setPath("/");
                    response.addCookie(tokenCookie);
                    logger.info("登录用户token："+ tokenCookie.getValue());

                    return "redirect:/home";
                } else {
                    model.addAttribute("msg", "密码错误！");
                    return "login";
                }
            }
        }
        model.addAttribute("msg", "登录信息不全！");
        return "login";
    }

    // 获取手机验证码
    @RequestMapping(value = "/getTelCode", method = RequestMethod.POST)
//    @ResponseBody
    public String getTelCode(String tel){
        // 进行注册次数检查，过多则无法注册
        if(telMailTestUtil.timesTest(tel)) {
            boolean flag = smsUtil.sendTelCode(tel);
            if (flag) {
                logger.info("获取手机验证码成功");
            } else {
                logger.info("获取手机验证码失败");
            }
        }else {
            logger.info("短时间注册次数过多");
        }
        return "login";
    }

    // 获取邮箱验证码
    @RequestMapping(value = "/getMailCode", method = RequestMethod.POST)
//    @ResponseBody
    public String getMailCode(String email) {
        // 进行注册次数检查，过多则无法注册
        if(telMailTestUtil.timesTest(email)) {
            boolean flag = sendMailUtil.sendMailCode(email);
            if(flag){
                logger.info("获取邮箱验证码成功");
            }else {
                logger.info("获取邮箱验证码失败");
            }
        }else {
            logger.info("短时间注册次数过多");
        }
        return "login";
    }

    // 上传头像，阿里云
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
////    @ResponseBody
//    public String upPhoto(MultipartFile multipartFile, User user) {
//        Map<String,Object> map = new HashMap();
//        String photoPath = aliyunOSSUtil.upPhoto(multipartFile);
//        if( photoPath !=null && !"".equals(photoPath)){
//            // 将user传入后端，set头像路径，再添加数据
//            user.setImagePath(photoPath);
//            userService.insertUser(user);
//            map.put("code","1");
//            map.put("message","上传头像成功");
//            map.put("data",photoPath);
//            logger.info("头像地址：" + photoPath);
//            logger.info("上传头像成功");
//        }else {
//            map.put("code","0");
//            map.put("message","上传头像失败");
//            map.put("data",null);
//            logger.info("上传头像失败");
//        }
//        return "login";
//    }
//
//    // 上传头像，七牛云
//    @RequestMapping(value = "/upPhoto", method = RequestMethod.POST)
////    @ResponseBody
//    public String uploadByQiNiu(MultipartFile multipartFile,User user) {
//        Map<String,Object> map = new HashMap();
//        String photoPath = qiNiuUtil.qiNiuUpload(multipartFile);
//        if( photoPath !=null && !"".equals(photoPath)){
//            // 将user传入后端，set头像路径，再添加数据
//            user.setImagePath(photoPath);
//            userService.insertUser(user);
//            map.put("code","1");
//            map.put("message","上传头像成功");
//            map.put("data",photoPath);
//            logger.info("头像地址：" + photoPath);
//            logger.info("上传头像成功");
//        }else {
//            map.put("code","0");
//            map.put("message","上传头像失败");
//            map.put("data",null);
//            logger.info("上传头像失败");
//        }
//        return "login";
//    }

    // 用户手机号注册
    @RequestMapping(value = "/register1", method = RequestMethod.POST)
    public ModelAndView register(User user, @RequestParam String code,
                                 MultipartFile multipartFile, ModelAndView mav) {
        if(code != null && !"".equals(code)) {
            // 取出缓存的验证码
            String redisCode = jedisUtil.get(user.getPhone());
            // 确定验证码
            if(redisCode != null && !"".equals(redisCode)) {
                if (code.equals(redisCode)) {
                    //判断name、password不为null，且不是空字符串
                    if (user.getName() != null && !"".equals(user.getName())
                            && user.getPassword() != null && !"".equals(user.getPassword())) {
                        // 根据名称查询，true则存在
                        if (userService.isUserExist(user)) {
                            mav.addObject("msg", "用户已存在！");
                        } else {
                            String photoPath = aliyunOSSUtil.upPhoto(multipartFile);
                            if( photoPath !=null && !"".equals(photoPath)){
                                // 将user传入后端，set头像路径，再添加数据
                                user.setImagePath(photoPath);
                                logger.info("头像地址：" + photoPath);
                                mav.addObject("msg", "上传头像成功！");
                            }else {
                                mav.addObject("msg", "上传头像失败！");
                            }
                            // 用户名不同，则注册，且MD5加密密码
                            String passwordMD5 = DesUtil.encryptMd5(user.getPassword());
                            user.setPassword(passwordMD5);
                            user.setPhone(user.getPhone());
                            user.setCreateAt(System.currentTimeMillis());
                            user.setUpdateAt(System.currentTimeMillis());
                            userService.insertUser(user);
                            mav.addObject("msg", "注册成功！请登录。");
                        }
                    } else {
                        mav.addObject("msg", "注册信息不全！");
                    }
                } else {
                    mav.addObject("msg", "验证码错误！");
                }
            } else {
                mav.addObject("msg", "验证码错误！");
            }
        } else {
            mav.addObject("msg", "验证码错误！");
        }
        mav.setViewName("register_tel");
        return mav;
    }
    // 用户邮箱注册
    @RequestMapping(value = "/register2", method = RequestMethod.POST)
    public ModelAndView register2(User user, @RequestParam String code,
                                  MultipartFile multipartFile, ModelAndView mav) {
        if(code != null && !"".equals(code)) {
            // 取出缓存的验证码
            String redisCode = jedisUtil.get(user.getMail());
            // 确定验证码
            if(redisCode != null && !"".equals(redisCode)) {
                if (code.equals(redisCode)) {
                    //判断name、password不为null，且不是空字符串
                    if (user.getName() != null && !"".equals(user.getName())
                            && user.getPassword() != null && !"".equals(user.getPassword())) {
                        // 根据名称查询，true则存在
                        if (userService.isUserExist(user)) {
                            mav.addObject("msg", "用户已存在！");
                        } else {
                            String photoPath = aliyunOSSUtil.upPhoto(multipartFile);
                            if( photoPath !=null && !"".equals(photoPath)){
                                // 将user传入后端，set头像路径，再添加数据
                                user.setImagePath(photoPath);
                                logger.info("头像地址：" + photoPath);
                                mav.addObject("msg", "上传头像成功！");
                            }else {
                                mav.addObject("msg", "上传头像失败！");
                            }
                            // 用户名不同，则注册，且MD5加密密码
                            String passwordMD5 = DesUtil.encryptMd5(user.getPassword());
                            user.setPassword(passwordMD5);
                            user.setMail(user.getMail());
                            user.setCreateAt(System.currentTimeMillis());
                            user.setUpdateAt(System.currentTimeMillis());
                            userService.insertUser(user);
                            mav.addObject("msg", "注册成功！请登录。");
                        }
                    } else {
                        mav.addObject("msg", "注册信息不全！");
                    }
                } else {
                    mav.addObject("msg", "验证码错误！");
                }
            } else {
                mav.addObject("msg", "验证码错误！");
            }
        } else {
            mav.addObject("msg", "验证码错误！");
        }
        mav.setViewName("register_mail");
        return mav;
    }
    @RequestMapping(value = "/register1", method = RequestMethod.GET)
    public String register() {
        return "register_tel";
    }
    @RequestMapping(value = "/register2", method = RequestMethod.GET)
    public String register2() {
        return "register_mail";
    }
    // 用户注销
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        //删除cookie
        Cookie[] cookies = request.getCookies();
        //数组为空判断
        if (null==cookies || cookies.length==0) {
            logger.info("没有cookie==============");
        } else {
            // 修改、删除Cookie时，新建的Cookie除value、maxAge之外的所有属性，
            // 例如name、path、domain等，都要与原Cookie完全一样。
            // 否则，浏览器将视为两个不同的Cookie不予覆盖，导致修改、删除失败。
            Cookie tokenCookie = new Cookie("token","");
            // 立即销毁cookie
            tokenCookie.setMaxAge(0);
            tokenCookie.setPath("/");
            response.addCookie(tokenCookie);
            logger.info("被删除的cookie名字为:"+tokenCookie.getName());
        }
        return "redirect:/home";
    }

}
