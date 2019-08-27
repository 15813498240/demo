package com.lxf.demo.springcloudserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringCloudServerApplication {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServerApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello(){
        String forObject = restTemplate.getForObject("https://www.baidu.com/", String.class);
        return "hello world ------------------------"+forObject;
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
