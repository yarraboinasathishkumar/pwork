package com.springbootskyapps.library.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(ServiceProperties.class)
public class MyService {
    private final ServiceProperties serviceProperties;


    public MyService(ServiceProperties serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    public String message() {
        System.out.println("From Service: message" +this.serviceProperties.getMessage());
        return this.serviceProperties.getMessage();
    }
}
