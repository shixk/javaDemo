package com.xuekai.springEvent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author shixuekai
 * @CreateDate 2017/12/14
 * @Description
 **/
@Component
public class BusinessPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher registerPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        registerPublisher=applicationEventPublisher;
    }

    /**
     * 具体业务，发布事件
     */
    public void sayHello(){
        System.out.println("执行其他业务逻辑，例如校验，取数据，填充对象等操作");
        RegisterEvent event=new RegisterEvent(new String("zhangsan"));
        //发布注册事件
        registerPublisher.publishEvent(event);
    }
}
