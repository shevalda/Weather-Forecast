package com.aeolus.view;

import net.miginfocom.swing.MigLayout;

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

public class SearchBar implements PartPanel {
    private JPanel panel = new JPanel();
    private JLabel label_logo;
    private JTextField searchField;
    private JButton searchButton;

    private String searchDefaultText = "Enter a city name (e.g. Bandung)";
    private String blank = "";

    private boolean inputValid = false;

    public SearchBar(String currentDir, String resourcePath) {
        panel.setLayout(new MigLayout("insets 5 0 5 0"));   // top left bottom right

        /* logo */
        String logoImageName = "app-logo.png";

        label_logo = new JLabel();
        ImageIcon logo = new ImageIcon(currentDir + resourcePath + logoImageName);
        label_logo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(50, 25, Image.SCALE_DEFAULT)));
        label_logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label_logo);

        /* search bar */
        searchField = new JTextField(searchDefaultText, 40);
        searchField.setHorizontalAlignment(JTextField.CENTER);
        searchField.setForeground(Color.GRAY);
        searchField.addMouseListener(new ListenForMouse());
        searchField.addKeyListener(new ListenForKeys());
        panel.add(searchField, "pushx, growx, pushy, growy");

        /* search button */
        String searchImageName = "search.png";
        try {
            BufferedImage searchicon = ImageIO.read(new File(currentDir + resourcePath + searchImageName));
            searchButton = new JButton(new ImageIcon(searchicon));
            searchButton.addMouseListener(new ListenForMouse());
            panel.add(searchButton);
        } catch (IOException e) {
            System.out.println("failed to find " + searchImageName);
        }

    }

    public JPanel getPanel() {
        return panel;
    }

    public String getSearchText() {
        return searchField.getText();
    }

    private boolean isSearchTextValid() {
        if (searchField.getText().equals(blank) || searchField.getText().equals(searchDefaultText)) {
            System.out.println("text error");
            searchField.setForeground(Color.GRAY);
            searchField.setText(searchDefaultText);
            return false;
        } else {
            System.out.println("text valid");
            return true;
        }
    }

    private void textFieldActive(JTextField textField) {
        textField.setForeground(Color.GRAY);
        textField.setText(searchDefaultText);
    }

    private void textFieldNotActive(JTextField textField) {
        textField.setForeground(Color.BLACK);
        textField.setText(blank);
    }

    private class ListenForMouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == searchField) {
                if (searchField.getText().equals(searchDefaultText)) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            } else if (e.getSource() == searchButton) {
                inputValid = isSearchTextValid();
            }
            else {
                if (searchField.getText().equals(blank)) {
                    searchField.setForeground(Color.GRAY);
                    searchField.setText(searchDefaultText);
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
                inputValid = isSearchTextValid();
            } else {
                if (searchField.getText().equals(searchDefaultText)) {
                    searchField.setForeground(Color.BLACK);
                    searchField.setText(blank);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}
