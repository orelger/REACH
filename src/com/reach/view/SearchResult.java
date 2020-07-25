package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchResult extends JFrame implements  View {
    String userName;
    String prof = SearchScreen.getProfession();
    String area = SearchScreen.getAreaBox();
    protected static JFrame parent;
    public SearchResult(String un,JFrame newParent){
        userName = un;
        parent = newParent;
    }

    @Override
    public void showScreen() {

        setSize(1000, 1000);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        parent.setVisible(false);
        ImageIcon background_image = new ImageIcon("search.jpg");
        Image img = background_image.getImage();
        Image tmp_img = img.getScaledInstance(690, 950, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(tmp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(310, 0, 690, 950);
        add(background);
        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david50 = new Font("forget a password", Font.PLAIN, 50);
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.PAGE_AXIS));
        main.setBounds(0,0,300,900);
        add(main);

        if (MyController.getInstance().getResultsSize(prof,area)>0)
        {
            int x = MyController.getInstance().getResultsSize(prof,area);
            for (int i = 0; i < x; i++)
            {
                JLabel number = new JLabel("Result number: " + (i+1));
                number.setFont(david20);
                number.setBounds(20, i * 50 + 100, 200, 30);
                main.add(number);

                String Name = MyController.getInstance().getResultsName(prof,area,i);
                JLabel name = new JLabel("Name: " + Name);
                name.setFont(david20);
                name.setBounds(20, i * 50 + 100, 200, 30);
                main.add(name);

                String Sub = MyController.getInstance().getResultsSub(prof,area,i);
                JLabel subField = new JLabel("Sub-field: " + Sub);
                subField.setBounds(20, i * 50 + 150, 200, 30);
                subField.setFont(david20);
                main.add(subField);

                JButton go = new JButton("Pick");
                go.setFont(david20);
                go.setBounds(400, i * 50 + 200, 200, 30);
                go.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String watchedUser = MyController.getInstance().getResultsUserName(prof,area,go.getY()/50);
                        JFrame parent = (JFrame)getRootPane().getParent();
                        SearchPickScreen v1 = new SearchPickScreen(parent,userName,watchedUser);
                        v1.showScreen();
                    }
                });
                main.add(go);

                JLabel space = new JLabel("\n");
                space.setBounds(10,10,10,10);
                main.add(space);
            }
        }
        else
            {
            JLabel empty = new JLabel("No matching results found");
            empty.setBounds(250, 250, 100, 100);
            empty.setFont(david50);
            main.add(empty);
        }
        JButton back = new JButton("Back");
        back.setBounds(0, 670, 100, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });
        add(back,"FIRST");

        JScrollPane scroll = new JScrollPane(main,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0,0,280,550);
        add(scroll);

        setVisible(true);
    }
}


