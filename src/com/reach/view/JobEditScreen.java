package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JobEditScreen extends JFrame implements View {
    protected static JFrame parent;
    protected static String userName;
    protected static int ID;
    protected static JTextField UserEnterStartDate = new JTextField();
    protected static JTextField UserEnterEndDate = new JTextField();
    protected static JTextField UserEnterPrice = new JTextField();
    protected static Boolean passFlag = false;

    public JobEditScreen(JFrame parentNew, String userNamePassed, int jobID) {
        parent = parentNew;
        userName = userNamePassed;
        ID = jobID;
    }

    //Verify price text is valid and contains only numbers
    public boolean ValidPrice(String price){
        char digit;
        boolean boolDigit = false;
        boolean boolAlpha = false;
        boolean boolDotMax = true;
        for(int i=0;i < price.length() ;i++){
            if(price.contains("..") || price.contains("...")){
                boolDotMax = false;
            }
            if(boolAlpha && boolDigit)
            {return true;}
            digit = price.charAt(i);
            if(Character.isDigit(digit))
            {boolDigit = true;}
            else if(Character.isAlphabetic(digit))
            {boolAlpha = true;}
        }
        if((boolAlpha == false && boolDigit == true) && boolDotMax == true)
        {return true;}
        return false;
    }

    @Override
    public void showScreen() {
        setSize(700, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        parent.setVisible(false);
        //Font
        Font david20 = new Font("David", Font.BOLD, 17);

        JLabel StartDateLabel = new JLabel("Start date:");
        StartDateLabel.setFont(david20);
        StartDateLabel.setBounds(30,40,100,30);
        add(StartDateLabel);

        if(MyController.getInstance().getJob(userName,ID).getDate() != null){
            UserEnterStartDate.setText(MyController.getInstance().getJob(userName,ID).getDate());
            UserEnterStartDate.setForeground(Color.BLACK);
        }
        else{
            UserEnterStartDate.setText("XX/XX/XXXX");
            UserEnterStartDate.setForeground(Color.GRAY);
        }
        UserEnterStartDate.setBounds(130,40,100,30);
        UserEnterStartDate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                UserEnterStartDate.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(UserEnterStartDate.getText() == ""){
                    UserEnterStartDate.setText("XX/XX/XXXX");
                }
            }
        });
        add(UserEnterStartDate);

        JLabel EndDateLabel = new JLabel("End date:");
        EndDateLabel.setFont(david20);
        EndDateLabel.setBounds(30,90,100,30);
        add(EndDateLabel);

        if(MyController.getInstance().getJob(userName,ID).getDeadline() != null){
            UserEnterEndDate.setText(MyController.getInstance().getJob(userName,ID).getDeadline());
            UserEnterEndDate.setForeground(Color.BLACK);
        }
        else{
            UserEnterEndDate.setText("XX/XX/XXXX");
            UserEnterEndDate.setForeground(Color.GRAY);
        }
        UserEnterEndDate.setBounds(130,90,100,30);
        UserEnterEndDate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                UserEnterEndDate.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(UserEnterEndDate.getText().equals("")){
                    UserEnterEndDate.setText("XX/XX/XXXX");
                }
            }
        });
        add(UserEnterEndDate);

        JLabel PriceLabel = new JLabel("Price:");
        PriceLabel.setFont(david20);
        PriceLabel.setBounds(70,140,100,30);
        add(PriceLabel);

        if(MyController.getInstance().getJob(userName,ID).getPrice() != null &&
            MyController.getInstance().getJob(userName,ID).getPrice().getJobCost() != 0){
            UserEnterPrice.setText(""+MyController.getInstance().getJob(userName,ID).getPrice().getJobCost());
            UserEnterPrice.setForeground(Color.BLACK);
        }
        else{
            UserEnterPrice.setText("0.0"+" "+"ILS");
            UserEnterPrice.setForeground(Color.GRAY);
        }
        UserEnterPrice.setBounds(130,140,100,30);
        UserEnterPrice.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                UserEnterPrice.setText("");
                UserEnterPrice.setForeground(Color.GRAY);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(UserEnterPrice.getText().equals("")){
                    if(MyController.getInstance().getJob(userName,ID).getPrice() != null &&
                            MyController.getInstance().getJob(userName,ID).getPrice().getJobCost() != 0){
                        UserEnterPrice.setText(""+MyController.getInstance().getJob(userName,ID).getPrice().getJobCost());
                        UserEnterPrice.setForeground(Color.BLACK);
                    }
                    else{
                        UserEnterPrice.setText("0.0"+" "+"ILS");
                        UserEnterPrice.setForeground(Color.GRAY);
                    }
                }
                else{
                    if(ValidPrice(UserEnterPrice.getText())){
                        passFlag = true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please fix price\nuse no more than\none dot");
                        passFlag = false;
                    }
                }
            }
        });
        add(UserEnterPrice);

        JButton done = new JButton("Done");
        done.setBounds(550,300,100,30);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passFlag) {
                    MyController.getInstance().EditNewJob(MyController.getInstance().getJob(userName,ID).getCustomerUserName(),
                                                            userName,UserEnterStartDate.getText(),UserEnterEndDate.getText(),
                                                            UserEnterPrice.getText(),ID);
                    parent.setVisible(true);
                    parent.repaint();
                    parent.revalidate();
                    parent.dispose();
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please fix price");
                }
            }
        });
        add(done);

        JButton back = new JButton("Back");
        back.setBounds(0, 300, 100, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                parent.repaint();
                parent.revalidate();
                dispose();
            }
        });
        add(back);

        setVisible(true);
    }
}
