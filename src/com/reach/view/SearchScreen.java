package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchScreen extends JFrame implements  View{

    private final String userName;
    private static JComboBox profession;
    private static JComboBox areaBox;

    public SearchScreen(String userName){
        this.userName =userName;
    }

    public String getUserName() {
        return userName;
    }

    public static String getAreaBox() {
        return (String) areaBox.getSelectedItem();
    }

    public static String getProfession() {
        return (String) profession.getSelectedItem();
    }

    @Override
    public void showScreen() {

        setSize(750, 750);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Font
        Font david30 = new Font("David", Font.BOLD, 30);
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david15 = new Font("forget a password", Font.PLAIN, 15);

        //Labels and Buttons
        JLabel userName = new JLabel("Hello " + getUserName());
        userName.setBounds(265, 105, 400, 100);
        userName.setFont(david20);
        add(userName);
        JLabel whatAreYouLookingFor = new JLabel("What Are You Looking For :");
        whatAreYouLookingFor.setBounds(190, 150, 450, 100);
        whatAreYouLookingFor.setFont(david20);
        add(whatAreYouLookingFor);

        String[] optionBox = {"Profession","Electrician","Handyman","Technician"};
        profession = new JComboBox(optionBox);
        profession.setBounds(130, 240, 100, 20);
        add(profession);
        String[] area = {"Area","center","north","south","west","east"};
        areaBox = new JComboBox(area);
        areaBox.setBounds(255, 240, 100, 20);
        add(areaBox);
        JButton search = new JButton("Search");
        search.setBounds(375, 240, 110, 20);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame parent = (JFrame)getRootPane().getParent();
                SearchResult v1 = new SearchResult(getUserName(),parent);
                v1.showScreen();
            }
        });
        add(search);

        JButton home = new JButton("Home");
        home.setBounds(0, 670, 100, 30);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String userTypeReturned = MyController.getInstance().getUserType(getUserName()).toString();
                    if(userTypeReturned.equals("customer")){throw new Exception("consumer");}
                    else if(userTypeReturned.equals("freelancer")){throw new Exception("freelancer");}
                    else if(userTypeReturned.equals("contractor")){throw new Exception("contractor");}
                }
                catch (Exception exc){
                    if(exc.getMessage().equals("consumer")){
                        setVisible(false);
                        Consumer v1 = new Consumer(getUserName());
                        v1.showScreen();
                    }
                    else if(exc.getMessage().equals("freelancer")){
                        setVisible(false);
                        Freelancer v1 = new Freelancer(getUserName());
                        v1.showScreen();
                    }
                    else if(exc.getMessage().equals("contractor")){
                        setVisible(false);
                        Contractor v1 = new Contractor(getUserName());
                        v1.showScreen();
                    }
                }
            }
        });
        add(home);

        //Bg
        ImageIcon background_image = new ImageIcon("LogInBG.png");
        Image img = background_image.getImage();
        Image tmp_img = img.getScaledInstance(750, 750, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(tmp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 750, 750);
        add(background);

        setVisible(true);
    }
}
