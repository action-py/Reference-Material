package com.example.droolsdemo.controller;

import com.example.droolsdemo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by py
 * 2020/10/27
 */
@RestController
public class HelloWorldController {

    @Autowired
    private RuleService ruleService;



    @PostMapping("/hello-rules")
    public void hello(){
        ruleService.rules();
        System.out.println("-------------------------------");
    }

    @PostMapping("/order-rules")
    public void orderRules(){
        ruleService.rules();
        System.out.println("-------------------------------");
    }
}
