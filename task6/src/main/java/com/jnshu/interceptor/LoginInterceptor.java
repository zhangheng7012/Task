package com.jnshu.interceptor;

import com.jnshu.util.JwtUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

        // 获取cookie
        Cookie[] cookies = request.getCookies();
        // 数组为空判断
        if ( cookies != null && cookies.length > 0 ) {
            // 遍历cookie，找token
            for (Cookie cookie : cookies) {
                // 如果有名为token的cookie，获取token值
                if (cookie.getName().equals("token") && cookie.getValue() != null) {
                    String token = cookie.getValue();
                    if(JwtUtil.parseJWT(token)){

                        String url = "http://" + request.getServerName() //服务器地址
                                + ":"
                                + request.getServerPort()           //端口号
                                + request.getContextPath()      //项目名称
                                + request.getServletPath()      //请求页面或其他地址
                                + "?" + (request.getQueryString()); //参数
                        logger.info("请求URL为："+ url);

                        return true;
                    }
                }
            }
        }
        String url = "http://" + request.getServerName() //服务器地址
                + ":"
                + request.getServerPort()           //端口号
                + request.getContextPath()      //项目名称
                + request.getServletPath()      //请求页面或其他地址
                + "?" + (request.getQueryString()); //参数
        logger.info("请求URL为："+ url);

        response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception {

    }
}
