package com.aeolus.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ResultSection implements PartPanel {
    private JPanel panel;

    private String currentDir, resourcePath, weatherResPath;

    public ResultSection(String currentDir, String resourcePath, String weatherResPath) {
        this.currentDir = currentDir;
        this.resourcePath = resourcePath;
        this.weatherResPath = weatherResPath;
        panel = new JPanel();
        panel.setLayout(new MigLayout());
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel newResultPanel(String city, String country, double longitude, double latitude, String weather_icon) {
        JPanel panel_city = new JPanel();
        panel_city.setLayout(new MigLayout("inset 10"));
        panel_city.setBackground(Color.lightGray);

//        panel_city.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        /* weather image */
        JLabel weather = new JLabel();
        ImageIcon logo = new ImageIcon(currentDir + resourcePath + weatherResPath + weather_icon + ".png");
        weather.setIcon(new ImageIcon(logo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//        weather.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        panel_city.add(weather, "span 1 2, gapright 10, gapleft 15");

        /* city & country name */
        JLabel label_city_county = new JLabel();
        label_city_county.setText(city + ", " + country);
//        label_city_county.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        panel_city.add(label_city_county, "wrap");

        /* longitude & latitude */
        JLabel label_lon_lat = new JLabel();
        label_lon_lat.setText(longitude + ", " + latitude);
//        label_lon_lat.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        panel_city.add(label_lon_lat);

//        panel.add(panel_city, "warp, pushx, growx");
        return panel_city;
    }

    public void addResultPanel(JPanel result_panel) {
        panel.add(result_panel, "span, pushx, growx");
    }

    public void removeAllResultList() {

    }

}
