package org.cleanarchitecture.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "org.cleanarchitecture.core",
        "org.cleanarchitecture.infrastructure",
        "org.cleanarchitecture.main"})
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class);
    }
}
