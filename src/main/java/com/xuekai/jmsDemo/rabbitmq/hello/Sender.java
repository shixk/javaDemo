package com.xuekai.jmsDemo.rabbitmq.hello;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {
	private final static String queueName="hello.hust";
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.120.124.172");
        
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        
        channel.queueDeclare(queueName, false, false, false, null);
        
        String message="hello BT/IT";
        channel.basicPublish("", queueName, null, message.getBytes());
        System.out.println("send message: " + message);

        channel.close();
        connection.close();
	}
}
