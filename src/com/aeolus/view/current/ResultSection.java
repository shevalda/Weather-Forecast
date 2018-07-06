package com.aeolus.view.current;

import com.aeolus.app.holder.CurrentWeather;
import com.aeolus.utils.InPath;
import com.aeolus.view.FutureForecastFrame;
import com.aeolus.view.PartPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ResultSection extends PartPanel {

    public ResultSection(JLabel label_result) {
        label_result.setForeground(Color.WHITE);
        inFont.setBaseFont(label_result, Font.BOLD, 12);

        getPanel().setLayout(new MigLayout());
        getPanel().setBackground(Color.DARK_GRAY);

        label_result.setVisible(false);
        getPanel().add(label_result, "span, gapbottom 7");
        getPanel().setVisible(false);
    }

    public void addResultPanel(CurrentWeather info) {
        JPanel panel_weather = new JPanel();
        panel_weather.setLayout(new MigLayout("wrap 3"));
        panel_weather.setBackground(Color.LIGHT_GRAY);

        /* weather icon */
        String weather_icon = info.getImage();
        JLabel label_weather = new JLabel();
        ImageIcon logo = new ImageIcon(InPath.getWeatherStateDirectory(weather_icon));
        label_weather.setIcon(new ImageIcon(logo.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
        panel_weather.add(label_weather, "span 1 4, align 50%, gapright 10");

        /* city & country  label */
        String city = info.getCity();
        String country = info.getCountry();
        JLabel label_city_country = new JLabel();
        label_city_country.setText(city + ", " + country);
        inFont.setMainFont(label_city_country, Font.BOLD, 20);
        panel_weather.add(label_city_country, "growx, pushx");

        /* longitude & latitude */
        String lon = info.getLongitude();
        String lat = info.getLatitude();
        JLabel label_lon_lat = new JLabel();
        label_lon_lat.setText(lon + ", " + lat);
        inFont.setMainFont(label_lon_lat, Font.ITALIC, 14);
        panel_weather.add(label_lon_lat, "align 100%");

        /* temperature */
        String temperature = info.getTemperature();
        JLabel label_temperature = new JLabel();
        label_temperature.setText("Temperature: " + temperature + " °C");
        inFont.setMainFont(label_temperature);
        panel_weather.add(label_temperature, "pushx, growx");

        /* wind speed */
        String wind_speed = info.getWindSpeed();
        JLabel label_wind_speed = new JLabel();
        label_wind_speed.setText("Wind speed: " + wind_speed + " m/s");
        inFont.setMainFont(label_wind_speed);
        panel_weather.add(label_wind_speed, "pushx, growx");

        /* pressure */
        String pressure = info.getPressure();
        JLabel label_pressure = new JLabel();
        label_pressure.setText("Atm Pressure: " + pressure + " hPa");
        inFont.setMainFont(label_pressure);
        panel_weather.add(label_pressure, "pushx, growx, gapright 20");

        /* wind degrees */
        String wind_degrees = info.getWindDirection();
        JLabel label_wind_degrees = new JLabel();
        label_wind_degrees.setText("Wind direction: " + wind_degrees + "°");
        inFont.setMainFont(label_wind_degrees);
        panel_weather.add(label_wind_degrees, "pushx, growx");

        /* humidity */
        String humidity = info.getHumidity();
        JLabel label_humidity = new JLabel();
        label_humidity.setText("Humidity: " + humidity + "%");
        inFont.setMainFont(label_humidity);
        panel_weather.add(label_humidity, "pushx, growx");

        /* cloudiness */
        String cloudiness = info.getCloudiness();
        JLabel label_cloudiness = new JLabel();
        label_cloudiness.setText("Cloudiness: " + cloudiness + "%");
        inFont.setMainFont(label_cloudiness);
        panel_weather.add(label_cloudiness, "pushx, growx");

        /* weather description */
        String description = info.getDescription();
        JLabel label_description = new JLabel(description);
        inFont.setMainFont(label_description, Font.BOLD, 15);
        panel_weather.add(label_description, "align 50%, gapright 10");

        /* button for 5 days forecast */
        JButton button_forecast = new JButton("See forecast");
        inFont.setBaseFont(button_forecast, Font.BOLD, 12);
        button_forecast.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                System.out.println("create new forecast frame");
                new FutureForecastFrame(info.getCity());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        panel_weather.add(button_forecast, "skip 1, align 100%");

        getPanel().add(panel_weather, "span, pushx, growx, gapbottom 5");
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
