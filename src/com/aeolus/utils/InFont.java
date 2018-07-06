package com.aeolus.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class InFont {

    private String font_name_base = "FZYaoTi";
//    private String font_name_main = "Gill Sans MT Condensed";
    private String font_name_main = "Gill Sans MT";

    public InFont() {

        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Font font1 = Font.createFont(Font.TRUETYPE_FONT, new File(InPath.getFontDirectory(font_name_main)));
            ge.registerFont(font1);
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File(InPath.getFontDirectory(font_name_base)));
            ge.registerFont(font2);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setBaseFont(JComponent component) {
        component.setFont(new Font(font_name_base, Font.PLAIN, 13));
    }

    public void setBaseFont(JComponent component, int size) {
        component.setFont(new Font(font_name_base, Font.PLAIN, size));
    }

    public void setBaseFont(JComponent component, int font_style, int size) {
        component.setFont(new Font(font_name_base, font_style, size));
    }

    public void setMainFont(JComponent component) {
        component.setFont(new Font(font_name_main, Font.PLAIN, 13));
    }

    public void setMainFont(JComponent component, int size) {
        component.setFont(new Font(font_name_main, Font.PLAIN, size));
    }

    public void setMainFont(JComponent component, int font_style, int size) {
        component.setFont(new Font(font_name_main, font_style, size));
    }

}


