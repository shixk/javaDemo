package com.xuekai.multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author shixuekai
 * @CreateDate 2018/6/29
 * @Description
 **/
public class Test {

    public static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());


    public static void main(String[] args) {
        String s=null;
        CountDownLatch latch=new CountDownLatch(100);
        System.out.println("任务start:"+System.currentTimeMillis());
        for(int i=0;i<100;i++){
            s="no000"+String.valueOf(i);
            threadPoolExecutor.submit(new CreateOrderTask(s,latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("任务end:"+System.currentTimeMillis());
    }


    private static class CreateOrderTask implements Runnable{
        private CountDownLatch latch;
        private String orderNo;

        public CreateOrderTask(String orderNo,CountDownLatch latch){
            this.latch=latch;
            this.orderNo=orderNo;
        }

        @Override
        public void run() {
            try {
                //编写业务逻辑
                System.out.println("当前执行单号"+orderNo);
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("error");
            }finally {
                latch.countDown();
            }
        }
    }
}
