package com.aeolus.view;

import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainFrame {
    private JFrame frame = new JFrame("Aeolus");
    private JPanel panel_main = new JPanel();
    private JPanel panel_searchbar, panel_result;

    private String resourcePath = "\\res\\";
    private String weatherResPath = "\\state\\";
    private String currentDir = System.getProperty("user.dir");

    public MainFrame() {
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            frame.setIconImage(ImageIO.read(new File(currentDir + resourcePath + "favicon.png")));
        } catch (IOException e) {
            System.out.println("failed to get favicon");
        }

        panel_main.setLayout(new MigLayout());

        SearchBar searchBar = new SearchBar(currentDir, resourcePath);
        panel_searchbar = searchBar.getPanel();
//        panel_searchbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_main.add(panel_searchbar, "span, growx, pushx");

        ResultSection resultSection = new ResultSection(currentDir, resourcePath, weatherResPath);
        panel_result = resultSection.getPanel();
//        panel_result.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        resultSection.addResultList("Jakarta", "ID", 106.83, -6.18, "02n");
        JPanel result1 = resultSection.newResultPanel("Jakarta", "ID", 106.83, -6.18, "02n");
        resultSection.addResultPanel(result1);
        JPanel result2 = resultSection.newResultPanel("Bandung", "ID", 100.83, 86.18, "01n");
        resultSection.addResultPanel(result2);
        panel_main.add(panel_result, "span, growx, pushx");

        frame.add(panel_main);
        frame.pack();
        frame.setVisible(true);
    }

}
