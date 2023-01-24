/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee;

import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import javax.jms.ConnectionFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;
import org.springframework.jms.core.JmsTemplate;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

/**
 *
 * @author sreejithu.panicker
 */
@Configuration
@ComponentScan(basePackages = {"com.sree.springannoemployee"})
@EnableJms
public class AppConfig {

    //MQ connection factory settings 
    @Bean(name = "MQConnection")
    public ConnectionFactory getMQConnectionFactory(){
        UserCredentialsConnectionFactoryAdapter connectionFactory = new UserCredentialsConnectionFactoryAdapter();
        connectionFactory.setTargetConnectionFactory(getConnectionFactory()); 
        connectionFactory.setUsername("XXXX");
        connectionFactory.setPassword("XXXX");
        return connectionFactory;     
    }
    
    public MQConnectionFactory getConnectionFactory() {
        MQConnectionFactory factory =null;
        try {
            factory = new MQConnectionFactory();
            factory.setChannel("MDS");
            factory.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
            factory.setHostName("127.0.0.1");
            factory.setQueueManager("TEST");

            factory.setTransportType(1);
            factory.setClientReconnectOptions(WMQConstants.WMQ_CLIENT_RECONNECT_Q_MGR);
            factory.setClientReconnectTimeout(3600);
            factory.setPort(1414);
           // return factory;
        } catch (Exception e) {
            System.out.print(e);
        }
         return factory;
    }
    //JMSTemplate 
    @Bean
    public JmsTemplate getJmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(getMQConnectionFactory());
        return jmsTemplate;
    }
    
    //JMS Listener Object
    @Bean(name = {"listener"})
    public DefaultJmsListenerContainerFactory getMqConnection() {
        DefaultJmsListenerContainerFactory defaultFactory = new DefaultJmsListenerContainerFactory();
        UserCredentialsConnectionFactoryAdapter connectionFactory = new UserCredentialsConnectionFactoryAdapter();
        connectionFactory.setTargetConnectionFactory(getConnectionFactory()); 
        connectionFactory.setUsername("XXXX");
        connectionFactory.setPassword("XXXXX");
        defaultFactory.setConnectionFactory(connectionFactory);
        return defaultFactory;
    }
   
    
    @Bean 
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
    
    public DataSource getDataSource(){
        SQLiteConnectionPoolDataSource dataSource = new SQLiteConnectionPoolDataSource();
        dataSource.setUrl("jdbc:sqlite:C:/sqllite/SREE");
        return dataSource;
    }
}
