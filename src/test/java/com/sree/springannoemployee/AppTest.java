/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee;

import com.sree.springannoemployee.service.integrationtest.EmployeeService;
import com.sree.springannoemployee.service.unittest.CreateEmployeeTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author sreejithu.panicker
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CreateEmployeeTest.class,EmployeeService.class})
public class AppTest {
    
    public AppTest() {}
    
}
