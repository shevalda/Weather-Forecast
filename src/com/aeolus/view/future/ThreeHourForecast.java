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
        panel_tile.setLayout(new MigLayout("wrap 2"));

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
        addLabel(panel_tile, "Temperature");
        String temperature = thb.getTemperature() + " °C";
        addInformation(panel_tile, temperature);

        /* pressure */
        addLabel(panel_tile, "Atm pressure");
        String pressure = thb.getPressure() + " hPa";
        addInformation(panel_tile, pressure);

        /* humidity */
        addLabel(panel_tile, "Humidity");
        String humidity = thb.getHumidity() + "%";
        addInformation(panel_tile, humidity);

        /* cloudiness */
        addLabel(panel_tile, "Cloudiness");
        String cloudiness = thb.getCloudiness() + "%";
        addInformation(panel_tile, cloudiness);

        /* wind speed */
        addLabel(panel_tile, "Wind speed");
        String wind_speed = thb.getWindSpeed() + "m/s";
        addInformation(panel_tile, wind_speed);

        /* wind degrees */
        addLabel(panel_tile, "Wind degrees");
        String wind_degrees = thb.getWindDirection() + "°";
        addInformation(panel_tile, wind_degrees);

        /* rain volume */
        addLabel(panel_tile, "Rain volume");
        String rain_volume = thb.getRainVolume();
        addInformation(panel_tile, rain_volume);

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
            panel_tile.setBackground(new Color(236, 209, 128));
        } else {
            panel_tile.setBackground(new Color(3, 30, 60));
            for (Component c : panel_tile.getComponents()) {
                c.setForeground(Color.WHITE);
            }
        }

        getPanel().add(panel_tile, "pushy, growy, gap 5");
    }

    private void addLabel(JPanel panel, String desc) {
        JLabel label = new JLabel(desc);
        inFont.setMainFont(label);
        panel.add(label, "pushx, growx, gapleft 5");
    }

    private void addInformation(JPanel panel, String info) {
        JLabel label = new JLabel(info);
        inFont.setMainFont(label, Font.BOLD, 13);
        panel.add(label, "align 100%, gapleft 10, gapright 5");
    }

}
