package com.aeolus.view;

import com.aeolus.app.SearchProcessor;
import com.aeolus.utils.InFont;
import com.aeolus.utils.InPath;
import com.aeolus.view.current.ResultSection;
import com.aeolus.view.current.SearchBar;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

public class MainFrame {
    private JFrame frame = new JFrame("Aeolus");
    private JPanel panel_main, panel_searchbar, panel_result;
    private JTextField textField_search;
    private JButton button_search;
    private JLabel label_resultText;
    private String search_input = "";

    private ResultSection resultSection;
    private SearchBar searchBar;
    private InFont inFont = new InFont();

    private String searchDefaultText = "Try \"Bandung\" or \"Jakarta\"";
    private String blank = "";

    public MainFrame() {
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            frame.setIconImage(ImageIO.read(new File(InPath.getResourceDirectory("favicon.png"))));
        } catch (IOException e) {
            System.out.println("failed to get favicon");
        }

        panel_main = new JPanel();
        panel_main.setLayout(new MigLayout());
        panel_main.addMouseListener(new ListenForMouse());

        /*** search bar ***/
        textField_search = new JTextField(searchDefaultText, 42);
        textField_search.addMouseListener(new ListenForMouse());
        textField_search.addKeyListener(new ListenForKeys());
        button_search = new JButton();
        button_search.addMouseListener(new ListenForMouse());

        searchBar = new SearchBar(textField_search, button_search);
        panel_searchbar = searchBar.getPanel();
        panel_main.add(panel_searchbar, "span, growx, pushx, gapleft 10, gapright 10");

        /*** result section ***/
        label_resultText = new JLabel();
        resultSection = new ResultSection(label_resultText);
        panel_result = resultSection.getPanel();
        panel_main.add(panel_result, "span, growx, pushx, , gapleft 10, gapright 10");

        /*** credit ***/
        JLabel label_credit = new JLabel("created by Shevalda Gracielira");
        inFont.setBaseFont(label_credit, 12);
        panel_main.add(label_credit, "span, align 97%, gaptop 6, gapbottom 5");

        /*** frame final setup ***/
        frame.add(panel_main);
        frame.pack();
        frame.setVisible(true);
    }

    private void textFieldInactive(JTextField textField) {
        textField.setForeground(Color.GRAY);
        textField.setText(searchDefaultText);
    }

    private void textFieldActive(JTextField textField) {
        textField.setForeground(Color.BLACK);
        textField.setText(blank);
    }

    private void checkSearchText() {
        if (textField_search.getText().equals(searchDefaultText) || textField_search.getText().equals(blank)) {
            JOptionPane.showMessageDialog(frame, "City cannot be blank.\nTry again.");
            label_resultText.setVisible(false);
        } else {
            search_input = textField_search.getText();

            resultSection.removeAllResultList();
            resultSection.getPanel().setVisible(true);

            SearchProcessor sp = new SearchProcessor(search_input);
            if (sp.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED){
                JOptionPane.showMessageDialog(frame, "OpenWeatherMap API key invalid\nCheck again the key");
                label_resultText.setVisible(false);
            } else if (sp.getCurrentWeather().getBaseCount() == 0) {
                label_resultText.setText("No result for " + " \"" + search_input + "\"");
                label_resultText.setVisible(true);
            } else {
                if (sp.getCurrentWeather().getBaseCount() == 1) {
                    label_resultText.setText("1 result for \"" + search_input + "\"");
                } else {
                    label_resultText.setText(sp.getCurrentWeather().getBaseCount() + " results for \"" + search_input + "\"");
                }
                label_resultText.setVisible(true);
                resultSection.showResults(sp.getCurrentWeather());
            }
            frame.pack();
        }

        textFieldInactive(textField_search);
    }

    private class ListenForMouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == textField_search) {
                if (textField_search.getText().equals(searchDefaultText)) {
                    textFieldActive(textField_search);
                }
            } else if (e.getSource() == button_search) {
                // search text processed
                checkSearchText();
            } else {
                if (textField_search.getText().equals(blank)) {
                    textFieldInactive(textField_search);
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
                // search text processed
                checkSearchText();
            } else {
                if (textField_search.getText().equals(searchDefaultText)) {
                    textFieldActive(textField_search);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }

}
