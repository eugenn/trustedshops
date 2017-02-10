package com.trustshops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

/**
 * Created by eugennekhai on 18/08/16.
 */
@SpringBootApplication
public class Application extends AsyncConfigurerSupport {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}