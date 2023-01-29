package com.callbus.jaritalkcommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JaritalkCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaritalkCommunityApplication.class, args);
    }

}
