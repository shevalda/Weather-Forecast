package com.aeolus.view.future;

import com.aeolus.app.holder.ForecastWeather;
import com.aeolus.app.holder.ThreeHourBase;
import com.aeolus.utils.InFont;
import com.aeolus.utils.InPath;
import com.aeolus.view.PartPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ThreeHourForecast extends PartPanel {

    public ThreeHourForecast(ForecastWeather fw) {

        getPanel().setLayout(new MigLayout());
        for (ThreeHourBase thb : fw.getBases()) {
            addWeatherTile(thb);
        }
    }

    private void addWeatherTile(ThreeHourBase thb) {
        JPanel panel_tile = new JPanel();
        panel_tile.setLayout(new MigLayout());

        /* weather icon */
        String weather_icon = thb.getImage();
        JLabel label_weather = new JLabel();
        ImageIcon logo = new ImageIcon(InPath.getWeatherStateDirectory(weather_icon));
        label_weather.setIcon(new ImageIcon(logo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        panel_tile.add(label_weather, "span, align 50%, gaptop 5");

        /* description */
        String description = thb.getDescription();
        JLabel label_description = new JLabel(description);
        inFont.setMainFont(label_description, Font.BOLD, 14);
        panel_tile.add(label_description, "span, align 50%, gapbottom 10");

        /* temperature */
        String temperature = thb.getTemperature();
        JLabel label_temperature = new JLabel();
        label_temperature.setText("Temperature: " + temperature + " °C");
        inFont.setMainFont(label_temperature);
        panel_tile.add(label_temperature, "span");

        /* pressure */
        String pressure = thb.getPressure();
        JLabel label_pressure = new JLabel();
        label_pressure.setText("Atm pressure: " + pressure + "hPa");
        inFont.setMainFont(label_pressure);
        panel_tile.add(label_pressure, "span");

        /* humidity */
        String humidity = thb.getHumidity();
        JLabel label_humidity = new JLabel();
        label_humidity.setText("Humidity: " + humidity + "%");
        inFont.setMainFont(label_humidity);
        panel_tile.add(label_humidity, "span");

        /* cloudiness */
        String cloudiness = thb.getCloudiness();
        JLabel label_cloudiness = new JLabel();
        label_cloudiness.setText("Cloudiness: " + cloudiness + "%");
        inFont.setMainFont(label_cloudiness);
        panel_tile.add(label_cloudiness, "span");

        /* wind speed */
        String wind_speed = thb.getWindSpeed();
        JLabel label_wind_speed = new JLabel();
        label_wind_speed.setText("Wind speed: " + wind_speed + " m/s");
        inFont.setMainFont(label_wind_speed);
        panel_tile.add(label_wind_speed, "span");

        /* wind degrees */
        String wind_degrees = thb.getWindDirection();
        JLabel label_wind_degrees = new JLabel();
        label_wind_degrees.setText("Wind direction: " + wind_degrees + "°");
        inFont.setMainFont(label_wind_degrees);
        panel_tile.add(label_wind_degrees, "span");

        /* rain volume */
        String rain_volume = thb.getRainVolume();
        JLabel label_rain_volume = new JLabel();
        label_rain_volume.setText("Rain volume : " + rain_volume);
        inFont.setMainFont(label_rain_volume);
        panel_tile.add(label_rain_volume, "span");


        /* time (date) */
        String date = thb.getDate();
        JLabel label_date = new JLabel();
        label_date.setText(date);
        inFont.setMainFont(label_date, Font.BOLD, 15);
        panel_tile.add(label_date, "align 50%, span, gaptop 5");

        /* time (clock) */
        String clock = thb.getTime();
        JLabel label_clock = new JLabel();
        label_clock.setText(clock);
        inFont.setMainFont(label_clock, 14);
        panel_tile.add(label_clock, "align 50%, span, gapbottom 5");

        if (thb.getDayNight().equals("d")) {
            panel_tile.setBackground(Color.LIGHT_GRAY);
        } else {
            panel_tile.setBackground(Color.DARK_GRAY);
            for (Component c : panel_tile.getComponents()) {
                c.setForeground(Color.WHITE);
            }
        }

        getPanel().add(panel_tile, "pushy, growy, gap 10");
    }

}
