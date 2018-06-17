package com.aeolus.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenuView extends JFrame {

    private String resourcePath = "\\res\\";
    private String currentDir = System.getProperty("user.dir");
    private String searchDefaultText = "Enter a city name (e.g. Bandung)";
    private String blank = "";

    private JTextField citySearchField;
    private JButton searchButton;
    private JLabel logoImage, credit;
    private JPanel mainPanel;

    private boolean inputStatus = false;

    public MainMenuView() {
        this.setSize(600, 375);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aeolus");
        try {
            this.setIconImage(ImageIO.read(new File(currentDir + resourcePath + "favicon.png")));
        } catch (IOException e) {
            System.out.println("failed to get favicon");
        }

        mainPanel = new JPanel();
        Box mainBox = Box.createVerticalBox();

        mainBox.setMaximumSize(new Dimension(this.getWidth()+20, this.getHeight()));

        mainBox.add(Box.createVerticalStrut(50));

        /* logo */
        String logoImageName = "app-logo.png";

        logoImage = new JLabel();
        logoImage.setIcon(new ImageIcon(new ImageIcon(currentDir + resourcePath + logoImageName).getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT)));
        logoImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        Box logoBox = Box.createHorizontalBox();
        logoBox.add(logoImage);
        mainBox.add(logoBox);
        mainBox.add(Box.createVerticalStrut(15));

        /* search field */
        Box searchFieldBox = Box.createHorizontalBox();

        citySearchField = new JTextField(searchDefaultText, 40);
        citySearchField.setHorizontalAlignment(JTextField.CENTER);
        citySearchField.setForeground(Color.GRAY);

        citySearchField.addMouseListener(new ListenForMouse());
        citySearchField.addKeyListener(new ListenForKeys());
        searchFieldBox.add(citySearchField);
        searchFieldBox.add(Box.createHorizontalStrut(2));

        /* search button */
        String searchImageName = "search.png";
        try {
            BufferedImage searchicon = ImageIO.read(new File(currentDir + resourcePath + searchImageName));
            searchButton = new JButton(new ImageIcon(searchicon));
            searchButton.addMouseListener(new ListenForMouse());
            searchFieldBox.add(searchButton);
        } catch (IOException e) {
            System.out.println("failed to find " + searchImageName);
        }

        mainBox.add(searchFieldBox);
        mainBox.add(Box.createVerticalStrut(60));

        /* credits */
        credit = new JLabel("created by Shevalda Gracielira");
        Box creditBox = Box.createHorizontalBox();
        creditBox.add(credit);
        mainBox.add(creditBox);

        mainPanel.addMouseListener(new ListenForMouse());

        mainPanel.add(mainBox);
        this.add(mainPanel);
        this.setVisible(true);

        searchButton.requestFocusInWindow();
    }

    public String getSearchText() {
        return citySearchField.getText();
    }

    public boolean isInputSuccess() {
        return inputStatus;
    }

    private void searchTextChecking() {
        if (citySearchField.getText().equals(blank) || citySearchField.getText().equals(searchDefaultText)) {
            System.out.println("input error");
        } else {
            System.out.println("input success");
            inputStatus = true;
            System.out.println(inputStatus);
        }
    }

    private class ListenForMouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == citySearchField) {
                if (citySearchField.getText().equals(searchDefaultText)) {
                    citySearchField.setText("");
                    citySearchField.setForeground(Color.BLACK);
                }
            } else if (e.getSource() == searchButton) {
                searchTextChecking();
            }
            else {
                if (citySearchField.getText().equals(blank)) {
                    citySearchField.setForeground(Color.GRAY);
                    citySearchField.setText(searchDefaultText);
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }

    private class ListenForKeys implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == '\n') {
                searchTextChecking();
            } else {
                if (citySearchField.getText().equals(searchDefaultText)) {
                    citySearchField.setForeground(Color.BLACK);
                    citySearchField.setText(blank);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}
