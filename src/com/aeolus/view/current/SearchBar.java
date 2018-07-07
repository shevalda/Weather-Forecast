package com.aeolus.view.current;

import com.aeolus.utils.InPath;
import com.aeolus.view.PartPanel;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SearchBar extends PartPanel {
    private JLabel label_logo;

    public SearchBar(JTextField textField_search, JButton button_search) {
        getPanel().setLayout(new MigLayout("insets 5 0 5 0"));   // top left bottom right

        /* logo */
        String logoImageName = "logo.png";

        label_logo = new JLabel();
        ImageIcon logo = new ImageIcon(InPath.getResourceDirectory(logoImageName));
        label_logo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(250, 125, Image.SCALE_DEFAULT)));
        label_logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        getPanel().add(label_logo, "span, align 50%");

        /* search bar */
        textField_search.setForeground(Color.GRAY);
        textField_search.setHorizontalAlignment(JTextField.CENTER);
        inFont.setBaseFont(textField_search);
        getPanel().add(textField_search, "push, grow");

        /* search button */
        String searchImageName = "search.png";
        try {
            BufferedImage searchicon = ImageIO.read(new File(InPath.getResourceDirectory(searchImageName)));
            button_search.setIcon(new ImageIcon(searchicon));
            button_search.setMargin(new Insets(5,12,5,12));
            button_search.setBackground(new Color(29, 116, 117));
            button_search.setBorderPainted(false);
            getPanel().add(button_search);
        } catch (IOException e) {
            System.out.println("failed to find " + searchImageName);
        }
    }

}
