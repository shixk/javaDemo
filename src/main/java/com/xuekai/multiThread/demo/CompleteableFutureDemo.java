package com.xuekai.multiThread.demo;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

public class CompleteableFutureDemo {

    //自定义线程池
    public static ThreadPoolExecutor executorPool = new ThreadPoolExecutor(4,4,20, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<CompletableFuture> futures = Lists.newArrayList();

        for(int i=0;i<3;i++){
            futures.add(businessLayer(i));
        }

        //等待所有的任务都完成
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        for (Future<String> future:futures){
            System.out.println(future.get());
        }

        System.out.println("main thread continue run lalalla");
        //System.exit(0);
    }


    private static CompletableFuture<String> businessLayer(int i){
        return CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(i==2){
                throw new RuntimeException("test exception");
            }
            return "abc"+i;
        },executorPool).exceptionally(throwable -> {
            //log.error("error");
            throw new RuntimeException("eorror is occur");
        });
    }
}
