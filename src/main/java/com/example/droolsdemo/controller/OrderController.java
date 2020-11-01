package com.example.droolsdemo.controller;

import com.example.droolsdemo.po.Order;
import com.example.droolsdemo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by py
 * 2020/10/30
 */
@RestController
public class OrderController {
    @Autowired
    private RuleService ruleService;

    @RequestMapping("/orderTest")
    public Order orderTest(@RequestBody Order order){
        ruleService.orderRules(order);
        return order;
    }
}
