package com.reach.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestJob {
    Job check;
    Job check2;
    Price price;

     @Before
    public void setUp(){
         System.out.println("Setting Default Jobs");
       check = new Job("Moshe","Kobi","BlaBla",20);
       price = new Price("1000.5");
       check.setPrice(price);
       check.setDate("23/06/1995");
       check.setDeadline("23/07/1995");
       check.setAccepted();
       check2 = new Job(check,20);

       System.out.println();
     }
    @Test
    public void testConstructor(){
        System.out.println("Checking if constructor and setters are good");

        Assert.assertEquals("Date Equals","23/06/1995",check.getDate());
        Assert.assertEquals("DeadLine Equals","23/07/1995",check.getDeadline());
        Assert.assertEquals("Customer User Name Equals","Moshe",check.getCustomerUserName());
        Assert.assertEquals("Worker User Name Equals","Kobi",check.getWorkerUserName());
        Assert.assertEquals("Description Equals","BlaBla",check.getDescription());
        Assert.assertEquals("Price Equals",price,check.getPrice());
        Assert.assertEquals("Acceptance Equals",true,check.getAccepted());
        Assert.assertEquals("Id Equals",20,check.getId());

        System.out.println();
    }

     @Test
    public void testCopyConstructor(){
         System.out.println("Checking If Copy Succeeded");

         Assert.assertEquals("Date Equals",check2.getDate(),check.getDate());
         Assert.assertEquals("DeadLine Equals",check2.getDeadline(),check.getDeadline());
         Assert.assertEquals("Customer User Name Equals",check2.getCustomerUserName(),check.getCustomerUserName());
         Assert.assertEquals("Worker User Name Equals",check2.getWorkerUserName(),check.getWorkerUserName());
         Assert.assertEquals("Description Equals",check2.getDescription(),check.getDescription());
         Assert.assertEquals("Price Equals",check2.getPrice(),check.getPrice());
         Assert.assertEquals("Acceptance Equals",check2.getAccepted(),check.getAccepted());
         Assert.assertEquals("Id Equals",check2.getId(),check.getId());

         System.out.println();
     }

     @After
    public void afterTest(){
         System.out.println("Test is Done");
         System.out.println();
    }

}
