package com.example.webhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@SpringBootApplication
public class WebHookApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebHookApplication.class, args);
    }
}
