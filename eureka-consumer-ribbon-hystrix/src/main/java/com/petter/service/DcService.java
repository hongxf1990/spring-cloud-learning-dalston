package com.petter.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author hongxf
 * @since 2017-07-19 9:29
 */
@Service
public class DcService {

    @Resource
    private RestTemplate restTemplate;

    //指定服务降级方法
    @HystrixCommand(fallbackMethod = "dcFallback")
    public String dc() {
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    private String dcFallback() {
        return "dcError";
    }

}
