package com.developerinc.mybatiscmsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.developerinc.mybatiscmsync")
public class MybatisCmsyncApplication {


public static void main(final String[] applicationArguments) {
    SpringApplication.run(MybatisCmsyncApplication.class, applicationArguments);
}

}
