package com.aeolus.view.future;

import com.aeolus.view.PartPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ThreeHourForecast extends PartPanel {
    private String weatherResPath = "\\state\\";
    private String resourcePath, currentDir;

    public ThreeHourForecast(String resourcePath, String currentDir) {
        this.resourcePath = resourcePath;
        this.currentDir = currentDir;

        getPanel().setLayout(new MigLayout());

        for (int i = 0; i < 10; i++) {
            addWeatherTile();
        }
    }

    private void addWeatherTile() {
        JPanel panel_tile = new JPanel();
        panel_tile.setLayout(new MigLayout());
        panel_tile.setBackground(Color.LIGHT_GRAY);

        /* weather icon */
        String weather_icon = "01n";
        JLabel label_weather = new JLabel();
        ImageIcon logo = new ImageIcon(currentDir + resourcePath + weatherResPath + weather_icon + ".png");
        label_weather.setIcon(new ImageIcon(logo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        panel_tile.add(label_weather, "span, align 50%, gaptop 5");

        /* temperature */
        double temperature = 35.2;
        JLabel label_temperature = new JLabel();
        label_temperature.setText("Temperature: " + temperature + " °C");
        panel_tile.add(label_temperature, "span");

        /* humidity */
        double humidity = 83;
        JLabel label_humidity = new JLabel();
        label_humidity.setText("Humidity: " + humidity + "%");
        panel_tile.add(label_humidity, "span");

        /* cloudiness */
        double cloudiness = 20;
        JLabel label_cloudiness = new JLabel();
        label_cloudiness.setText("Cloudiness: " + cloudiness + "%");
        panel_tile.add(label_cloudiness, "span");

        /* wind speed */
        double wind_speed = 2.6;
        JLabel label_wind_speed = new JLabel();
        label_wind_speed.setText("Wind speed: " + wind_speed + " m/s");
        panel_tile.add(label_wind_speed, "span");

        /* wind degrees */
        double wind_degrees = 10;
        JLabel label_wind_degrees = new JLabel();
        label_wind_degrees.setText("Wind direction: " + wind_degrees + "°");
        panel_tile.add(label_wind_degrees, "span");

        /* rain volume */
        double rain_volume = 1.15;
        JLabel label_rain_volume = new JLabel();
        label_rain_volume.setText("Rain volume (3h) : " + rain_volume);
        panel_tile.add(label_rain_volume, "span");

        /* time (date) */
        String date = "16/06";
        JLabel label_date = new JLabel();
        label_date.setText(date);
        panel_tile.add(label_date, "align 50%, span");

        /* time (clock) */
        String clock = "15:00";
        JLabel label_clock = new JLabel();
        label_clock.setText(clock);
        panel_tile.add(label_clock, "align 50%, span, gapbottom 5");

        getPanel().add(panel_tile, "gap 5");
    }

}
