package com.aeolus.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.JComponent;

public class InFont {
  private String fontNameBase = "FZYaoTi";
  private String fontNameMain = "Gill Sans MT";

  /**
   * Responsible of creating and applying fonts in the application.
   */
  public InFont() {
    try {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      File fileFontMain = new File(InPath.getFontDirectory(fontNameMain));
      Font font1 = Font.createFont(Font.TRUETYPE_FONT, fileFontMain);
      ge.registerFont(font1);
      File fileFontBase = new File(InPath.getFontDirectory(fontNameBase));
      Font font2 = Font.createFont(Font.TRUETYPE_FONT, fileFontBase);
      ge.registerFont(font2);
    } catch (FontFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setBaseFont(JComponent component) {
    component.setFont(new Font(fontNameBase, Font.PLAIN, 13));
  }

  public void setBaseFont(JComponent component, int size) {
    component.setFont(new Font(fontNameBase, Font.PLAIN, size));
  }

  public void setBaseFont(JComponent component, int fontStyle, int size) {
    component.setFont(new Font(fontNameBase, fontStyle, size));
  }

  public void setMainFont(JComponent component) {
    component.setFont(new Font(fontNameMain, Font.PLAIN, 13));
  }

  public void setMainFont(JComponent component, int size) {
    component.setFont(new Font(fontNameMain, Font.PLAIN, size));
  }

  public void setMainFont(JComponent component, int fontStyle, int size) {
    component.setFont(new Font(fontNameMain, fontStyle, size));
  }

}


