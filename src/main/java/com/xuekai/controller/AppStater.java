package com.xuekai.controller;

import com.xuekai.aop.UserService;
import com.xuekai.service.settle.ICreateSettle;
import com.xuekai.serviceImpl.register.SettleRegister;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppStater {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");

        String type = "groupHeader";
        SettleRegister register = (SettleRegister)context.getBean("settleRegister");
        ICreateSettle service = register.getCreateSettleService(type);

        service.excute();

    }
}
