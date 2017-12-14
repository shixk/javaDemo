package com.xuekai.springEvent;

import org.springframework.context.ApplicationListener;

/**
 * @Author shixuekai
 * @CreateDate 2017/12/14
 * @Description
 **/
public class EmailListener implements ApplicationListener<RegisterEvent>{
    @Override
    public void onApplicationEvent(RegisterEvent registerEvent) {
        System.out.println("监听到了注册事件，给用户"+registerEvent.getSource().toString()+"发送邮件了，注意查收");
    }
}
