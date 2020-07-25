package com.reach.model;
import org.junit.Assert;

class CustomerTest {
    Customer testSubject;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testSubject = new Customer(UserType.customer,"KoKobi","Kobi","Hadad","ABCD1234");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("Test finished successfully.");
    }

    @org.junit.jupiter.api.Test
    void TestCustomer() {
       Assert.assertEquals("This users type is customer!",UserType.customer,testSubject.getUserType());
       testSubject.setPhone("0526891092");
       Assert.assertEquals("Phone number is 0526891092!","0526891092",testSubject.getPhone());
       testSubject.setUserCity("Holon");
       Assert.assertEquals("City is Holon!","Holon",testSubject.getUserCity());
       testSubject.setUserId(999);
       Assert.assertEquals("ID is 999!",999,testSubject.getUserId());
       testSubject.setFirstName("KOBIB");
       Assert.assertEquals("User first name changed to KOBIB!","KOBIB",testSubject.getFirstName());
       testSubject.setLastName("HAD");
       Assert.assertEquals("User last name changed to HAD!","HAD",testSubject.getLastName());
       testSubject.setPassword("AAAAA11111");
       Assert.assertEquals("Password changed to AAAAA11111!","AAAAA11111",testSubject.getPassword());
       testSubject.setUserName("KoKo");
       Assert.assertEquals("User name changed to KoKo!","KoKo",testSubject.getUserName());
       Assert.assertTrue("Job list is empty!",testSubject.getJobs().isEmpty());
       Assert.assertTrue("Job history list is empty!",testSubject.getJobsHistory().isEmpty());
    }
}