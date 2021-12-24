package com.xuekai.algorithm;

import java.util.Random;

/**
 * 已知random7 函数，实现random10
 */
public class Random10 {

    private static Random r = new Random(10);

    private int random7(){
        return r.nextInt(7)+1;
    }

    public int solution(){
        int a = 0;

        //只保留[1,40)之间的随机数
        while (true){
            //可以得到【1，49】之间的随机数
            a = (random7()-1)*7 + random7();
            if(a<=40){
                return a%10 +1;
            }

            a = a-40;
            // 得到【1，63】之间的随机数
            a = (a-1)*7+random7();

            if(a<=60){
                return a%10 +1;
            }

            a = a-60;
            //得到【1，21】之间的随机数
            a=(a-1)*7+random7();

            if(a<=20){
                return a%10 +1;
            }
        }
    }


    public static void main(String[] args) {
        Random10 instance = new Random10();
        for (int i = 0; i < 30; i++) {
            System.out.println(instance.solution());
        }


//        int x = rand7();
//        int num = (x - 1) * 7 + rand7();        //rand7()每次调用的值都不同，故不要用变量来存
//        if (num <= 40) return num % 10 + 1;     //大于 40 拒绝采样，
//
//        x = num - 40;                           //此时 x = rand9()
//        num = (x - 1) * 7 + rand7();            // 8 * 7 + 7 = 63
//        if (num <= 60) return num % 10 + 1;     //大于 60 拒绝采样
//
//        x = num - 60;                           //此时 x = rand3()
//        num = (x - 1) * 7 + rand7();            // 2 * 7 + 7 = 21
//        if (num <= 20) return num % 10 + 1;     //大于 20 拒绝采样

    }
}
