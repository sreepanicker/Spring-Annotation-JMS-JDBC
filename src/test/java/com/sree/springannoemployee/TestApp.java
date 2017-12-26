/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sree.springannoemployee;

import java.util.List;
import java.util.function.Consumer;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 *
 * @author sreejithu.panicker
 */
public class TestApp {

    public static void main(String[] args) {
        JUnitCore junitcore = new JUnitCore();
        junitcore.addListener(new RunListener() {

            @Override
            public void testFinished(Description desc) throws Exception {

                System.out.println(desc.getMethodName() + "\n");

            }

            @Override
            public void testRunFinished(Result result) throws Exception {
                System.out.printf("Failure count %d run count %d \n", result.getFailureCount(), result.getRunCount());
                if (result.getFailureCount() != 0) {
                    List<Failure> failure = result.getFailures();
                    failure.forEach((Failure fail) -> {
                        System.out.println(fail.getDescription());
                    });
                }
            }
            //result.
        });
        junitcore.run(AppTest.class);
    }
}
