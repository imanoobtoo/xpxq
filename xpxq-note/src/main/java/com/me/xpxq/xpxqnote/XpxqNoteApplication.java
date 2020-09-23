package com.me.xpxq.xpxqnote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.me.xpxq.xpxqnote.dao")
public class XpxqNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(XpxqNoteApplication.class, args);
    }

}
