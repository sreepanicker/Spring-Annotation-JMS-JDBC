/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee.service.integrationtest;

import com.sree.springannoemployee.AppConfig;
import com.sree.springannoemployee.jdbc.service.PersistEmployeeJdbcService;
import com.sree.springannoemployee.repository.Employee;
import com.sree.springannoemployee.service.CreateEmployee;
import com.sree.springannoemployee.service.CreateEmployeeService;
import org.codehaus.jackson.map.ObjectMapper;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author sreejithu.panicker
 */
public class EmployeeService {

    private Employee emp;
    private JdbcTemplate template;
    private PersistEmployeeJdbcService jdbcService;

    @Before
    public void createEmployeeInjection() {
        emp = new Employee();
        emp.setId(40);
        emp.setName("hello");
        template = new AppConfig().getJdbcTemplate();
        jdbcService = new PersistEmployeeJdbcService();
        jdbcService.setJdbcTemplate(template);
    }

    @Test
    public void CreateEmployee() {
        ObjectMapper mapper = new ObjectMapper();
        boolean success = false;
        try {
            jdbcService.WriteDatatoStore(mapper.writeValueAsString(emp));
            success = true;
        } catch (Exception e) {

        };
        assertEquals("Database Insert failed !", true, success);//service.createEmployeeData(50,"Sreejitu Panicker");
    }

}
