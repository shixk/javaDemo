package com.xuekai.serviceImpl;

import com.xuekai.service.Animal;
import org.springframework.stereotype.Service;

/**
 * @Author shixuekai
 * @CreateDate 2021/1/13
 * @Description
 **/
@Service
public class Cat implements Animal{
    @Override
    public String showName() {
        return "my name is cat";
    }
}
