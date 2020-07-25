package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Freelancer extends JFrame implements View {

    private static String userName;

    public Freelancer(String name){
        userName = name;
    }

    public static String getUsername() {
        return userName;
    }

    @Override
    public void showScreen() {

        setSize(750, 750);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Font
        Font david16 = new Font("David", Font.BOLD, 16);

        //Labels and buttons
        JLabel freelancerReach = new JLabel("Freelancer Reach");
        freelancerReach.setBounds(550, 15, 350, 20);
        freelancerReach.setFont(david16);
        add(freelancerReach);

        JButton updateDetails = new JButton("Update Details");
        updateDetails.setBounds(200, 15, 140, 20);
        updateDetails.setFont(david16);
        updateDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PersonalDetails personalDetails = new PersonalDetails(userName);
                personalDetails.showScreen();
            }
        });
        add(updateDetails);

        JLabel userName = new JLabel("User Name: " + getUsername());
        userName.setBounds(75, 125, 350, 100);
        userName.setFont(david16);
        add(userName);

        JLabel firstName = new JLabel("First Name: "+ MyController.getInstance().getFirstName(getUsername()));
        firstName.setBounds(75, 155, 350, 100);
        firstName.setFont(david16);
        add(firstName);

        JLabel lastName = new JLabel("Last Name: "+ MyController.getInstance().getLastName(getUsername()));
        lastName.setBounds(75, 185, 350, 100);
        lastName.setFont(david16);
        add(lastName);

        if(MyController.getInstance().getPhone(getUsername())==null) {
            JLabel phone = new JLabel("Phone: ");
            phone.setBounds(75, 215, 100, 100);
            phone.setFont(david16);
            add(phone);
        }else{
            JLabel phone = new JLabel("Phone: "+MyController.getInstance().getPhone(getUsername()));
            phone.setBounds(75, 215, 200, 100);
            phone.setFont(david16);
            add(phone);
        }
        if(MyController.getInstance().getCity(getUsername())==null) {
            JLabel city = new JLabel("City: ");
            city.setBounds(75, 245, 100, 100);
            city.setFont(david16);
            add(city);
        }
        else{
            JLabel city = new JLabel("City: "+MyController.getInstance().getCity(getUsername()));
            city.setBounds(75, 245, 200, 100);
            city.setFont(david16);
            add(city);
        }
        if(MyController.getInstance().getField(getUsername())==null) {
            JLabel field = new JLabel("Field: ");
            field.setBounds(450, 125, 100, 100);
            field.setFont(david16);
            add(field);
        }else{
            JLabel field = new JLabel("Field: "+MyController.getInstance().getField(getUsername()));
            field.setBounds(450, 125, 300, 100);
            field.setFont(david16);
            add(field);
        }
        if(MyController.getInstance().getSubfield(getUsername())==null) {
            JLabel subField = new JLabel("Sub-field: ");
            subField.setBounds(450, 155, 100, 100);
            subField.setFont(david16);
            add(subField);
        }else{
            JLabel subField = new JLabel("Sub-field: "+MyController.getInstance().getSubfield(getUsername()));
            subField.setBounds(450, 155, 300, 100);
            subField.setFont(david16);
            add(subField);
        }
        if(MyController.getInstance().getExperience(getUsername())==null) {
            JLabel experience = new JLabel("Experience: ");
            experience.setBounds(450, 185, 100, 100);
            experience.setFont(david16);
            add(experience);
        }else{
            JLabel experience = new JLabel("Experience: "+MyController.getInstance().getExperience(getUsername()));
            experience.setBounds(450, 185, 150, 100);
            experience.setFont(david16);
            add(experience);
        }
        if(MyController.getInstance().getArea(getUsername())==null) {
            JLabel area = new JLabel("Area: ");
            area.setBounds(450, 215, 100, 100);
            area.setFont(david16);
            add(area);
        }else{
            JLabel area = new JLabel("Area: "+MyController.getInstance().getArea(getUsername()));
            area.setBounds(450, 215, 150, 100);
            area.setFont(david16);
            add(area);
        }

        JLabel availability = new JLabel("Availability: ");
        availability.setBounds(450, 245, 100, 100);
        availability.setFont(david16);
        add(availability);

        JButton onGoingJobs = new JButton("On-going Jobs");
        onGoingJobs.setBounds(380, 380, 140, 20);
        onGoingJobs.setFont(david16);
        onGoingJobs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JobListScreen jobList = new JobListScreen(getUsername());
                jobList.showScreen();
            }
        });
        add(onGoingJobs);

        JButton jobHistory = new JButton("Job History");
        jobHistory.setBounds(380, 450, 140, 20);
        jobHistory.setFont(david16);
        jobHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JobHistoryListScreen jobList = new JobHistoryListScreen(getUsername());
                jobList.showScreen();
            }
        });
        add(jobHistory);

        //Bg
        ImageIcon background_image = new ImageIcon("cus_freeBG.png");
        Image img = background_image.getImage();
        Image tmp_img = img.getScaledInstance(750, 750, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(tmp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 750, 750);
        add(background);

        setVisible(true);
    }
}
