package com.sxun.server.platform.service.cms;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableJSONDoc
@SpringBootApplication
@ComponentScan(basePackages={"com.sxun.server.platform.service.cms","com.sxun.server.common.web"})
public class CMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(CMSApplication.class, args);
    }
}