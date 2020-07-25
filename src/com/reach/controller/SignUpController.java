package com.reach.controller;

import com.reach.model.CreateUser;
import com.reach.model.Model;
import com.reach.model.WriterReader;

public class SignUpController
{
    private static final SignUpController instance = new SignUpController();
    private static Model model;
    // SingleTone implementation //
    private SignUpController(){}

    public static SignUpController getInstance(){return instance;}
    // User Creator API
    public void createUser(String choice, String userName,String PrivateName,String LastName, String Password){
        new CreateUser().createUser(choice,userName,PrivateName,LastName,Password);
    }

    public boolean checkFreeUserName(String userName){
        boolean answer = WriterReader.checkFreeUserName(userName);
        return answer;
    }
}
