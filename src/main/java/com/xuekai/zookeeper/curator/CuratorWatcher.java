package com.xuekai.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.retry.RetryNTimes;

/**
 * 此类用于测试zk客户端watch路径子节点变化
 * @author shixk1
 *
 */
public class CuratorWatcher {
	static String ZK_ADDRESS="10.120.124.172:2181";
	static String ZK_PATH="/zktest";
	public static void main(String[] args) throws Exception {
		// 1.Connect to zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new RetryNTimes(10, 5000)
        );
        client.start();
        System.out.println("zk client start successfully!");
        
     // 2.Register watcher
        //这里监控的当前节点下，孩子节点的变化
        PathChildrenCache watcher = new PathChildrenCache(
                client,
                ZK_PATH,
                true    // if cache data
        );
        //此处为jdk1.8的写法，用lambda表达式代替内部类
        watcher.getListenable().addListener((client1, event) -> {
            ChildData data = event.getData();
            if (data == null) {
                System.out.println("No data in event[" + event + "]");
            } else {
                System.out.println("Receive event: "
                        + "type=[" + event.getType() + "]"
                        + ", path=[" + data.getPath() + "]"
                        + ", data=[" + new String(data.getData()) + "]"
                        + ", stat=[" + data.getStat() + "]");
            }
        });
        watcher.start(StartMode.BUILD_INITIAL_CACHE);
        System.out.println("Register zk watcherChild successfully!");
        
        
        
        //3.注册监控当前节点值，变化
        NodeCache node=new NodeCache(
        		client,
                ZK_PATH,
                false );
        node.start(true);
        node.getListenable().addListener(new NodeCacheListener(){

        	//概要说明：触发事件为创建节点和更新节点，在删除节点的时候并不触发此操作。
			@Override
			public void nodeChanged() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("监听节点路径=====" + node.getCurrentData().getPath());
                System.out.println("数据=====" + new String(node.getCurrentData().getData()));
                System.out.println("状态=====" + node.getCurrentData().getStat());
                System.out.println("---------------------------------------");
			}
        	
        });

        Thread.sleep(Integer.MAX_VALUE);
        
	}
}
