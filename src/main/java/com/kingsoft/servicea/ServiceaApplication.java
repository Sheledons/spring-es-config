package com.kingsoft.servicea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.kingsoft.servicea.service.feign"})
@MapperScan(basePackages = {"com.kingsoft.servicea.mapper"})
@EnableDiscoveryClient
@RefreshScope
public class ServiceaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceaApplication.class, args);
    }

}
