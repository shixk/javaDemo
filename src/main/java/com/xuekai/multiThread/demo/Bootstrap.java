package com.xuekai.multiThread.demo;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author shixuekai
 * @CreateDate 2018/12/10
 * @Description
 **/
public class Bootstrap {

    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService= Executors.newFixedThreadPool(10);
        List<Order> orderList=initOrder();
        CountDownLatch latch=new CountDownLatch(orderList.size());

        orderList.forEach(p->{
            CreateOrderTask task=new CreateOrderTask(p,latch);
            executorService.execute(task);
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

            //结合具体业务看是否需要释放线程池
            if(!executorService.isShutdown()){
                executorService.shutdown();
            }
        }

        System.out.println("多线程业务处理完成！");
    }


    private static List<Order> initOrder(){
        List<Order> orders= Lists.newArrayList();
        for(int i=0;i<100;i++){
            Order order=new Order();
            order.setAmount(1000l+i);
            order.setOrderNo("js000"+i);
            order.setReceiver("system");

            orders.add(order);
        }

        return orders;
    }
}
