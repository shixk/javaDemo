package com.xuekai.multiThread.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @Author shixuekai
 * @CreateDate 2018/12/3
 * @Description
 **/
public class CreateOrderTask extends BaseCountDownTask<Order,String> {

    public CreateOrderTask(Order order, CountDownLatch latch){
        super(order,latch);
    }

    @Override
    public String handle(Order order) throws Exception {
        //业务逻辑
        //外部依赖调用
        Thread.sleep(1000);
        System.out.println("订单号："+order.getOrderNo()+"发生业务成功");
        return order.getOrderNo();
    }
}
