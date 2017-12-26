/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee;

import com.sree.springannoemployee.service.CreateEmployeeService;
import jdk.nashorn.internal.objects.annotations.SpecializedFunction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author sreejithu.panicker
 */

public class App {
    public static void main(String[] args){
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CreateEmployeeService employee = appContext.getBean(CreateEmployeeService.class);
        for(int i= 0 ; i < 5; i++){
            System.out.println(employee.createEmployeeData(20+i,"Sreejithu Panicker" + i));
        }
    }
}
