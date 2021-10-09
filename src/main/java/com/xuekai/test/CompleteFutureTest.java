package com.xuekai.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CompleteFutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<User> future = CompletableFuture.supplyAsync(()->{
            User u = new User();
            u.setName("xk");
            return u;
        });

        User a =(User) future.get();

        System.out.println(a.toString());
    }
}
