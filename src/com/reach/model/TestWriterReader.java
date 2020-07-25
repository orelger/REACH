package com.reach.model;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestWriterReader {

    WriterReader file;

    @Before
    public void setUp(){
        System.out.println("Before test");
        file = new WriterReader();
    }

    @Test
    public void testWriteToFile(){
        Customer customerCheckWrite = new Customer(UserType.customer,"orelger","Orel","Ger","1234qwer");
        customerCheckWrite.setPhone("0522454307");
        customerCheckWrite.setUserId(0);
        customerCheckWrite.setUserCity("Tel-aviv");
        file.save(customerCheckWrite);
        Customer customerCheckLoad = (Customer)file.load("orelger");
        Assert.assertEquals("verify user type","customer",customerCheckLoad.getUserType().toString());
        Assert.assertEquals("verify user name","orelger",customerCheckLoad.getUserName());
        Assert.assertEquals("verify first name","Orel",customerCheckLoad.getFirstName());
        Assert.assertEquals("verify last name","Ger",customerCheckLoad.getLastName());
        Assert.assertEquals("verify password","1234qwer",customerCheckLoad.getPassword());
        Assert.assertEquals("verify user id",0,customerCheckLoad.getUserId());
        Assert.assertEquals("verify user city","Tel-aviv",customerCheckLoad.getUserCity());
        Freelancer freelancerCheckWrite = new Freelancer(UserType.freelancer,"orelger1","Orel","Ger","1234qwer");
        freelancerCheckWrite.setUserId(1);
        file.save(freelancerCheckWrite);
        Freelancer freelancerCheckLoad = (Freelancer)file.load("orelger1");
        Assert.assertEquals("verify user id",1,freelancerCheckLoad.getUserId());
        Contractor contractorCheckWrite = new Contractor(UserType.contractor,"orelger2","Orel","Ger","1234qwer");
        contractorCheckWrite.setUserId(2);
        file.save(contractorCheckWrite);
        Contractor contractorCheckLoad = (Contractor)file.load("orelger2");
        Assert.assertEquals("verify user id",2,contractorCheckLoad.getUserId());
    }

    @After
    public void end(){
        System.out.println("Finished");
    }
}
