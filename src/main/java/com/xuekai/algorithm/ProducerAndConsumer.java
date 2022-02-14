package com.xuekai.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumer {


    private static class Producer implements Runnable{

        private Queue<String> queue;

        public Producer(Queue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    for(int i =0;i<10;i++){
                        queue.offer("字符串"+i);
                        System.out.println("生产消息："+i);

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    queue.notify();
                    //等待通知再生产
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }


        }
    }


    private  static class Consumer implements Runnable{
        private Queue<String> queue;
        public Consumer(Queue queue){
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    if(queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    String s = queue.poll();
                    System.out.println("消费消息："+s);
                    queue.notify();
                }

            }
        }
    }


    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
