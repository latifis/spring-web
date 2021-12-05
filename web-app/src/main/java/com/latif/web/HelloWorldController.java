package com.latif.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //ada di dep starter-web
@RequestMapping("/helloWorld") //buat path apa
public class HelloWorldController {

    @PostMapping
    public HelloWorld getHelloWorld(){
        return new HelloWorld();
    }
}
