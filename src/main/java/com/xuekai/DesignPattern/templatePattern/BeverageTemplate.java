package com.xuekai.DesignPattern.templatePattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/23
 * @Description 饮料模板
 **/
public abstract class BeverageTemplate {

    /**
     * 每种饮料都需要经过如下方法来制作
     * 属于高度抽象的公共流程。
     */
    public final void CreateBeverage(){
        //步骤1 烧开热水
        boilWater();

        //步骤2 冲泡饮料原料
        brewMaterial();

        //步骤3 将饮料倒入杯中
        pourToCup();

        //步骤4 放入调味料
        putSeasoning();
    }

    private void boilWater(){
        System.out.println("煮沸了开水");
    }

    private void pourToCup(){
        System.out.println("将饮料倒入杯子中");
    }

    protected abstract void brewMaterial();

    protected abstract void putSeasoning();
}
