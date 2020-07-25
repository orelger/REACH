package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPickScreen extends JFrame implements View {
    protected static String userName;
    protected static String watchedUserName;
    protected static JFrame parent;
    public SearchPickScreen(JFrame newParent,String newUsername,String newWatchedUser){
        parent = newParent;
        userName = newUsername;
        watchedUserName = newWatchedUser;
    }

    @Override
    public void showScreen() {

        setSize(750, 400);
        setForeground(Color.white);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Font
        Font david20 = new Font("David", Font.BOLD, 20);

        //Labels and Buttons
        JLabel fullName = new JLabel("Full name:");
        fullName.setFont(david20);
        fullName.setBounds(20,100,100,30);
        add(fullName);

        JLabel fullNameOfWatched = new JLabel(MyController.getInstance().getFirstName(watchedUserName)
                                        +" "+ MyController.getInstance().getLastName(watchedUserName));
        fullNameOfWatched.setBounds(130,100,200,30);
        fullNameOfWatched.setFont(david20);
        fullNameOfWatched.setBackground(Color.white);
        add(fullNameOfWatched);

        JLabel areaLabel = new JLabel("Area:");
        areaLabel.setFont(david20);
        areaLabel.setBounds(20,130,100,30);
        add(areaLabel);

        JLabel areaOfWatched = new JLabel(MyController.getInstance().getArea(watchedUserName));
        areaOfWatched.setFont(david20);
        areaOfWatched.setBounds(130,130,200,30);
        areaOfWatched.setBackground(Color.white);
        add(areaOfWatched);

        JLabel FieldLabel = new JLabel("Field:");
        FieldLabel.setFont(david20);
        FieldLabel.setBounds(20,160,100,30);
        add(FieldLabel);

        JLabel fieldOfWatched = new JLabel(MyController.getInstance().getField(watchedUserName));
        fieldOfWatched.setFont(david20);
        fieldOfWatched.setBounds(130,160,200,30);
        fieldOfWatched.setBackground(Color.white);
        add(fieldOfWatched);

        JLabel subFieldLabel = new JLabel("Sub-Field:");
        subFieldLabel.setFont(david20);
        subFieldLabel.setBounds(20,190,100,30);
        add(subFieldLabel);

        JLabel subFieldOfWatched = new JLabel(MyController.getInstance().getSubfield(watchedUserName));
        subFieldOfWatched.setFont(david20);
        subFieldOfWatched.setBounds(130,190,200,30);
        subFieldOfWatched.setBackground(Color.white);
        add(subFieldOfWatched);

        JLabel experienceLabel = new JLabel("Experience:");
        experienceLabel.setFont(david20);
        experienceLabel.setBounds(20,220,140,30);
        add(experienceLabel);

        JLabel expOfWatched = new JLabel(MyController.getInstance().getExperience(watchedUserName));
        expOfWatched.setFont(david20);
        expOfWatched.setBounds(160,220,200,30);
        expOfWatched.setBackground(Color.white);
        add(expOfWatched);

        JLabel cellLabel = new JLabel("Cellphone:");
        cellLabel.setFont(david20);
        cellLabel.setBounds(20,250,100,30);
        add(cellLabel);

        JLabel cellOfWatched = new JLabel(MyController.getInstance().getPhone(watchedUserName));
        cellOfWatched.setFont(david20);
        cellOfWatched.setBounds(130,250,200,30);
        cellOfWatched.setBackground(Color.white);
        add(cellOfWatched);

        JLabel userTypeLabel = new JLabel("Type:");
        userTypeLabel.setFont(david20);
        userTypeLabel.setBounds(20,280,100,30);
        add(userTypeLabel);

        JLabel typeOfWatched = new JLabel(MyController.getInstance().getUserType(watchedUserName).toString());
        typeOfWatched.setFont(david20);
        typeOfWatched.setBounds(130,280,200,30);
        typeOfWatched.setBackground(Color.white);
        add(typeOfWatched);

        JButton createJob = new JButton("Create Job!");
        createJob.setBackground(Color.green);
        createJob.setBounds(640,320,100,30);
        createJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame parent = (JFrame)getRootPane().getParent();
                CreateJobScreen v1 = new CreateJobScreen(parent,userName,watchedUserName);
                v1.showScreen();
            }
        });
        add(createJob);

        JButton back = new JButton("Back");
        back.setBounds(0, 320, 100, 30);
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
