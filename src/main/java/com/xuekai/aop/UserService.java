package com.xuekai.aop;

import com.xuekai.entity.People;
import org.springframework.stereotype.Component;

/**
 * 用户操作类
 *
 * @Author shixuekai
 * @CreateDate 2017/12/22
 * @Description
 **/
@Component
public class UserService {

    @Logrecord
    public int save(People people){
        System.out.println("保存用户成功");

        return 1;
    }

    public int update(People p){
        System.out.println("更新用户成功");
        return 1;
    }
}
