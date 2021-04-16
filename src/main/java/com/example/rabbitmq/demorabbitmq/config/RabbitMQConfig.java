package com.example.rabbitmq.demorabbitmq.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;


//@Configuration
public class RabbitMQConfig {


    private String groupQueueName;
    private String exchangeName;
    private String address;
    private Integer port;
    private String userName;
    private String password;
    private String virtualHost;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory con = new CachingConnectionFactory();
        con.setPassword(password);
        con.setPort(port);
        con.setUsername(userName);
        con.setVirtualHost(virtualHost);
        con.setConnectionTimeout(1000);
        return con;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Queue createQueue() {
        return new Queue(groupQueueName, true);
    }

    @Bean
    public TopicExchange exchange(AmqpAdmin amqpAdmin) {
        TopicExchange exchange = new TopicExchange(exchangeName);
        exchange.setAdminsThatShouldDeclare(amqpAdmin);
        return exchange;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }


    //创建第二个连接工厂
    @Bean
    public ConnectionFactory tempConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setPort(port);
        connectionFactory.setAddresses(address);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("temp");
        connectionFactory.setConnectionTimeout(1000);
        return connectionFactory;
    }

    //第二个管理
    @Bean
    public AmqpAdmin tempAdmin(ConnectionFactory tempConnectionFactory) {
        return new RabbitAdmin(tempConnectionFactory);
    }

    //创建一个交换机，关联到tempAdmin这个上面
    @Bean
    TopicExchange tempExchange(AmqpAdmin tempAdmin) {
        TopicExchange exchange = new TopicExchange("topic.A");
        exchange.setAdminsThatShouldDeclare(tempAdmin);
        return exchange;
    }

    //创建第二个template
    @Bean
    RabbitTemplate tempRabbitTemplate(ConnectionFactory tempConnectionFactory) {
        return new RabbitTemplate(tempConnectionFactory);
    }


    //设置一个简单监听工厂。
    @Bean
    public SimpleRabbitListenerContainerFactory tempListenerContainerFactory(ConnectionFactory tempConnectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(tempConnectionFactory);
        return factory;
    }


}
