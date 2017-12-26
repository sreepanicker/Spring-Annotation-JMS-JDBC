/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee.jms.service;

import com.sree.springannoemployee.repository.Employee;
import javax.jms.TextMessage;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreejithu.panicker
 */
@Service
public class PublishEmployeeJmsService implements PublishEmployee {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void publishEmployeeDetails(Employee emp) {

        jmsTemplate.setDefaultDestinationName("DATA");
        jmsTemplate.send((session) -> {
            TextMessage msg = session.createTextMessage();
            String employeeJson;
            ObjectMapper object = new ObjectMapper();
            try {
                employeeJson = object.writeValueAsString(emp);
            } catch (Exception e) {
                employeeJson = "";
                System.out.println(e);
            }
            msg.setText(employeeJson);
            return msg;
        });

    }

}
