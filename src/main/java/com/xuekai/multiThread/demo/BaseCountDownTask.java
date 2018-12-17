package com.xuekai.multiThread.demo;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @Author shixuekai
 * @CreateDate 2018/12/3
 * @Description
 **/
@Getter
public abstract class BaseCountDownTask<T,R> implements Runnable {

    private static Logger LOG= LoggerFactory.getLogger(BaseCountDownTask.class);

    private CountDownLatch countDownLatch;

    /** 返回结果 */
    private R result;

    /** 入参 */
    private T request;

    private String errorMsg;

    public BaseCountDownTask(T request,CountDownLatch countDownLatch){
        this.request=request;
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run() {
        try {
            result=handle(request);
        } catch (Exception e) {
            errorMsg=e.getMessage();
            LOG.error(e.getMessage(),e);
        }finally {
            countDownLatch.countDown();
        }
    }

    public abstract R handle(T request) throws Exception;
}
