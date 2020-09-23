package com.me.xpxq.xpxqmember;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication(exclude = EnableDiscoveryClient.class)
@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
@MapperScan("com.me.xpxq.xpxqmember.dao")
@EnableFeignClients
public class XpxqMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(XpxqMemberApplication.class, args);
    }

}
