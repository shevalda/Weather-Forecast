package com.aeolus.app;

import com.aeolus.view.MainFrame;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new MainFrame());
  }

}
