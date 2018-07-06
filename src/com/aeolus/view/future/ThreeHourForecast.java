package com.aeolus.view.future;

import com.aeolus.app.holder.ForecastWeather;
import com.aeolus.app.holder.ThreeHourBase;
import com.aeolus.view.PartPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ThreeHourForecast extends PartPanel {
    private String weatherResPath = "\\state\\";
    private String resourcePath, currentDir;

    public ThreeHourForecast(String resourcePath, String currentDir, ForecastWeather fw) {
        this.resourcePath = resourcePath;
        this.currentDir = currentDir;

        getPanel().setLayout(new MigLayout());
        for (ThreeHourBase thb : fw.getBases()) {
            addWeatherTile(thb);
        }
    }

    private void addWeatherTile(ThreeHourBase thb) {
        JPanel panel_tile = new JPanel();
        panel_tile.setLayout(new MigLayout());
        if (thb.getDayNight().equals("d")) {
            panel_tile.setBackground(Color.LIGHT_GRAY);
        } else {
            panel_tile.setBackground(Color.DARK_GRAY);
        }

        /* weather icon */
        String weather_icon = thb.getImage();
        JLabel label_weather = new JLabel();
        ImageIcon logo = new ImageIcon(currentDir + resourcePath + weatherResPath + weather_icon + ".png");
        label_weather.setIcon(new ImageIcon(logo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        panel_tile.add(label_weather, "span, align 50%, gaptop 5");

        /* description */
        String description = thb.getDescription();
        JLabel label_description = new JLabel(description);
        panel_tile.add(label_description, "span");

        /* temperature */
        String temperature = thb.getTemperature();
        JLabel label_temperature = new JLabel();
        label_temperature.setText("Temperature: " + temperature + " °C");
        panel_tile.add(label_temperature, "span");

        /* pressure */
        String pressure = thb.getPressure();
        JLabel label_pressure = new JLabel();
        label_pressure.setText("Atm pressure: " + pressure + "hPa");
        panel_tile.add(label_pressure, "span");

        /* humidity */
        String humidity = thb.getHumidity();
        JLabel label_humidity = new JLabel();
        label_humidity.setText("Humidity: " + humidity + "%");
        panel_tile.add(label_humidity, "span");

        /* cloudiness */
        String cloudiness = thb.getCloudiness();
        JLabel label_cloudiness = new JLabel();
        label_cloudiness.setText("Cloudiness: " + cloudiness + "%");
        panel_tile.add(label_cloudiness, "span");

        /* wind speed */
        String wind_speed = thb.getWindSpeed();
        JLabel label_wind_speed = new JLabel();
        label_wind_speed.setText("Wind speed: " + wind_speed + " m/s");
        panel_tile.add(label_wind_speed, "span");

        /* wind degrees */
        String wind_degrees = thb.getWindDirection();
        JLabel label_wind_degrees = new JLabel();
        label_wind_degrees.setText("Wind direction: " + wind_degrees + "°");
        panel_tile.add(label_wind_degrees, "span");

        /* rain volume */
        String rain_volume = thb.getRainVolume();
        JLabel label_rain_volume = new JLabel();
        label_rain_volume.setText("Rain volume (3h) : " + rain_volume);
        panel_tile.add(label_rain_volume, "span");

        /* time (date) */
        String date = thb.getDate();
        JLabel label_date = new JLabel();
        label_date.setText(date);
        panel_tile.add(label_date, "align 50%, span");

        /* time (clock) */
        String clock = thb.getTime();
        JLabel label_clock = new JLabel();
        label_clock.setText(clock);
        panel_tile.add(label_clock, "align 50%, span, gapbottom 5");

        getPanel().add(panel_tile, "gap 5");
    }

}
