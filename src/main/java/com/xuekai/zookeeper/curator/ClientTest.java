package com.xuekai.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;

/**
 * curator客户端操作zookeeper
 * @author shixk1
 *
 */
public class ClientTest {
	
	static String ZK_ADDRESS="10.120.124.172:2181";
	static String ZK_PATH="/zktest";
	public static void main(String[] args) throws Exception {
		//1.connect zk
		CuratorFramework client=CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new RetryNTimes(10, 5000)
        );
		
		client.start();
		System.out.println("zk client start successfully!");
		
		 // 2.2 Get node and data  
        print(client.getData().forPath(ZK_PATH));
		
		
	}
	
	private static void print(Object result) {
        System.out.println(
                result instanceof byte[]
                    ? new String((byte[]) result)
                        : result);
    }
}
