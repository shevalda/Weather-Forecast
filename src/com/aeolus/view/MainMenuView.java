package com.aeolus.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

    public static void main(String[] args) {
        new MainMenuView();
    }

    public MainMenuView() {
        this.setSize(650, 500);
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

        /* logo */
        String logoImageName = "app-logo.png";
        try {
            BufferedImage logo = ImageIO.read(new File(currentDir+ resourcePath + logoImageName));
            logoImage = new JLabel(new ImageIcon(logo));
            mainPanel.add(logoImage);
        } catch (IOException e) {
            System.out.println("unable to load " + logoImageName);
        }

        /* search field */
        citySearchField = new JTextField(searchDefaultText,25);
        citySearchField.setHorizontalAlignment(JTextField.CENTER);
        citySearchField.setForeground(Color.GRAY);
        citySearchField.addMouseListener(new SearchFieldListener());
        mainPanel.add(citySearchField);

        /* search button */
        String searchImageName = "search.png";
        try {
            BufferedImage searchicon = ImageIO.read(new File(currentDir + resourcePath + searchImageName));
            searchButton = new JButton(new ImageIcon(searchicon));
            mainPanel.add(searchButton);
        } catch (IOException e) {
            System.out.println("failed to find " + searchImageName);
        }

        /* credits */
        credit = new JLabel("created by Shevalda Gracielira");
        mainPanel.add(credit);

        mainPanel.addMouseListener(new SearchFieldListener());

        this.add(mainPanel);
        this.setVisible(true);
    }

    private class SearchFieldListener implements MouseListener {
        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) {}

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == citySearchField) {
                if (citySearchField.getText().equals(searchDefaultText)) {
                    citySearchField.setText("");
                    citySearchField.setForeground(Color.BLACK);
                }
            } else if (e.getSource() == mainPanel && citySearchField.getText().equals(blank)) {
                citySearchField.setForeground(Color.GRAY);
                citySearchField.setText(searchDefaultText);
            }
        }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent e) {}

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {}

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {}
    }

}
