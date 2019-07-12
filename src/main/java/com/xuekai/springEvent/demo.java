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
        //执行业务逻辑方法
        publisher.sayHello();
        System.out.println("end:"+System.currentTimeMillis());

    }
}
