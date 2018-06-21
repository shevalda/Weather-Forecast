package com.aeolus.view.current;

import com.aeolus.view.PartPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ResultSection extends PartPanel {
    private String currentDir, resourcePath, weatherResPath;

    public ResultSection(JLabel label_result, String currentDir, String resourcePath, String weatherResPath) {
        this.currentDir = currentDir;
        this.resourcePath = resourcePath;
        this.weatherResPath = weatherResPath;
        label_result.setForeground(Color.WHITE);

        getPanel().setLayout(new MigLayout());
        getPanel().setBackground(Color.DARK_GRAY);

        label_result.setVisible(false);
        getPanel().add(label_result, "span, gapbottom 7");
    }

    public JPanel newWeatherDetail() {
        // variable jadi parameter
        JPanel panel_weather = new JPanel();
        panel_weather.setLayout(new MigLayout("wrap 3"));
        panel_weather.setBackground(Color.LIGHT_GRAY);

        /* weather icon */
        String weather_icon = "01n";
        JLabel label_weather = new JLabel();
        ImageIcon logo = new ImageIcon(currentDir + resourcePath + weatherResPath + weather_icon + ".png");
        label_weather.setIcon(new ImageIcon(logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        panel_weather.add(label_weather, "span 1 4");

        /* city & country  label */
        String city = "Bandung";
        String country = "ID";
        JLabel label_city_country = new JLabel();
        label_city_country.setText(city + ", " + country);
        panel_weather.add(label_city_country, "growx, pushx");

        /* longitude & latitude */
        double lon = 103.4;
        double lat = 28.23;
        JLabel label_lon_lat = new JLabel();
        label_lon_lat.setText(lon + ", " + lat);
        panel_weather.add(label_lon_lat, "align 100%");

        /* temperature */
        double temperature = 35.2;
        JLabel label_temperature = new JLabel();
        label_temperature.setText("Temperature: " + temperature + " °C");
        panel_weather.add(label_temperature, "pushx, growx");

        /* wind speed */
        double wind_speed = 2.6;
        JLabel label_wind_speed = new JLabel();
        label_wind_speed.setText("Wind speed: " + wind_speed + " m/s");
        panel_weather.add(label_wind_speed, "pushx, growx");

        /* pressure */
        double pressure = 1011;
        JLabel label_pressure = new JLabel();
        label_pressure.setText("Atm Pressure: " + pressure + " hPa");
        panel_weather.add(label_pressure, "pushx, growx, gapright 20");

        /* wind degrees */
        double wind_degrees = 10;
        JLabel label_wind_degrees = new JLabel();
        label_wind_degrees.setText("Wind direction: " + wind_degrees + "°");
        panel_weather.add(label_wind_degrees, "pushx, growx");

        /* humidity */
        double humidity = 83;
        JLabel label_humidity = new JLabel();
        label_humidity.setText("Humidity: " + humidity + "%");
        panel_weather.add(label_humidity, "pushx, growx");

        /* cloudiness */
        double cloudiness = 20;
        JLabel label_cloudiness = new JLabel();
        label_cloudiness.setText("Cloudiness: " + cloudiness + "%");
        panel_weather.add(label_cloudiness, "pushx, growx");

        /* weather description */
        String description = "few clouds";
        JLabel label_description = new JLabel(description);
        panel_weather.add(label_description, "align 50%");

        /* button for 5 days forecast */
        JButton button_forecast = new JButton("See 5 days of forecast");
        panel_weather.add(button_forecast, "skip 1, align 100%");

        return panel_weather;
    }

    public void addResultPanel(JPanel result_panel) {
        getPanel().add(result_panel, "span, pushx, growx, gapbottom 5");
    }

    public void removeAllResultList() {
        Component[] components = getPanel().getComponents();
        for (Component c : components) {
            if (c instanceof JPanel) {
                getPanel().remove(c);
            }
        }
//        panel.revalidate();
//        panel.repaint();
    }

}
