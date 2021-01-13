package com.xuekai.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author shixuekai
 * @CreateDate 2019/12/25
 * @Description
 **/
@Data
@Component
public class Student extends People{
    private Integer shengao;


    public void speak(){
        System.out.println("hello");
    }
}
