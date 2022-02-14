package com.xuekai.algorithm;

/**
 * x的平方根
 */
public class Sqart {

    public static int solution(int x){
        if(x == 0){
            return 0;
        }
        if(x==1){
            return 1;
        }

        long i=1;
        while (i<x){
            long sq = i*i;
            if(sq == x){
                return (int)i;
            }

            if(sq > x){
                break;
            }

            i++;
        }

        return (int)i-1;
    }

    public static void main(String[] args) {
        int re = solution(4);

        System.out.println(re);

        re = solution(8);

        System.out.println(re);

        re = solution(2147483647);

        System.out.println(re);
    }
}
