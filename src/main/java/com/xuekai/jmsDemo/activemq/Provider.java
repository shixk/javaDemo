package com.xuekai.jmsDemo.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Provider {
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://127.0.0.1:61616");
		Connection connection=connectionFactory.createConnection();
		connection.start();
		 //会话 接受或者发送消息的线程
        Session session;
        //消息的目的地
        Destination destination;
        //消息生产者
        MessageProducer messageProducer;
        
        //第一个参数是是否是事务型消息，设置为true,第二个参数无效
      	//第二个参数是
      	//Session.AUTO_ACKNOWLEDGE为自动确认，客户端发送和接收消息不需要做额外的工作。异常也会确认消息，应该是在执行之前确认的
      	//Session.CLIENT_ACKNOWLEDGE为客户端确认。客户端接收到消息后，必须调用javax.jms.Message的acknowledge方法。jms服务器才会删除消息。可以在失败的
      	//时候不确认消息,不确认的话不会移出队列，一直存在，下次启动继续接受。接收消息的连接不断开，其他的消费者也不会接受（正常情况下队列模式不存在其他消费者）
      	//DUPS_OK_ACKNOWLEDGE允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收；而且允许重复确认。在需要考虑资源使用时，这种模式非常有效。
        session=connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue("xktest-queue");
		messageProducer = session.createProducer(destination);
		//是否持久化
		//messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		for(int i=0;i<100;i++){
			TextMessage text=session.createTextMessage("text"+i);
			System.out.println("text"+i);
			messageProducer.send(text);
			//session.commit();
		}
		
		//最后关闭连接
		connection.close();
        
	}
}
