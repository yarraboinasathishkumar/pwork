package com.springbootskyapps.library.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest("service.message=Hello")
class MyServiceTest {
    @Autowired
    private MyService myService;

    @Test
    public void ContextLoads() {
        assertThat(myService.message()).isNotNull();
    }

    @SpringBootApplication
    static class TestConfiguration {

    }

}