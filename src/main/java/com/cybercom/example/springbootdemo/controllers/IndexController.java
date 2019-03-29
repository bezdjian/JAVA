package com.cybercom.example.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Value("${spring.application.name}")
    private String appname;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("appname", appname);
        return "index";
    }

}
