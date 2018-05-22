package com.xuekai.nio.fileIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author shixuekai
 * @CreateDate 2018/5/18
 * @Description
 **/
public class copyDemo {

    //源文件
    private static String source="/Users/shixuekai/Downloads/33.jpg";
    //目标文件位置
    private static String des="/Users/shixuekai/Documents/1.jpg";

    public static void main(String[] args) {

        try {
            //transferFileByIO(source,des);
            transferFileByNIO(source,des);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 普通的io复制
     * @param source
     * @param des
     */
    private static void transferFileByIO(String source,String des) throws IOException {
        File sourceFile=new File(source);
        File desFile=new File(des);
        //读取流
        BufferedInputStream is=new BufferedInputStream(new FileInputStream(sourceFile));
        //写入流
        BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream(desFile));

        byte[] buffer=new byte[1024];
        int len=0;
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        os.flush();

        is.close();

        os.close();

        System.out.println("文件复制完成");

    }

    /**
     * 文件复制通过NIO
     * @param source
     * @param des
     */
    private static void transferFileByNIO(String source,String des) throws IOException {
        File sourceFile=new File(source);
        File desFile=new File(des);

        if(!desFile.exists()){
            desFile.createNewFile();
        }

        RandomAccessFile readFile=new RandomAccessFile(sourceFile,"rw");
        RandomAccessFile writeFile=new RandomAccessFile(desFile,"rw");

        FileChannel readChannel=readFile.getChannel();
        FileChannel writeChannel=writeFile.getChannel();

        ByteBuffer buffer=ByteBuffer.allocate(1024*1024);//1M

        while (readChannel.read(buffer)>0){
            //切换为读模式
            buffer.flip();

            writeChannel.write(buffer);
            //清空数据
            buffer.clear();

        }
        readChannel.close();
        writeChannel.close();

        System.out.println("文件复制完成");

    }

}
