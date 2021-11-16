package com.xuekai.algorithm;

/**
 * 判断一个数字是否是快乐数
 * 19 = 1²+9²=82 = 8²+2²=68=6²+8²=100=1²+0²+0²=1   --- true
 * 37 = 3²+7² =58 = 5²+8²=89 = 8²+9² = 145=1²+4²+5²=42=4²+2²=20=2²+0²=4=16=1²+6²=37。。。 ------false
 */
public class HappyNumber {

    public boolean isHappy(int n){

        if(n<=0) {return  false;}
        if(n==1) {return true;}

        if(n==4||n==16||n==20||n==37||n==42||n==58||n==89||n==145){
            return false;
        }

        int result = sqrt(n);

        return isHappy(result);
    }

    private int sqrt(int n){
        if(n<10){
            return n*n;
        }

        int sum = 0;
        while (n>=10){
            int lastNum = n % 10;
            sum +=lastNum*lastNum;
            n=n/10;
        }

        //最后的一位最高位数字，需要平方累计
        sum +=n*n;

        return sum;
    }

    public static void main(String[] args) {
        int s = 25;

        HappyNumber instance = new HappyNumber();
        System.out.println(instance.isHappy(s));
    }
}
