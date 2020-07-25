package com.reach.view;

import javax.swing.*;

public class MyException extends Exception{

    private String exc;
    MyException(String exc){
        this.exc = exc;
    }
    public void print() {
        if(exc.equals("One field is empty"))
            JOptionPane.showMessageDialog(null, "One field is empty");
        if(exc.equals("The user or password are wrong"))
            JOptionPane.showMessageDialog(null, "The user or password are wrong");
    }
}
