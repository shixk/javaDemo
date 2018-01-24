package com.xuekai.DesignPattern.adapterPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/24
 * @Description 手机类，需要充电的方法
 **/
public class Mobile {

    public void inputPower(FiveVPower power){
        int a=power.providePower();
        System.out.println("充电中...");
    }


    public static void main(String[] args) {
        V220Power v220Power=new V220Power();
        FiveVPower v5Power=new V5PowerAdapter(v220Power);

        Mobile mobile=new Mobile();
        mobile.inputPower(v5Power);
    }
}
