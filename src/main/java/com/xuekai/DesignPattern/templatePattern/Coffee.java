package com.xuekai.DesignPattern.templatePattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/23
 * @Description 泡制咖啡
 **/
public class Coffee extends BeverageTemplate{
    @Override
    protected void brewMaterial() {
        System.out.println("冲泡了咖啡粉末");
    }

    @Override
    protected void putSeasoning() {
        System.out.println("放入牛奶和糖");
    }
}
