/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee.jms.service;

import com.sree.springannoemployee.jdbc.service.PersistEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreejithu.panicker
 */
@Component
public class EmployeeJmsListener implements MessageListener {
    @Autowired
    private PersistEmployee employee;
    @JmsListener(containerFactory = "listener", destination="DATA")
    @Override
    public void messageListenerforEmpployee(String msg){
        employee.WriteDatatoStore(msg);
        System.out.println(msg);
    }
}
