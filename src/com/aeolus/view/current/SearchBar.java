package com.aeolus.view.current;

import com.aeolus.utils.InPath;
import com.aeolus.view.PartPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class SearchBar extends PartPanel {

  /**
   * Panel that shows the logo and the search bar.
   * @param textFieldSearch  text field given from Main frame.
   * @param buttonSearch     button given from Main frame.
   */
  public SearchBar(JTextField textFieldSearch, JButton buttonSearch) {
    getPanel().setLayout(new MigLayout("insets 5 0 5 0"));   // top left bottom right

    /* logo */
    String logoImageName = "logo.png";

    JLabel labelLogo = new JLabel();
    ImageIcon logo = new ImageIcon(InPath.getResourceDirectory(logoImageName));
    labelLogo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(250, 125, Image.SCALE_DEFAULT)));
    labelLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
    getPanel().add(labelLogo, "span, align 50%");

    /* search bar */
    textFieldSearch.setForeground(Color.GRAY);
    textFieldSearch.setHorizontalAlignment(JTextField.CENTER);
    inFont.setBaseFont(textFieldSearch);
    getPanel().add(textFieldSearch, "push, grow");

    /* search button */
    String searchImageName = "search.png";
    try {
      File file = new File(InPath.getResourceDirectory(searchImageName));
      BufferedImage searchIcon = ImageIO.read(file);
      buttonSearch.setIcon(new ImageIcon(searchIcon));
      buttonSearch.setMargin(new Insets(5,12,5,12));
      buttonSearch.setBackground(new Color(29, 116, 117));
      buttonSearch.setBorderPainted(false);
      getPanel().add(buttonSearch);
    } catch (IOException e) {
      System.out.println("failed to find " + searchImageName);
    }
  }

}
