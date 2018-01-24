package com.xuekai.DesignPattern.adapterPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/24
 * @Description 家用220v电压
 **/
public class V220Power {

    public int provide220Power(){
        System.out.println("获取到220v电压");
        return 220;
    }
}
