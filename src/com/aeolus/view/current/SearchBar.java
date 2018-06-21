package com.aeolus.view.current;

import com.aeolus.view.PartPanel;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SearchBar implements PartPanel {
    private JPanel panel = new JPanel();
    private JLabel label_logo;

    public SearchBar(JTextField textField_search, JButton button_search, String currentDir, String resourcePath) {
        panel.setLayout(new MigLayout("insets 5 0 5 0"));   // top left bottom right

        /* logo */
        String logoImageName = "app-logo.png";

        label_logo = new JLabel();
        ImageIcon logo = new ImageIcon(currentDir + resourcePath + logoImageName);
        label_logo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(50, 25, Image.SCALE_DEFAULT)));
        label_logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label_logo);

        /* search bar */
        textField_search.setForeground(Color.GRAY);
        textField_search.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField_search, "push, grow");

        /* search button */
        String searchImageName = "search.png";
        try {
            BufferedImage searchicon = ImageIO.read(new File(currentDir + resourcePath + searchImageName));
            button_search.setIcon(new ImageIcon(searchicon));
            panel.add(button_search);
        } catch (IOException e) {
            System.out.println("failed to find " + searchImageName);
        }

    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

}
