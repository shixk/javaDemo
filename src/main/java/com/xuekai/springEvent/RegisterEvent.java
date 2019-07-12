package com.xuekai.springEvent;

import com.xuekai.entity.People;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @Author shixuekai
 * @CreateDate 2017/12/14
 * @Description
 **/
@Data
public class RegisterEvent extends ApplicationEvent{

    private People people;

    public RegisterEvent(Object source, People people) {
        super(source);
        this.people=people;
        System.out.println("执行了注册的逻辑，接收到的用户是："+source);
    }
}
