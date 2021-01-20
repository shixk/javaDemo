package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/1/19
 * @Description
 **/
public class ByTurnPrint {

    private static Object object = new Object();

    private  volatile boolean hasPrint = false;//线程A是否已打印

    private  volatile int index = 1;

    private class OneThread implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<50;i++){
                synchronized (object){
                    //线程A已打印过，则释放锁
                    while(hasPrint){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName()+":"+index);
                    index++;
                    hasPrint=true;
                    object.notifyAll();

                }

            }
        }
    }

    private class TwoThread implements Runnable {

        @Override
        public void run() {
            for(int i=0;i<50;i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (object) {
                    //如果线程A没有打印，则释放锁，进行等待A打印结束
                    while (!hasPrint){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + index);
                    index++;
                    hasPrint=false;//

                    object.notifyAll();
                }

            }
        }
    }

    public static void main(String[] args) {
        ByTurnPrint byTurnPrint = new ByTurnPrint();
        Thread threadA = new Thread( byTurnPrint.new OneThread(),"threadA");
        Thread threadB = new Thread(byTurnPrint.new TwoThread(),"threadB");

        threadA.start();
        threadB.start();
    }
}
