/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee.jms.service;

import com.sree.springannoemployee.repository.Employee;

/**
 *
 * @author sreejithu.panicker
 */
public interface PublishEmployee {
    public void publishEmployeeDetails(Employee emp);
    
}
