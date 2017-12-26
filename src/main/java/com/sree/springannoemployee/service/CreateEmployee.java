/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee.service;

import com.sree.springannoemployee.jms.service.PublishEmployee;
import com.sree.springannoemployee.repository.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreejithu.panicker
 */
@Service
public class CreateEmployee implements CreateEmployeeService {

    @Autowired
    private Employee emp;
    @Autowired
    private PublishEmployee pubEmployee;

    @Override
    public String createEmployeeData(int id, String name) {
        emp.setId(id);
        emp.setName(name);
        pubEmployee.publishEmployeeDetails(emp);
        return "done";
    }

}
