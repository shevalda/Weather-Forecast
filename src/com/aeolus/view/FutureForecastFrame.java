package com.aeolus.view;

import com.aeolus.app.FutureForecastProcessor;
import com.aeolus.view.future.ThreeHourForecast;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FutureForecastFrame {
    private JFrame frame = new JFrame();
    private JPanel panel_main = new JPanel();
    private JScrollPane panel_threeHourForecast;
    private JLabel label_city_country;

    private ThreeHourForecast threeHourForecast;
    private FutureForecastProcessor futureForecastProcessor;

    private String resourcePath = "\\res\\";
    private String currentDir = System.getProperty("user.dir");

    public FutureForecastFrame(String city_name) {
//        System.out.println("future forecast frame");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Aeolus - Three Hour Forecast");
        try {
            frame.setIconImage(ImageIO.read(new File(currentDir + resourcePath + "favicon.png")));
        } catch (IOException e) {
            System.out.println("failed to get favicon");
        }

        panel_main.setLayout(new MigLayout());

//        System.out.println("creating FutureForecastProcessor");
        futureForecastProcessor = new FutureForecastProcessor(city_name);

        /* city & country name */
        String city = futureForecastProcessor.getForecastWeather().getCity();
        String country = futureForecastProcessor.getForecastWeather().getCountry();
        label_city_country = new JLabel();
        label_city_country.setText(city + ", " + country);
        panel_main.add(label_city_country, "span");

        /* three hour forecast tiles */
        threeHourForecast = new ThreeHourForecast(resourcePath, currentDir, futureForecastProcessor.getForecastWeather());
        panel_threeHourForecast = new JScrollPane(threeHourForecast.getPanel(), JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel_threeHourForecast.setBorder(null);
        panel_main.add(panel_threeHourForecast);

        /*** frame final setup ***/
        frame.add(panel_main);
        frame.setVisible(true);
    }

}
