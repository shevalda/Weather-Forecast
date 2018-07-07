package com.aeolus.view;

import com.aeolus.app.holder.CurrentCityBase;
import com.aeolus.utils.InFont;
import com.aeolus.utils.InPath;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class CurrentWeatherFrame {
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame();

    private CurrentCityBase currentCityBase;
    private InFont inFont = new InFont();

    public CurrentWeatherFrame(CurrentCityBase ccb) {
        currentCityBase = ccb;

        frame.setSize(600, 600);
        frame.setTitle("Aeolus - " + ccb.getCity() + ", " + ccb.getCountry());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            frame.setIconImage(ImageIO.read(new File(InPath.getResourceDirectory("favicon.png"))));
        } catch (IOException e) {
            System.out.println("failed to get favicon");
        }

        addPanel();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void addPanel() {
        JPanel panel_weather = new JPanel();
        panel_weather.setLayout(new MigLayout("wrap 5"));

        /* weather icon */
        String weather_icon = currentCityBase.getImage();
        JLabel label_weather = new JLabel();
        ImageIcon logo = new ImageIcon(InPath.getWeatherStateDirectory(weather_icon));
        label_weather.setIcon(new ImageIcon(logo.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
        panel_weather.add(label_weather, "span 1 4, align 50%, gapright 10");

        /* city & country  label */
        String city = currentCityBase.getCity();
        String country = currentCityBase.getCountry();
        JLabel label_city_country = new JLabel();
        label_city_country.setText(city + ", " + country);
        inFont.setMainFont(label_city_country, Font.BOLD, 20);
        panel_weather.add(label_city_country, "span 2 1, growx, pushx");

        /* longitude & latitude */
        String lon = currentCityBase.getLongitude();
        String lat = currentCityBase.getLatitude();
        JLabel label_lon_lat = new JLabel();
        label_lon_lat.setText(lon + ", " + lat);
        inFont.setMainFont(label_lon_lat, Font.ITALIC, 14);
        panel_weather.add(label_lon_lat, "span 2 1, align 100%");

        /* temperature */
        addLabel(panel_weather,"Temperature");
        String temperature = currentCityBase.getTemperature() + " °C";
        addInformationLeft(panel_weather, temperature);

        /* wind speed */
        addLabel(panel_weather, "Wind speed");
        String wind_speed = currentCityBase.getWindSpeed() + " m/s";
        addInformationRight(panel_weather, wind_speed);

        /* pressure */
        addLabel(panel_weather, "Atm Pressure");
        String pressure = currentCityBase.getPressure() + " hPa";
        addInformationLeft(panel_weather, pressure);

        /* wind degrees */
        addLabel(panel_weather, "Wind degrees" );
        String wind_degrees = currentCityBase.getWindDirection();
        if (!wind_degrees.equals("-")) {
            wind_degrees += "°";
        }
        addInformationRight(panel_weather, wind_degrees);

        /* humidity */
        addLabel(panel_weather, "Humidity");
        String humidity = currentCityBase.getHumidity() + "%";
        addInformationLeft(panel_weather, humidity);

        /* cloudiness */
        addLabel(panel_weather, "Cloudiness");
        String cloudiness = currentCityBase.getCloudiness() + "%";
        addInformationRight(panel_weather, cloudiness);

        /* weather description */
        String description = currentCityBase.getDescription();
        JLabel label_description = new JLabel(description);
        inFont.setMainFont(label_description, Font.BOLD, 15);
        panel_weather.add(label_description, "align 50%, gapright 10");

        /* button for 5 days forecast */
        JButton button_forecast = new JButton("See forecast");
        inFont.setBaseFont(button_forecast, Font.BOLD, 12);
        button_forecast.setMargin(new Insets(2,12,2,12));
        button_forecast.setBackground(new Color(29, 116, 117));
        button_forecast.setForeground(Color.WHITE);
        button_forecast.setBorderPainted(false);
        button_forecast.setFocusable(false);
        button_forecast.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new FutureForecastFrame(currentCityBase.getId());
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
        panel_weather.add(button_forecast, "skip 4, span, align 100%");

        panel.add(panel_weather, "push, grow, gap 10");
    }

    private void addLabel(JPanel panel, String desc) {
        JLabel label = new JLabel(desc);
        inFont.setMainFont(label);
        panel.add(label, "pushx, growx");
    }

    private void addInformationLeft(JPanel panel, String info) {
        JLabel label = new JLabel(info);
        inFont.setMainFont(label, Font.BOLD, 13);
        panel.add(label, "align 100%, gapright 10, gapleft 15");
    }

    private void addInformationRight(JPanel panel, String info) {
        JLabel label = new JLabel(info);
        inFont.setMainFont(label, Font.BOLD, 13);
        panel.add(label, "align 100%, gapleft 15");
    }

}
