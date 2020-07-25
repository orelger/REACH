package com.reach.model;

public class CreateUser implements  Model{

    protected WriterReader scanner = new WriterReader();
    protected User newOne;
    public CreateUser(){}

    public User createUser(String choice,String userName,String PrivateName, String LastName, String Password)
    {
        switch (choice){
            case "Consumer":
                newOne = new Customer(UserType.customer,userName,PrivateName,LastName,Password);
                scanner.save(newOne);
                return newOne;
            case "Contractor":
                newOne = new Contractor(UserType.contractor,userName,PrivateName,LastName,Password);
                scanner.save(newOne);
                return newOne;
            case "Freelancer":
                newOne = new Freelancer(UserType.freelancer,userName,PrivateName,LastName,Password);
                scanner.save(newOne);
                return newOne;
        }
        return null;
    }
}