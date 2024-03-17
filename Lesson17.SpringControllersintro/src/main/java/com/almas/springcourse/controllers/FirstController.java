package com.almas.springcourse.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(){
       return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
      return "first/goodbye";
    }


}
