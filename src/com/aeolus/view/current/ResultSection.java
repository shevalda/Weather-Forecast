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
//        label_result.setForeground(Color.WHITE);
        inFont.setBaseFont(label_result, Font.BOLD, 12);

        getPanel().setLayout(new MigLayout());

        label_result.setVisible(false);
        getPanel().add(label_result, "span, gapbottom 7");
        getPanel().setVisible(false);
    }

    public void addResultPanel(CurrentWeather info) {
        JPanel panel_weather = new JPanel();
        panel_weather.setLayout(new MigLayout("wrap 5"));
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
        panel_weather.add(label_city_country, "span 2 1, growx, pushx");

        /* longitude & latitude */
        String lon = info.getLongitude();
        String lat = info.getLatitude();
        JLabel label_lon_lat = new JLabel();
        label_lon_lat.setText(lon + ", " + lat);
        inFont.setMainFont(label_lon_lat, Font.ITALIC, 14);
        panel_weather.add(label_lon_lat, "span 2 1, align 100%");

        /* temperature */
        addLabel(panel_weather,"Temperature");
        String temperature = info.getTemperature() + " °C";
        addInformationLeft(panel_weather, temperature);

        /* wind speed */
        addLabel(panel_weather, "Wind speed");
        String wind_speed = info.getWindSpeed() + " m/s";
        addInformationRight(panel_weather, wind_speed);

        /* pressure */
        addLabel(panel_weather, "Atm Pressure");
        String pressure = info.getPressure() + " hPa";
        addInformationLeft(panel_weather, pressure);

        /* wind degrees */
        addLabel(panel_weather, "Wind degrees" );
        String wind_degrees = info.getWindDirection();
        if (!wind_degrees.equals("-")) {
            wind_degrees += "°";
        }
        addInformationRight(panel_weather, wind_degrees);

        /* humidity */
        addLabel(panel_weather, "Humidity");
        String humidity = info.getHumidity() + "%";
        addInformationLeft(panel_weather, humidity);

        /* cloudiness */
        addLabel(panel_weather, "Cloudiness");
        String cloudiness = info.getCloudiness() + "%";
        addInformationRight(panel_weather, cloudiness);

        /* weather description */
        String description = info.getDescription();
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
        panel_weather.add(button_forecast, "skip 2, span 2 1, align 100%");

        getPanel().add(panel_weather, "span, pushx, growx, gapbottom 5");
    }

    private void addLabel(JPanel panel, String desc) {
        JLabel label = new JLabel(desc);
        inFont.setMainFont(label);
        panel.add(label, "pushx, growx");
    }

    private void addInformationLeft(JPanel panel, String info) {
        JLabel label = new JLabel(info);
        inFont.setMainFont(label, Font.BOLD, 13);
        panel.add(label, "align 100%, gapright 10");
    }

    private void addInformationRight(JPanel panel, String info) {
        JLabel label = new JLabel(info);
        inFont.setMainFont(label, Font.BOLD, 13);
        panel.add(label, "align 100%");
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
