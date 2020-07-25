package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalDetails extends JFrame implements View {

    private final String userName;
    public PersonalDetails(String name){
        this.userName = name;
    }
    public String getUsername() {
        return userName;
    }

    @Override
    public void showScreen() {
        setSize(750, 750);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Font
        Font david20 = new Font("David", Font.PLAIN, 35);
        Font david16 = new Font("forget a password", Font.BOLD, 16);

        //label and button
        JLabel tellUsAboutYourself = new JLabel("Tell us about yourself ");
        tellUsAboutYourself.setBounds(170, 15, 450, 100);
        tellUsAboutYourself.setFont(david20);
        add(tellUsAboutYourself);
        JLabel phone = new JLabel("Phone");
        phone.setBounds(75, 100, 100, 100);
        phone.setFont(david16);
        add(phone);
        JTextField enterPhone = new JTextField("");
        enterPhone.setBounds(145, 142, 100, 20);
        add(enterPhone);
        JLabel city = new JLabel("City");
        city.setBounds(75, 130, 100, 100);
        city.setFont(david16);
        add(city);
        JTextField enterCity = new JTextField("");
        enterCity.setBounds(145, 172, 100, 20);
        add(enterCity);
        JLabel field = new JLabel("Field");
        field.setBounds(75, 160, 100, 100);
        field.setFont(david16);
        add(field);
        String[] optionBox = {"Profession","Electrician","Handyman","Technician"};
        JComboBox enterField = new JComboBox(optionBox);
        enterField.setBounds(145, 200, 100, 20);
        add(enterField);
        JLabel subField = new JLabel("Sub-field");
        subField.setBounds(75, 190, 100, 100);
        subField.setFont(david16);
        add(subField);
        JTextField enterSubfield = new JTextField("");
        enterSubfield.setBounds(145, 232, 100, 20);
        add(enterSubfield);
        JLabel experience = new JLabel("Experience");
        experience.setBounds(400, 100, 100, 100);
        experience.setFont(david16);
        add(experience);
        JTextField enterExperience = new JTextField("");
        enterExperience.setBounds(490, 142, 100, 20);
        add(enterExperience);
        JLabel area = new JLabel("area");
        area.setBounds(400, 130, 100, 100);
        area.setFont(david16);
        add(area);
        String[] optionArea = {"Area","center","north","south","west","east"};
        JComboBox enterArea = new JComboBox(optionArea);
        enterArea.setBounds(490, 172, 100, 20);
        add(enterArea);
        JButton done = new JButton("DONE");
        done.setBounds(635, 670, 100, 20);
        done.setFont(david16);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = MyController.getInstance().getUserType(getUsername()).toString();
                if(type.equals("contractor")) {
                    String phone = enterPhone.getText();
                    MyController.getInstance().setPhone(userName, phone);
                    String city = enterCity.getText();
                    MyController.getInstance().setCity(userName, city);
                    String experience = enterExperience.getText();
                    MyController.getInstance().setExperience(userName,experience);
                    String chooseArea = (String)enterArea.getSelectedItem();
                    MyController.getInstance().setArea(userName,chooseArea);
                    String enterF = (String)enterField.getSelectedItem();
                    MyController.getInstance().setField(userName,enterF);
                    String subfield = enterSubfield.getText();
                    MyController.getInstance().setSubfield(userName, subfield);
                    setVisible(false);
                    Contractor contractor = new Contractor(userName);
                    contractor.showScreen();
                }
                else if(type.equals("freelancer")){
                    String phone = enterPhone.getText();
                    MyController.getInstance().setPhone(userName, phone);
                    String city = enterCity.getText();
                    MyController.getInstance().setCity(userName, city);
                    String experience = enterExperience.getText();
                    MyController.getInstance().setExperience(userName,experience);
                    String chooseArea = (String)enterArea.getSelectedItem();
                    MyController.getInstance().setArea(userName,chooseArea);
                    String enterF = (String)enterField.getSelectedItem();
                    MyController.getInstance().setField(userName,enterF);
                    String subfield = enterSubfield.getText();
                    MyController.getInstance().setSubfield(userName, subfield);

                    setVisible(false);
                    Freelancer freelancer = new Freelancer(userName);
                    freelancer.showScreen();
                }
                else{
                    setVisible(false);
                    Consumer consumer = new Consumer(userName);
                    consumer.showScreen();
                }
            }
        });
        add(done);

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
        setVisible(true);
    }
}
