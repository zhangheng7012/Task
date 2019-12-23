package com.springcloud.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class HiServiceHystric implements HiService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry~ " + name;
    }
}
