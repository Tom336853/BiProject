package com.yupi.springbootinit.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class MutiConsumer {

  private static final String TASK_QUEUE_NAME = "multi_queue2";

  public static void main(String[] argv) throws Exception {
      //建立连接
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    final Connection connection = factory.newConnection();

      for (int i = 0; i < 2; i++) {

          final Channel channel = connection.createChannel();

          channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
          System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

          channel.basicQos(1);

          //定义了如何处理消息
          int finalI = i;
          DeliverCallback deliverCallback = (consumerTag, delivery) -> {
              String message = new String(delivery.getBody(), "UTF-8");


              try {

                  try {
                      //处理工作
                      System.out.println(" [x] Received '" +"编号："+ finalI +":"+ message + "'");
                      //停20s，模拟工人处理任务有限
                      Thread.sleep(2000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

              } finally {
                  System.out.println(" [x] Done");
                  channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
              }
          };
          //开启消费监听
          channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> { });

      }

  }

}