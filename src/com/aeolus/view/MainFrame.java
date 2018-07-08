package com.aeolus.view;

import com.aeolus.app.SearchProcessor;
import com.aeolus.utils.InFont;
import com.aeolus.utils.InPath;
import com.aeolus.view.current.ResultSection;
import com.aeolus.view.current.SearchBar;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class MainFrame {
  private JFrame frame = new JFrame("Aeolus");
  private JPanel panelMain;
  private JPanel panelSearchBar;
  private JPanel panelResult;
  private JTextField textFieldSearch;
  private JButton buttonSearch;
  private JLabel labelResultText;
  private String searchInput = "";

  private ResultSection resultSection;
  private SearchBar searchBar;
  private InFont inFont = new InFont();

  private String searchDefaultText = "Try \"Bandung\" or \"Jakarta\"";
  private String blank = "";

  /**
   * The main frame of the application.
   * Application started from this frame.
   * Responsible for displaying search bar and result list.
   */
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

    panelMain = new JPanel();
    panelMain.setLayout(new MigLayout());
    panelMain.addMouseListener(new ListenForMouse());

    /* search bar */
    textFieldSearch = new JTextField(searchDefaultText, 42);
    textFieldSearch.addMouseListener(new ListenForMouse());
    textFieldSearch.addKeyListener(new ListenForKeys());
    buttonSearch = new JButton();
    buttonSearch.addMouseListener(new ListenForMouse());

    searchBar = new SearchBar(textFieldSearch, buttonSearch);
    panelSearchBar = searchBar.getPanel();
    panelMain.add(panelSearchBar, "span, growx, pushx, gapleft 10, gapright 10");

    /* result section */
    labelResultText = new JLabel();
    resultSection = new ResultSection(labelResultText);
    panelResult = resultSection.getPanel();
    panelMain.add(panelResult, "span, growx, pushx, , gapleft 10, gapright 10");

    /* credit */
    JLabel labelCredit = new JLabel("created by Shevalda Gracielira");
    inFont.setBaseFont(labelCredit, 12);
    panelMain.add(labelCredit, "span, align 97%, gaptop 6, gapbottom 5");

    /*** frame final setup ***/
    frame.add(panelMain);
    frame.pack();
    frame.setVisible(true);
  }

  private void textFieldInactive() {
    textFieldSearch.setForeground(Color.GRAY);
    textFieldSearch.setText(searchDefaultText);
  }

  private void textFieldActive() {
    textFieldSearch.setForeground(Color.BLACK);
    textFieldSearch.setText(blank);
  }

  private void checkSearchText() {
    if (textFieldSearch.getText().equals(searchDefaultText) || textFieldSearch.getText().equals(blank)) {
      JOptionPane.showMessageDialog(frame, "City cannot be blank.\nTry again.");
      labelResultText.setVisible(false);
    } else {
      searchInput = textFieldSearch.getText();

      resultSection.removeAllResultList();
      resultSection.getPanel().setVisible(true);

      SearchProcessor sp = new SearchProcessor(searchInput);
      if (sp.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
        JOptionPane.showMessageDialog(frame, "OpenWeatherMap API key invalid\nCheck again the key");
        labelResultText.setVisible(false);
      } else if (sp.getCurrentWeather().getBaseCount() == 0) {
        labelResultText.setText("No result for " + " \"" + searchInput + "\"");
        labelResultText.setVisible(true);
      } else {
        if (sp.getCurrentWeather().getBaseCount() == 1) {
          labelResultText.setText("1 result for \"" + searchInput + "\"");
        } else {
          labelResultText.setText(sp.getCurrentWeather().getBaseCount() + " results for \"" + searchInput + "\"");
        }
        labelResultText.setVisible(true);
        resultSection.showResults(sp.getCurrentWeather());
      }
      frame.pack();
    }

    textFieldInactive();
  }

  private class ListenForMouse implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
      if (e.getSource() == textFieldSearch) {
        if (textFieldSearch.getText().equals(searchDefaultText)) {
          textFieldActive();
        }
      } else if (e.getSource() == buttonSearch) {
        // search text processed
        checkSearchText();
      } else {
        if (textFieldSearch.getText().equals(blank)) {
          textFieldInactive();
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
        if (textFieldSearch.getText().equals(searchDefaultText)) {
          textFieldActive();
        }
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
  }

}
