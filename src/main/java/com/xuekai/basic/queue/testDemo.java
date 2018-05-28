package com.xuekai.basic.queue;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author shixuekai
 * @CreateDate 2018/5/25
 * @Description
 **/
public class testDemo {


    public static void main(String[] args) {
        BlockingDeque<String> queue=new LinkedBlockingDeque<>(3);

        try {
            queue.put("aaa");
            queue.put("bbb");
            queue.put("ccc");
            queue.put("ddd");
            queue.put("fff");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
}
