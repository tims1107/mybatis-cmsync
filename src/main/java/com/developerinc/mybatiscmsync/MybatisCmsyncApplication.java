package com.developerinc.mybatiscmsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.developerinc.mybatiscmsync")
@EntityScan("com.developerinc.mybatiscmsync.model")
public class MybatisCmsyncApplication {


public static void main(final String[] applicationArguments) {
    SpringApplication.run(MybatisCmsyncApplication.class, applicationArguments);
}

}
