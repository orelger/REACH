package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateJobScreen extends JFrame implements View {
    protected static String userName;
    protected static String watchedUserName;
    protected static JFrame parent;
    public CreateJobScreen(JFrame newParent,String newUsername,String newWatchedUser){
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

        //Labels and buttons
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(david20);
        descriptionLabel.setBounds(10,10,120,30);
        add(descriptionLabel);

        JTextArea description = new JTextArea("");
        description.setBounds(130,10,500,200);
        description.setBorder(BorderFactory.createLineBorder(Color.orange));
        add(description);

        JButton send = new JButton("Send");
        send.setBounds(630,320,100,30);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyController.getInstance().setNewJob(userName,watchedUserName,description.getText());
                parent.setVisible(true);
                dispose();
            }
        });
        add(send);

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
