package com.xuekai.zookeeper.zkClient;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;

public class Node2 implements Watcher {

	ZooKeeper zk;  
    String hostPort;  
    String znode;
    
    public Node2(String hostPort,String znode) throws  Throwable {
    	this.hostPort=hostPort;
    	this.znode=znode;
    	
    	zk=new ZooKeeper(hostPort, 3000, this);
    	try {  
            //每个客户端都创建同一个节点(临时节点，一旦断开与zkServer的链接，临时节点自动删除)，如果创建成功，则该客户端是master  
            zk.create(znode, "node2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);  
            System.out.println("node2监控info,master节点是：node2");  
        } catch (KeeperException.NodeExistsException e) {  
            //如果抛出节点存在的异常，则master已经存在，在该节点上添加watcher  
            System.out.println("node2监控info,master节点是：" + new String(zk.getData(znode, false, null)));  
            zk.exists(znode, true);  
        }
    }
    
    //当临时节点发生变化，意味着此时可以去争抢master权限
	@Override
	public void process(WatchedEvent event) {
		try {  
            
            if (event.getType() == EventType.NodeDeleted) {  
                try {  
                    zk.create(znode, "node2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);  
                    System.out.println("node2监控info,master节点是：node2");  
                } catch (KeeperException.NodeExistsException e) {  
                    System.out.println("node2监控info,master节点是：" + new String(zk.getData(znode, false, null)));  
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
		Node2 node2=new Node2("10.120.124.172:2181","/com/imooc/shixk/masternode");
		
		System.in.read();
		
	}

}
