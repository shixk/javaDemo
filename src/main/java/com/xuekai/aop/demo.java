package com.xuekai.aop;

import com.xuekai.entity.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author shixuekai
 * @CreateDate 2017/12/22
 * @Description
 **/
public class demo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        UserService userService=(UserService)context.getBean("userService");
        People p=new People();
        p.setAge(18);
        p.setName("shixk");
        userService.save(p);

        userService.update(p);
    }
}
