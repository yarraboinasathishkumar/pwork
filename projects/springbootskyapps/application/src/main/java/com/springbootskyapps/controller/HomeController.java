package com.springbootskyapps.controller;;

import com.springbootskyapps.library.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController {
    @Autowired
    private MyService myService;

    @GetMapping("")
    public String home() {
        return  myService.message();
    }
}
