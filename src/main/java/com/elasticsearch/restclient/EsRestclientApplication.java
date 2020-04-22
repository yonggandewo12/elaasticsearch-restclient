package com.elasticsearch.restclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.elasticsearch","com.elasticsearch.restclient"})
@SpringBootApplication
public class EsRestclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsRestclientApplication.class, args);
    }

}
