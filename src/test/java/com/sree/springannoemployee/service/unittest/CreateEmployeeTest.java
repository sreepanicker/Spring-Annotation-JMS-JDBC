/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee.service.unittest;

import com.sree.springannoemployee.jdbc.service.PersistEmployee;
import com.sree.springannoemployee.jms.service.MessageListener;
import com.sree.springannoemployee.jms.service.PublishEmployee;
import com.sree.springannoemployee.repository.Employee;
import com.sree.springannoemployee.service.CreateEmployeeService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sreejithu.panicker
 */
public class CreateEmployeeTest {
    //Mockery for jMoke
    Mockery mock ;
    @Before
    public void createMockery(){
        mock = new Mockery();
    }

    @Test
    public void createEmployee() {
        final CreateEmployeeService emp = mock.mock(CreateEmployeeService.class);
        mock.checking(new Expectations() {{
            oneOf(emp);
            will(returnValue(("SREE")));

        }});
       String x1= emp.createEmployeeData(14,"sreejithu");
       System.out.println(x1);
       mock.assertIsSatisfied();
    }
    
    @Test
    public void publishEmployeeJmsService(){
        final PublishEmployee pubEmp = mock.mock(PublishEmployee.class);
        mock.checking(new Expectations() {{
            oneOf(pubEmp);
            //will();
        }});
        pubEmp.publishEmployeeDetails(new Employee());
        mock.assertIsSatisfied();
    }
    @Test
    public void WriteDataToJdbcStoreEmployee(){
        final PersistEmployee persistEmp = mock.mock(PersistEmployee.class);
        mock.checking(new Expectations(){{
            oneOf(persistEmp);
            
        }});
        persistEmp.WriteDatatoStore("Json String ");
        mock.assertIsSatisfied();
    }
    
    @Test
    public void JmsListnerGettingMessage(){
        final MessageListener listner = mock.mock(MessageListener.class);
        mock.checking(new Expectations() {{
            oneOf(listner);
            will(returnValue(null));
        }});
        listner.messageListenerforEmpployee("data");
        mock.assertIsSatisfied();
    }
}
