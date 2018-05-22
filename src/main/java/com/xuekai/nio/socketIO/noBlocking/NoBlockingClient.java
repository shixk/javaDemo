package com.xuekai.nio.socketIO.noBlocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author shixuekai
 * @CreateDate 2018/5/21
 * @Description
 **/
public class NoBlockingClient {

    private static String source="/Users/shixuekai/Downloads/33.jpg";

    public static void main(String[] args) throws IOException {
        // 1. 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));
        // 2.读取文件
        FileChannel fileChannel=FileChannel.open(Paths.get(source), StandardOpenOption.READ);

        // 3.要使用NIO，有了Channel，就必然要有Buffer，Buffer是与数据打交道的呢
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(fileChannel.read(buffer)!=-1){
            // 切换到读模式
            buffer.flip();
            // 通过管道传输数据
            socketChannel.write(buffer);
            // 将数据清空，等待填充接下来的数据
            buffer.clear();
        }

        fileChannel.close();

        socketChannel.close();


    }
}
