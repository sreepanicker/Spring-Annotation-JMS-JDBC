/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee.jdbc.service;

import com.sree.springannoemployee.repository.Employee;
import java.sql.PreparedStatement;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreejithu.panicker
 */
@Component
public class PersistEmployeeJdbcService implements PersistEmployee {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    final String SQL = "INSERT INTO EMPLOYEE(ID,NAME) VALUES(?,?)";

    @Override
    public void WriteDatatoStore(String data) {
        System.out.println("called");
        jdbcTemplate.update((con) -> {
            PreparedStatement stmt =stmt = con.prepareStatement("INSERT INTO EMPLOYEE(ID,NAME) VALUES(?,?)");
            try {
                ObjectMapper mapper = new ObjectMapper();
                Employee emp = mapper.readValue(data, Employee.class);
                System.out.printf("Employe information %d %s \n", emp.getId(), emp.getName());
                stmt.setInt(1, emp.getId());
                stmt.setString(2, emp.getName());
            } catch (Exception e) {
                System.out.println(e);
            }
            return stmt;
        });
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
}
