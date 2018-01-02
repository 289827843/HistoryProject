package com.sxun.server.platform.service.cms;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableJSONDoc
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages={"com.sxun.server.platform.service.cms","com.sxun.server.common.web"})
@MapperScan("com.sxun.server.platform.service.cms.dao")
public class CMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(CMSApplication.class, args);
    }
}