package com.vivekt.kt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebsocketJsonDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketJsonDemoApplication.class, args);
    }
}
