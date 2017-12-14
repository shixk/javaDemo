package com.xuekai.springEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author shixuekai
 * @CreateDate 2017/12/14
 * @Description
 **/
public class demo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        BusinessPublisher publisher=(BusinessPublisher)context.getBean("businessPublisher");
        publisher.sayHello();
    }
}
