package com.xuekai.multiThread.demo;

import java.util.concurrent.Semaphore;

/**
 * @Author shixuekai
 * @CreateDate 2021/6/8
 * @Description 模拟停车场
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        //设置停车场容量，进来一辆则减少一个信号量，出去一辆归还一个信号量
        Semaphore semaphore = new Semaphore(10);

        for(int i=0;i<100;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if(semaphore.availablePermits() == 0){
                        System.out.println("当前停车场已满，请等待.....");
                    }

                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"正在停车");
                        Thread.sleep(10000);

                        System.out.println(Thread.currentThread().getName()+"已离开");

                        semaphore.release();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
        }
    }
}
