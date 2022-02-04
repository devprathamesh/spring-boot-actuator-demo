package dev.learnx.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/index")
public class IndexController {

    @GetMapping(path = "/message")
    public String getIndexMessage(){
        return "Hello from IndexController";
    }
}
