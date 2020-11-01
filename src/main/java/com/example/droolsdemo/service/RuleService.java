package com.example.droolsdemo.service;

import com.example.droolsdemo.po.Order;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by py
 * 2020/10/27
 */
@Service
public class RuleService {

    @Autowired
    private KieBase kieBase;


    public void rules(){
        KieSession kieSession = kieBase.newKieSession();
        try {
            kieSession.fireAllRules();
        }catch (Exception e){
            System.out.println("规则异常");
        }finally {
            kieSession.dispose();
        }
    }
    /*
        1	规则一	所购图书总价在100元以下的没有优惠
        2	规则二	所购图书总价在100到200元的优惠20元
        3	规则三	所购图书总价在200到300元的优惠50元
        4	规则四	所购图书总价在300元以上的优惠100元
    */
    public void orderRules(Order order){
        KieSession kieSession = kieBase.newKieSession();
        try {
            kieSession.insert(order);
            kieSession.fireAllRules();
            System.err.println(order);
        }catch (Exception e){
            System.out.println("规则异常");
        }finally {
            kieSession.dispose();
        }
    }
}
