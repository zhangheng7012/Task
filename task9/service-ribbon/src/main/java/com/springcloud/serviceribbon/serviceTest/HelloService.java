package com.springcloud.serviceribbon.serviceTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    // 根据返回值类型，确定 “.class” 前的数据类型
    // 访问网址用 服务名称 EUREKA-CLIENT 代替
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name="+name,String.class);
    }
}
