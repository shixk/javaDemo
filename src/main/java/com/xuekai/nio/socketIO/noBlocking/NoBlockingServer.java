package com.xuekai.nio.socketIO.noBlocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @Author shixuekai
 * @CreateDate 2018/5/21
 * @Description
 **/
public class NoBlockingServer {

    public static void main(String[] args) throws IOException {
        // 1.打开ServerSocket
        ServerSocketChannel server= ServerSocketChannel.open();

        // 2.切换成非阻塞模式
        server.configureBlocking(false);
        // 3.绑定端口
        server.bind(new InetSocketAddress(6666));
        // 4.创建选择器
        Selector selector=Selector.open();

        // 4.1将通道注册到选择器上，指定接收“监听通道”事件
        server.register(selector, SelectionKey.OP_ACCEPT);

        while(selector.select()>0){
            // 6. 获取当前选择器所有注册的“选择键”(已就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                // 接收事件就绪
                if(selectionKey.isAcceptable()){
                    ServerSocketChannel ssc = (ServerSocketChannel)selectionKey.channel();
                    // 8. 获取客户端的链接
                    SocketChannel client=ssc.accept();
                    // 切换成非阻塞模式
                    client.configureBlocking(false);
                    // 8.2 注册到选择器上-->拿到客户端的连接为了读取通道的数据(监听读就绪事件)
                    client.register(selector,SelectionKey.OP_READ);

                } // 读事件就绪
                else if(selectionKey.isReadable()){
                    // 获取当前选择器读就绪状态的通道
                    SocketChannel clientChannel=(SocketChannel)selectionKey.channel();
                    // 9.1读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    FileChannel fileChannel=FileChannel.open(Paths.get("6.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
                    // 写入文件
                    while(clientChannel.read(buffer)>0){

                        buffer.flip();

                        fileChannel.write(buffer);

                        buffer.clear();
                    }

                    fileChannel.close();

                }

            }

        }
    }
}
