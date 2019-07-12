package com.xuekai.springEvent;

import com.xuekai.entity.People;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author shixuekai
 * @CreateDate 2017/12/14
 * @Description
 **/
@Component
public class EmailListener implements ApplicationListener<RegisterEvent>{

    @Async
    @Override
    public void onApplicationEvent(RegisterEvent registerEvent) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        People p=registerEvent.getPeople();
        System.out.println("监听到了注册事件，给用户"+p.getName()+"发送邮件了，注意查收");
    }
}
