package com.xuekai.utils;

public class CatchFishUtil {

    public static void main(String[] args) {
        String read = "";
        int length = read.length();
        int size = 100;
        int from = 0,to = 100;
        while (to<length){
            System.out.println(read.substring(from,to));
            from +=size;
            to +=size;
        }

        //最后一行
        System.out.println(read.substring(from,length));

    }
}
