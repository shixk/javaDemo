package com.xuekai.DesignPattern.templatePattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/23
 * @Description 泡制柠檬茶
 **/
public class Tea extends BeverageTemplate{
    @Override
    protected void brewMaterial() {
        System.out.println("冲泡茶叶");
    }

    @Override
    protected void putSeasoning() {
        System.out.println("放入柠檬片");
    }
}
