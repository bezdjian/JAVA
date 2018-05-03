package org.o7planning.Hibernate5;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.o7planning.Hibernate5.query.QueryObjectDemo;

public class AppTest extends TestCase{

    /**
     *  Create the test case
     * @param name, name of the test case.
     */
    public AppTest(String name){
        super(name);

        System.out.println("Before test");
        QueryObjectDemo.runQueryObjectDemo();
        System.out.println("After test");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test..
     */
    public void testApp(){
        assertTrue(true);
    }
}
