package com.xuekai.DesignPattern.adapterPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/24
 * @Description
 **/
public class V5PowerAdapter implements FiveVPower{

    private V220Power v220Power;

    public V5PowerAdapter(V220Power v220Power){
        this.v220Power=v220Power;
    }

    @Override
    public int providePower() {
        int power=v220Power.provide220Power();
        System.out.println("经过降压转换，得到5v电压");
        power=5;
        return power;
    }
}
