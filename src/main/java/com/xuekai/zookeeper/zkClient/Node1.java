package com.xuekai.zookeeper.zkClient;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * 第一个节点
 * 创建三个类似的节点，共同创建同一个zkpath的值，哪个节点创建成功，则哪个节点获得master权限。
 * @author shixk1
 *
 */
public class Node1 implements Watcher {

	ZooKeeper zk;  
    String hostPort;  
    String znode;
    
    public Node1(String hostPort,String znode) throws  Throwable {
    	this.hostPort=hostPort;
    	this.znode=znode;
    	
    	zk=new ZooKeeper(hostPort, 3000, this);
    	try {  
            //每个客户端都创建同一个节点(临时节点，一旦断开与zkServer的链接，临时节点自动删除)，如果创建成功，则该客户端是master  
            zk.create(znode, "node1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);  
            System.out.println("node1监控info,master节点是：node1");  
        } catch (KeeperException.NodeExistsException e) {  
            //如果抛出节点存在的异常，则master已经存在，在该节点上添加watcher  
            System.out.println("node1监控info,master节点是：" + new String(zk.getData(znode, false, null)));  
            zk.exists(znode, true);  
        }
    }
    
    //当临时节点发生变化，意味着此时可以去争抢master权限
	@Override
	public void process(WatchedEvent event) {
		try {  
            
            if (event.getType() == EventType.NodeDeleted) {  
                try {  
                    zk.create(znode, "node1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);  
                    System.out.println("node1监控info,master节点是：node1");  
                } catch (KeeperException.NodeExistsException e) {  
                    System.out.println("node1监控info,master节点是：" + new String(zk.getData(znode, false, null)));  
                    zk.exists(znode, true);  
                }  
            }  
              
        } catch (KeeperException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  

	}
	
	
	public static void main(String[] args) throws Throwable {
		Node1 node1=new Node1("10.120.124.172:2181","/com/imooc/shixk/masternode");
		
		System.in.read();
		
	}

}
