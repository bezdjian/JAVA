package org.o7planning.Hibernate5;

import junit.framework.TestCase;
import org.o7planning.Hibernate5.entities.Department;
import org.o7planning.Hibernate5.entities.Employee;
import org.o7planning.Hibernate5.query.QueryObjectDemo;

import java.util.Date;

public class AppTest extends TestCase{

    /**
     *  Create the test case
     * @param name, name of the test case.
     */
    public AppTest(String name){
        super(name);

        System.out.println("------------ Before test");

        //Create Employee
        System.out.println("----- CREATE EMPLOYEE & DEPARTMENT-----");
        Department d = new Department(1, "IT Department", "Stockholm");
        long empid = 1;
        Employee e = new Employee(empid,"Harout Bezdjian", "Java Developer", null, new Date(15121315), new Float(50000), d);

        //INSERT
        System.out.println("----- INSERT -----");
        QueryObjectDemo.insert(e,d);

        //QUERY
        System.out.println("----- QUERY -----");
        //QueryObjectDemo.DoTheJob();
        System.out.println("After test");
    }

    /**
     * @return the suite of tests being tested

    public static Test suite(){
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test..
     */
    public void testApp(){
        //assertTrue(true);
    }
}
