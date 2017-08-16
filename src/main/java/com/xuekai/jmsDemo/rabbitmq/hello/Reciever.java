package com.xuekai.jmsDemo.rabbitmq.hello;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;

public class Reciever {
	private final static String queueName="hello.hust";
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.120.124.172");
        
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        
        channel.queueDeclare(queueName, false, false, false, null);
        
        Consumer consumer =new DefaultConsumer(channel){
        	 @Override
             public void handleDelivery(String consumerTag, Envelope envelope,
                                        AMQP.BasicProperties properties, byte[] body)
                     throws IOException {
                 String message = new String(body, "UTF-8");
                 System.out.println(" [x] Received '" + message + "'");
             }
        };
        
        channel.basicConsume(queueName, true, consumer);
	}
}
