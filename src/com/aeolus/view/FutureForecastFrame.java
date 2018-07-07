package com.aeolus.view;

import com.aeolus.app.FutureForecastProcessor;
import com.aeolus.utils.InFont;
import com.aeolus.utils.InPath;
import com.aeolus.view.future.ThreeHourForecast;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FutureForecastFrame {
    private JFrame frame = new JFrame();
    private JPanel panel_main = new JPanel();
    private JScrollPane panel_threeHourForecast;
    private JLabel label_city_country, label_lon_lat;

    private ThreeHourForecast threeHourForecast;
    private FutureForecastProcessor futureForecastProcessor;
    private InFont inFont = new InFont();

    public FutureForecastFrame(String city_id) {
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            frame.setIconImage(ImageIO.read(new File(InPath.getResourceDirectory("favicon.png"))));
        } catch (IOException e) {
            System.out.println("failed to get favicon");
        }

        panel_main.setLayout(new MigLayout());

        futureForecastProcessor = new FutureForecastProcessor(city_id);

        /* city & country name */
        String city = futureForecastProcessor.getForecastWeather().getCity();
        String country = futureForecastProcessor.getForecastWeather().getCountry();
        frame.setTitle("Aeolus - " + city + ", " + country + " Forecast");
        label_city_country = new JLabel(city + ", " + country);
        inFont.setBaseFont(label_city_country, Font.BOLD, 20);
        panel_main.add(label_city_country, "grow, push, gapleft 5");

        String longitude = futureForecastProcessor.getForecastWeather().getLongitude();
        String latitude = futureForecastProcessor.getForecastWeather().getLatitude();
        label_lon_lat = new JLabel(longitude + ", " + latitude);
        inFont.setBaseFont(label_lon_lat);
        panel_main.add(label_lon_lat, "span, align 100%");

        /* three hour forecast tiles */
        threeHourForecast = new ThreeHourForecast(futureForecastProcessor.getForecastWeather());
        panel_threeHourForecast = new JScrollPane(threeHourForecast.getPanel(), JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel_threeHourForecast.setBorder(null);
        panel_main.add(panel_threeHourForecast, "span 2 1");

        /*** frame final setup ***/
        frame.add(panel_main);
        frame.setVisible(true);
    }

}
