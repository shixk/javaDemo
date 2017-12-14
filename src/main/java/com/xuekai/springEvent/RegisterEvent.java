package com.xuekai.springEvent;

import org.springframework.context.ApplicationEvent;

/**
 * @Author shixuekai
 * @CreateDate 2017/12/14
 * @Description
 **/
public class RegisterEvent extends ApplicationEvent{

    public RegisterEvent(Object source) {
        super(source);

        System.out.println("执行了注册的逻辑，接收到的用户是："+source);
    }
}
