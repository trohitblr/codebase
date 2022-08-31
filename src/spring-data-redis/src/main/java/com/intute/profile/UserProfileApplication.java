package com.intute.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={
        "com.intute.profile.*"})
@EnableJpaRepositories
@EnableJpaAuditing
public class UserProfileApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProfileApplication.class, args);
    }

}
