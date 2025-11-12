package org.apatrios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ElBikesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElBikesApplication.class, args);
    }
}
