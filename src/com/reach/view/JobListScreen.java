package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobListScreen extends JFrame implements View
{
    protected static String userName;
    protected String userType;
    public JobListScreen(String userName){
        JobListScreen.userName = userName;
    }

    @Override
    public void showScreen()
    {
        setSize(950, 750);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon background_image = new ImageIcon("joblist.png");
        Image img = background_image.getImage();
        Image tmp_img = img.getScaledInstance(300, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(tmp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(610, 0, 300, 600);
        add(background);
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.PAGE_AXIS));
        main.setBounds(0,0,600,650);
        add(main);
        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david50 = new Font("David", Font.BOLD, 50);

        userType = MyController.getInstance().getUserType(userName).toString();
            if(userType.equals("customer")) {
                if (MyController.getInstance().getUserJobsSize(userName) > 0) {
                    int x = MyController.getInstance().getUserJobsSize(userName);
                    for (int i = 0; i < x; i++) {
                        String desc = MyController.getInstance().JobDescription(userName, i);
                        JLabel jobDescription = new JLabel("Description: " + desc);
                        jobDescription.setBounds(20, i * 50 + 100, 400, 30);
                        jobDescription.setFont(david20);
                        main.add(jobDescription);

                        JButton goTo = new JButton("See job details");
                        goTo.setBounds(350, i * 50 + 150, 200, 30);
                        goTo.setFont(david20);
                        goTo.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame parent = (JFrame)getRootPane().getParent();
                                int iDToPass = MyController.getInstance().JobID(userName,
                                        MyController.getInstance().JobID(userName,(goTo.getY()/50))-1);
                                JobScreen v1 = new JobScreen(parent,userName,iDToPass);
                                v1.showScreen();
                            }
                        });
                        main.add(goTo);
                    }
                } else {
                    JLabel empty = new JLabel("No jobs to display!");
                    empty.setBounds(500, 500, 100, 100);
                    empty.setFont(david50);
                    main.add(empty);
                }
            }
            else if(userType.equals("freelancer") || userType.equals("contractor")) {
                if (MyController.getInstance().getUserJobsSize(userName) > 0) {
                    int x = MyController.getInstance().getUserJobsSize(userName);
                    for (int i = 0; i < x; i++) {
                        String desc = MyController.getInstance().JobDescription(userName, i);
                        System.out.println(desc);
                        JLabel jobDescription = new JLabel("Description: " + desc);
                        jobDescription.setBounds(20, i * 50 + 100, 400, 30);
                        jobDescription.setFont(david20);
                        main.add(jobDescription);

                        int ID = MyController.getInstance().JobID(userName, i);
                        JLabel jobID = new JLabel("Job id: " + ID);
                        jobID.setBounds(20, i * 50 + 150, 200, 30);
                        jobID.setFont(david20);
                        main.add(jobID);

                        if (MyController.getInstance().JobAcceptance(userName, ID)) {
                            JLabel accept = new JLabel("Job accepted");
                            accept.setBounds(550, i * 50 + 150, 100, 30);
                            accept.setFont(david20);
                            main.add(accept);
                        } else if (!(MyController.getInstance().JobAcceptance(userName, ID))) {
                            JButton accept = new JButton("Accept?");
                            accept.setBounds(550, i * 50 + 150, 100, 30);
                            accept.setFont(david20);
                            accept.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if((MyController.getInstance().getJob(userName,ID).getPrice() != null)&&
                                            (MyController.getInstance().getJob(userName,ID).getDate() != null)&&
                                            (MyController.getInstance().getJob(userName,ID).getDeadline() != null)) {
                                        if (accept.getText() != "Accepted!") {
                                            MyController.getInstance().acceptJob(userName,
                                                    MyController.getInstance().getJobFromWorker(userName, ID),
                                                    ID);
                                            MyController.getInstance().JobSetAcceptance(userName, ID);
                                            accept.setText("Accepted!");
                                            main.setVisible(true);
                                            main.repaint();
                                            main.revalidate();
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Please go into:\n'See job details'\nand edit the missing fields");
                                    }
                                }
                            });
                            main.add(accept);
                        }

                        JButton goTo = new JButton("See job details");
                        goTo.setBounds(350, i * 50 + 150, 200, 30);
                        goTo.setFont(david20);
                        goTo.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame parent = (JFrame)getRootPane().getParent();
                                int iDToPass = MyController.getInstance().JobID(userName,ID-1);
                                JobScreen v1 = new JobScreen(parent,userName,ID);
                                v1.showScreen();
                            }
                        });
                        main.add(goTo);
                    }
                } else {
                    JLabel empty = new JLabel("No jobs to display!");
                    empty.setBounds(500, 500, 100, 100);
                    empty.setFont(david50);
                    main.add(empty);
                }
            }

        JButton home = new JButton("Home");
        home.setBounds(0, 670, 100, 30);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String userTypeReturned = MyController.getInstance().getUserType(userName).toString();
                    if(userTypeReturned.equals("customer")){throw new Exception("consumer");}
                    else if(userTypeReturned.equals("freelancer")){throw new Exception("freelancer");}
                    else if(userTypeReturned.equals("contractor")){throw new Exception("contractor");}
                }
                catch (Exception exc){
                    if(exc.getMessage().equals("consumer")){
                        setVisible(false);
                        Consumer v1 = new Consumer(userName);
                        v1.showScreen();
                    }
                    else if(exc.getMessage().equals("freelancer")){
                        setVisible(false);
                        Freelancer v1 = new Freelancer(userName);
                        v1.showScreen();
                    }
                    else if(exc.getMessage().equals("contractor")){
                        setVisible(false);
                        Contractor v1 = new Contractor(userName);
                        v1.showScreen();
                    }
                }
            }
        });
        add(home);

        JScrollPane scroll = new JScrollPane(main,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0,0,580,650);
        add(scroll);

        setVisible(true);
    }
}