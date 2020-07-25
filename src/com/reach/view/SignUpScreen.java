package com.reach.view;

import com.reach.controller.SignUpController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SignUpScreen extends JFrame implements View {
    protected static JLabel background;
    protected static JTextField enterUserName;
    protected static JTextField enterPrivateName;
    protected static JTextField enterLastName;
    protected static JPasswordField enterPassword;
    protected static JPasswordField enterConfirmedPassword;
    protected static ButtonModel selection;
    protected static ButtonGroup group;
    protected static JLabel passwordsMatchMsg;
    protected static String secondPassInputForValidation = "";
    protected static String firstPassInputForValidation = "";
    protected static String checkFreeUserName;
    protected static JLabel userNameValidationMsg;
    protected static JLabel useLettersNumbers;
    protected static boolean DoneFlag = false;
    protected static boolean userNameFlag = false;
    protected static boolean passwordsFlag = false;
    protected static boolean firstNameFlag = false;
    protected static boolean lastNameFlag = false;
    protected static SignUpController Controller = SignUpController.getInstance();
    public static JTextField getUsername(){
        return enterUserName;
    }
    public void setDoneFlag(boolean value){
        DoneFlag = value;
    }
    public boolean getDoneFlag(){
        return DoneFlag;
    }
    public boolean ValidPassDigitAndInteger(String Pass){
        char digit;
        boolean boolDigit = false;
        boolean boolAlpha = false;
        for(int i=0;i < Pass.length() ;i++){
            if(boolAlpha && boolDigit)
            {return true;}
            digit = Pass.charAt(i);
            if(Character.isDigit(digit))
            {boolDigit = true;}
            else if(Character.isAlphabetic(digit))
            {boolAlpha = true;}
        }
        if(boolAlpha && boolDigit)
        {return true;}
        return false;
    }

    @Override
    public void showScreen() {
        setSize(750, 750);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("REACH Account registration");

        //Font
        Font david30 = new Font("David", Font.BOLD, 30);
        Font david15 = new Font("forget a password", Font.PLAIN, 15);
        Font david12 = new Font("forget a password",Font.ITALIC,12);

        JPanel panelForConfirmPassValidation = new JPanel();
        panelForConfirmPassValidation.setBounds(383, 226, 160, 35);
        panelForConfirmPassValidation.setBackground(new Color(0,0,0,0));
        add(panelForConfirmPassValidation);

        JPanel panelForUserNameValidation = new JPanel();
        panelForUserNameValidation.setBounds(260, 181, 150, 20);
        panelForUserNameValidation.setBackground(new Color(0,0,0,0));
        add(panelForUserNameValidation);

        JLabel create_reach_account = new JLabel("Create REACH account");
        create_reach_account.setBounds(15, 10, 450, 100);
        create_reach_account.setFont(david30);
        add(create_reach_account);

        //JLabel
        JLabel firstName = new JLabel("First Name");
        firstName.setBounds(15, 100, 100, 100);
        firstName.setFont(david15);
        add(firstName);

        JLabel firstNameStar = new JLabel("*");
        firstNameStar.setBounds(260,145,30,20);
        firstNameStar.setFont(david12);
        firstNameStar.setForeground(Color.red);
        add(firstNameStar);

        JLabel lastNameStar = new JLabel("*");
        lastNameStar.setBounds(538,145,30,20);
        lastNameStar.setFont(david12);
        lastNameStar.setForeground(Color.red);
        add(lastNameStar);

        //JTextField
        enterPrivateName = new JTextField("");
        enterPrivateName.setBounds(108, 145, 150, 20);
        enterPrivateName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            enterPrivateName.setText("");
            setDoneFlag(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    if(!(enterPrivateName.getText().equalsIgnoreCase(""))){
                       throw new Exception("Not empty");
                    }
                    else{
                        throw new Exception("Empty");
                    }
                }
                catch (Exception exc){
                    if(exc.getMessage().equals("Not empty")){
                        firstNameFlag = true;
                        firstNameStar.setText("√");
                        firstNameStar.setFont(david15);
                        firstNameStar.setForeground(Color.green);
                    }
                    if(exc.getMessage().equals("Empty")){
                        firstNameFlag = false;
                        firstNameStar.setText("*");
                        firstNameStar.setFont(david12);
                        firstNameStar.setForeground(Color.red);
                    }
                    if((lastNameFlag&&firstNameFlag)&&(userNameFlag&&passwordsFlag)){
                        setDoneFlag(true);}
                }
            }
        });
        add(enterPrivateName);

        //Jlabel
        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(308, 100, 100, 100);
        lastName.setFont(david15);
        add(lastName);

        //JTextField
        enterLastName = new JTextField("");
        enterLastName.setBounds(385, 145, 150, 20);
        enterLastName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                enterLastName.setText("");
                setDoneFlag(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    if(enterLastName.getText().equals("")){
                        throw new Exception("Empty");
                    }
                    else{
                        throw new Exception("Not empty");
                    }
                }
                catch (Exception exc){
                    if(exc.getMessage().equals("Empty")){
                        lastNameFlag = false;
                        lastNameStar.setText("*");
                        lastNameStar.setFont(david12);
                        lastNameStar.setForeground(Color.red);
                    }
                    if(exc.getMessage().equals("Not empty")) {
                        lastNameFlag = true;
                        lastNameStar.setText("√");
                        lastNameStar.setFont(david15);
                        lastNameStar.setForeground(Color.green);
                        }
                    if((lastNameFlag&&firstNameFlag)&&(userNameFlag&&passwordsFlag)){
                        setDoneFlag(true);
                    }
                }
            }
        });
        add(enterLastName);

        //Jlabel
        JLabel userName = new JLabel("User Name");
        userName.setBounds(15, 140, 100, 100);
        userName.setFont(david15);
        add(userName);

        //JTextField
        enterUserName = new JTextField("");
        enterUserName.setBounds(108, 181, 150, 20);
        enterUserName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                enterUserName.setText("");
                setDoneFlag(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
            checkFreeUserName = enterUserName.getText();
            try{
                if(checkFreeUserName.equals("") && !(userNameValidationMsg.getText().equals("Illegal username"))){
                    throw new Exception("Illegal");
                }
                else if(Controller.checkFreeUserName(checkFreeUserName) && !(checkFreeUserName.equals(""))){
                    throw new Exception("V");
                }
                else if(!(Controller.checkFreeUserName(checkFreeUserName)) && !(checkFreeUserName.equals(""))){
                    throw new Exception("Username already exists");
                }
            }
            catch (Exception exc){
                if(exc.getMessage().equals("Illegal")){
                    panelForUserNameValidation.removeAll();
                    userNameValidationMsg.setText("Illegal username");
                    userNameValidationMsg.setFont(david12);
                    userNameValidationMsg.setForeground(Color.red);
                    panelForUserNameValidation.setBounds(240,181, 150, 20);
                    panelForUserNameValidation.add(userNameValidationMsg);
                    panelForUserNameValidation.setVisible(true);
                    panelForUserNameValidation.repaint();
                    panelForUserNameValidation.revalidate();
                    userNameFlag=false;
                }
                if(exc.getMessage().equals("V")){
                    panelForUserNameValidation.removeAll();
                    userNameValidationMsg.setText("√");
                    userNameValidationMsg.setFont(david15);
                    userNameValidationMsg.setForeground(Color.green);
                    panelForUserNameValidation.setVisible(false);
                    panelForUserNameValidation.setBounds(190,176, 150, 30);
                    panelForUserNameValidation.add(userNameValidationMsg);
                    panelForUserNameValidation.setVisible(true);
                    panelForUserNameValidation.repaint();
                    panelForUserNameValidation.revalidate();
                    userNameFlag = true;
                }
                if(exc.getMessage().equals("Username already exists")){
                    panelForUserNameValidation.removeAll();
                    userNameValidationMsg.setText("Username already exists");
                    userNameValidationMsg.setFont(david12);
                    userNameValidationMsg.setForeground(Color.red);
                    panelForUserNameValidation.setBounds(250,181, 150, 20);
                    panelForUserNameValidation.add(userNameValidationMsg);
                    panelForUserNameValidation.setVisible(true);
                    panelForUserNameValidation.repaint();
                    panelForUserNameValidation.revalidate();
                    userNameFlag=false;
                }
                if((lastNameFlag&&firstNameFlag)&&(userNameFlag&&passwordsFlag)){
                    setDoneFlag(true);}
            }
            }
        });
        add(enterUserName);

        //Jlabel
        JLabel password = new JLabel("Password");
        password.setBounds(15, 174, 100, 100);
        password.setFont(david15);
        add(password);

        //JTextField
        enterPassword = new JPasswordField("");
        enterPassword.setText("At least 6 characters");
        enterPassword.setEchoChar((char) 0);
        enterPassword.setForeground(Color.gray);
        enterPassword.setBounds(108, 215, 150, 20);
        enterPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                firstPassInputForValidation = "";
                useLettersNumbers.setText("Use letters and numbers");
                useLettersNumbers.setForeground(Color.black);
                setVisible(true);
                repaint();
                revalidate();
                setDoneFlag(false);
                if(firstPassInputForValidation.length()==0) {
                    enterPassword.setText("");
                    enterPassword.setEchoChar('*');
                }
                enterConfirmedPassword.setText("");
                panelForConfirmPassValidation.removeAll();
                panelForConfirmPassValidation.setVisible(false);
                panelForConfirmPassValidation.repaint();
                panelForConfirmPassValidation.revalidate();
            }

            @Override
            public void focusLost(FocusEvent e) {
                firstPassInputForValidation = new String(enterPassword.getPassword());
                if(firstPassInputForValidation.length()==0){
                    enterPassword.setText("At least 6 characters");
                    enterPassword.setEchoChar((char) 0);
                    enterPassword.setForeground(Color.gray);
                }
                try {
                    if (!ValidPassDigitAndInteger(firstPassInputForValidation)) { throw new Exception("Not valid"); }
                    else if(ValidPassDigitAndInteger(firstPassInputForValidation) &&
                            (firstPassInputForValidation.length()>5 || firstPassInputForValidation.length() == 0)
                            ) { throw new Exception(("Valid")); }
                    else if(firstPassInputForValidation.length() <6 &&
                            firstPassInputForValidation.length() > 0){throw new Exception("Short Password");}
                }
                catch (Exception exc)
                {
                    if(exc.getMessage().equalsIgnoreCase("Not valid"))
                    {
                        useLettersNumbers.setText("Use letters and numbers");
                        useLettersNumbers.setForeground(Color.red);
                        setVisible(true);
                        repaint();
                        revalidate();
                    }
                    if(exc.getMessage().equalsIgnoreCase("Valid")){
                        useLettersNumbers.setText("Good password");
                        useLettersNumbers.setForeground(Color.green);
                        setVisible(true);
                        repaint();
                        revalidate();
                    }
                    if(exc.getMessage().equalsIgnoreCase("Short Password")){
                        useLettersNumbers.setText("Password is too short!");
                        useLettersNumbers.setForeground(Color.red);
                    }
                }
            }
        });
        add(enterPassword);

        //Jlabel
        JLabel confirmedPassword = new JLabel("Confirm Password");
        confirmedPassword.setBounds(260, 215, 130, 20);
        confirmedPassword.setFont(david15);
        add(confirmedPassword);

        //JTextField
        enterConfirmedPassword = new JPasswordField("");
        enterConfirmedPassword.setBounds(385, 215, 150, 20);
        enterConfirmedPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                firstPassInputForValidation = new String(enterPassword.getPassword()); // for comparing passwords
                enterConfirmedPassword.setText("");
                panelForConfirmPassValidation.removeAll();
                panelForConfirmPassValidation.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent e) {
                secondPassInputForValidation = new String(enterConfirmedPassword.getPassword()); // for comparing passwords
                try {
                    if(firstPassInputForValidation.length()>0
                            && !(firstPassInputForValidation.equalsIgnoreCase("At least 6 characters"))) {
                        if (!(firstPassInputForValidation.equals(secondPassInputForValidation))
                                && !(firstPassInputForValidation.equalsIgnoreCase(""))) {
                            throw new Exception("Passwords do not match");
                        } else if (firstPassInputForValidation.equals(secondPassInputForValidation)
                                && !(firstPassInputForValidation.equalsIgnoreCase(""))) {
                            throw new Exception("Passwords match");
                        }
                    }
                }
                catch (Exception exc)
                {
                    if(exc.getMessage().equalsIgnoreCase("Passwords do not match")){
                        passwordsMatchMsg.setText("Passwords do not match");
                        passwordsMatchMsg.setForeground(Color.red);
                        passwordsMatchMsg.setBounds(230, 190, 150, 20);
                        panelForConfirmPassValidation.add(passwordsMatchMsg);
                        panelForConfirmPassValidation.setVisible(true);
                        panelForConfirmPassValidation.repaint();
                        panelForConfirmPassValidation.revalidate();
                        passwordsFlag=false;
                    }
                    if(exc.getMessage().equalsIgnoreCase("Passwords match")){
                        passwordsMatchMsg.setText("Passwords match");
                        passwordsMatchMsg.setForeground(Color.green);
                        passwordsMatchMsg.setBounds(230, 190, 150, 20);
                        panelForConfirmPassValidation.add(passwordsMatchMsg);
                        panelForConfirmPassValidation.setVisible(true);
                        panelForConfirmPassValidation.repaint();
                        panelForConfirmPassValidation.revalidate();
                        passwordsFlag=true;
                    }
                    if((lastNameFlag&&firstNameFlag)&&(userNameFlag&&passwordsFlag)){
                        setDoneFlag(true);}
                }
            }
        });
        add(enterConfirmedPassword);

        //Jlabel
        useLettersNumbers = new JLabel("Use letters and numbers");
        useLettersNumbers.setBounds(106, 190, 160, 100);
        useLettersNumbers.setFont(david12);
        add(useLettersNumbers);

        passwordsMatchMsg = new JLabel("");
        passwordsMatchMsg.setBounds(383, 200, 160, 75);
        passwordsMatchMsg.setFont(david12);
        passwordsMatchMsg.setForeground(Color.red);

        userNameValidationMsg = new JLabel("");
        userNameValidationMsg.setBounds(230, 181, 150, 20);
        userNameValidationMsg.setFont(david12);

        JButton done = new JButton("Done");
        done.setBounds(635, 670, 100, 30);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getDoneFlag()) {
                    setVisible(false);
                    Controller.createUser(getSelection(), enterUserName.getText(),
                            enterPrivateName.getText(), enterLastName.getText(),
                            firstPassInputForValidation);
                    JOptionPane.showMessageDialog(null, "Sign up successfully");
                    MainPanel v1 = new MainPanel();
                    v1.showScreen();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Some field missing");
                }
            }
        });
        add(done);

        JButton home = new JButton("Home");
        home.setBounds(0, 670, 100, 30);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainPanel v1 = new MainPanel();
                v1.showScreen();
            }
        });
        add(home);

        // create radio buttons and labels
        JLabel tChoice = new JLabel("User type define:");
        tChoice.setBounds(15,250,400,50 );
        tChoice.setFont(david30);

        JRadioButton consumer = new JRadioButton("Consumer");
        consumer.setActionCommand("Consumer");
        consumer.setBackground(Color.white);
        consumer.setBounds(270,340 ,100 ,20 );
        consumer.setSelected(true);

        JRadioButton freelancer = new JRadioButton("Freelancer");
        freelancer.setActionCommand("Freelancer");
        freelancer.setBackground(Color.white);
        freelancer.setBounds(270,370,100,20 );

        JRadioButton contractor = new JRadioButton("Contractor");
        contractor.setActionCommand("Contractor");
        contractor.setBackground(Color.white);
        contractor.setBounds(270,400,100,20 );

        // create radio group
        group = new ButtonGroup();
        group.add(consumer);
        group.add(freelancer);
        group.add(contractor);
        add(consumer);
        add(freelancer);
        add(contractor);
        add(tChoice);
        selection = group.getSelection();

        //Bg
        ImageIcon background_image = new ImageIcon("securityBg1.png");
        Image img = background_image.getImage();
        Image tmp_img = img.getScaledInstance(750, 750, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(tmp_img);
        background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 750, 700);
        add(background);

        setVisible(true);
    }
    public String getSelection() {
        return group.getSelection().getActionCommand();
    }
}
