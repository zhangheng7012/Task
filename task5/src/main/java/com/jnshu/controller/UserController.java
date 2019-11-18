package com.jnshu.controller;

import com.jnshu.pojo.User;
import com.jnshu.service.UserService;
import com.jnshu.util.DesUtil;
import com.jnshu.util.JwtUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // 跳转到登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    // 用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model,
                        HttpServletResponse response, HttpServletRequest request) {
        //判断name、password不为null，且不是空字符串
        if(user.getName()!=null && !"".equals(user.getName())
            && user.getPassword()!=null && !"".equals(user.getPassword())){
            // 根据名称查询，false则不存在
            if (!userService.isUserExist(user.getName())) {
                model.addAttribute("msg", "用户名不存在！");
                return "login";
            } else {
                // 将输入密码MD5加密，根据名称查询数据库密码，相同则登录，不同即密码错误
                String passwordMD5 = DesUtil.encryptMd5(user.getPassword());
                if (passwordMD5.equals(userService.getPasswordByName(user.getName()))) {
                    // 查找用户id
                    String userId = userService.findIdByName(user.getName());
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

    // 用户注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(User user, ModelAndView mav) {
        //判断name、password不为null，且不是空字符串
        if(user.getName()!=null && !"".equals(user.getName())
                && user.getPassword()!=null && !"".equals(user.getPassword())){
            // 根据名称查询，true则存在
            if (userService.isUserExist(user.getName())) {
                mav.addObject("msg", "用户名已存在！");
            } else {
                // 用户名不同，则注册，且MD5加密密码
                String passwordMD5 = DesUtil.encryptMd5(user.getPassword());
                user.setPassword(passwordMD5);
                user.setCreateAt(System.currentTimeMillis());
                user.setUpdateAt(System.currentTimeMillis());
                userService.insertUser(user);
                mav.addObject("msg", "注册成功！请登录。");
            }
        }else {
            mav.addObject("msg", "注册信息不全！");
        }
        mav.setViewName("login");
        return mav;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "login";
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
