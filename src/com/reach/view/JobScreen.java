package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobScreen extends JFrame implements View {

    protected String userName;
    protected static JFrame parent;
    protected static int jobID;
    protected static JLabel price = new JLabel();
    protected static JLabel end = new JLabel();
    protected static JLabel start = new JLabel();
    protected static JLabel workerUserName = new JLabel();
    protected static JLabel userNameLabel = new JLabel();
    protected static JTextArea description = new JTextArea();


    public JobScreen(JFrame parentPassed, String userNamePassed, int id) {
        parent = parentPassed;
        userName = userNamePassed;
        jobID = id;
        if(MyController.getInstance().getJob(userName,jobID).getPrice() != null) {
            price.setText("" + (MyController.getInstance().getJob(userName, jobID).getPrice().getJobCost()));
        }
        else {price.setText("Not edited yet");}
        if(MyController.getInstance().getJob(userName,jobID).getDate() != null){
        start.setText(MyController.getInstance().getJob(userName,jobID).getDate());}
        else {start.setText("XX/XX/XXXX");}
        if(MyController.getInstance().getJob(userName,jobID).getDeadline() != null){
        end.setText(MyController.getInstance().getJob(userName,jobID).getDeadline());}
        else { end.setText("XX/XX/XXXX");}
        userNameLabel.setText(MyController.getInstance().getFirstName(MyController.getInstance().getJob(userName,jobID).getCustomerUserName())
        +" "+ MyController.getInstance().getLastName(MyController.getInstance().getJob(userName,jobID).getCustomerUserName()));
        workerUserName.setText(MyController.getInstance().getFirstName(MyController.getInstance().getJob(userName,jobID).getWorkerUserName())
                +" "+ MyController.getInstance().getLastName(MyController.getInstance().getJob(userName,jobID).getWorkerUserName()));
        description.setText(MyController.getInstance().getJob(userName,jobID).getDescription());
        description.setEditable(false);
    }

    @Override
    public void showScreen()
    {

        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Font
        Font david20 = new Font("David", Font.BOLD, 17);

        JLabel userNameLable = new JLabel("Customer name: ");
        userNameLable.setBounds(20, 20, 200, 50);
        userNameLable.setFont(david20);
        add(userNameLable);

        userNameLabel.setBounds(160, 20, 230, 50);
        userNameLabel.setFont(david20);
        add(userNameLabel);

        JLabel workerUserNameLable = new JLabel("Contractor / Freelancer name: ");
        workerUserNameLable.setBounds(20, 70, 330, 50);
        workerUserNameLable.setFont(david20);
        add(workerUserNameLable);

        workerUserName.setBounds(260, 70, 230, 50);
        workerUserName.setFont(david20);
        add(workerUserName);

        JLabel startLabel = new JLabel("Start date: ");
        startLabel.setBounds(20, 120, 130, 50);
        startLabel.setFont(david20);
        add(startLabel);

        start.setBounds(160, 120, 200, 50);
        start.setFont(david20);
        add(start);

        JLabel endLabel = new JLabel("End date: ");
        endLabel.setBounds(20, 170, 130, 50);
        endLabel.setFont(david20);
        add(endLabel);

        end.setBounds(160, 170, 200, 50);
        end.setFont(david20);
        add(end);

        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setBounds(20, 220, 100, 50);
        priceLabel.setFont(david20);
        add(priceLabel);

        price.setBounds(160, 220, 140, 50);
        price.setFont(david20);
        add(price);

        JLabel descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setBounds(20, 270, 200, 50);
        descriptionLabel.setFont(david20);
        add(descriptionLabel);

        description.setBounds(200, 290, 300, 200);
        description.setFont(david20);
        add(description);

        if(!MyController.getInstance().getUserType(userName).toString().equals("customer")) {
            JButton edit = new JButton("Edit details");
            edit.setBounds(530, 550, 150, 30);
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame parentNew = (JFrame) getRootPane().getParent();
                    JobEditScreen v1 = new JobEditScreen(parentNew, userName, jobID);
                    v1.showScreen();
                }
            });
            add(edit);
        }

        JButton back = new JButton("Back");
        back.setBounds(0, 550, 100, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });
        add(back);

        setVisible(true);
    }
}
