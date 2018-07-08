package com.aeolus.view;

import com.aeolus.app.FutureForecastProcessor;
import com.aeolus.utils.InFont;
import com.aeolus.utils.InPath;
import com.aeolus.view.future.ThreeHourForecast;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

public class FutureForecastFrame {
  private JFrame frame = new JFrame();
  private JPanel panelMain = new JPanel();
  private JScrollPane panelThreeHourForecast;
  private JLabel labelCityCountry;
  private JLabel labelLonLat;

  private ThreeHourForecast threeHourForecast;
  private FutureForecastProcessor futureForecastProcessor;
  private InFont inFont = new InFont();

  /**
   * Frame for five-day-of-three-hour forecast of the selected city.
   * @param cityId  the id of the city selected by user
   */
  public FutureForecastFrame(String cityId) {
    frame.setSize(500, 400);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    try {
      frame.setIconImage(ImageIO.read(new File(InPath.getResourceDirectory("favicon.png"))));
    } catch (IOException e) {
      System.out.println("failed to get favicon");
    }

    panelMain.setLayout(new MigLayout());

    futureForecastProcessor = new FutureForecastProcessor(cityId);

    /* city & country name */
    String city = futureForecastProcessor.getForecastWeather().getCity();
    String country = futureForecastProcessor.getForecastWeather().getCountry();
    frame.setTitle("Aeolus - " + city + ", " + country + " Forecast");
    labelCityCountry = new JLabel(city + ", " + country);
    inFont.setBaseFont(labelCityCountry, Font.BOLD, 20);
    panelMain.add(labelCityCountry, "grow, push, gapleft 5");

    String longitude = futureForecastProcessor.getForecastWeather().getLongitude();
    String latitude = futureForecastProcessor.getForecastWeather().getLatitude();
    labelLonLat = new JLabel(longitude + ", " + latitude);
    inFont.setBaseFont(labelLonLat);
    panelMain.add(labelLonLat, "span, align 100%");

    /* three hour forecast tiles */
    threeHourForecast = new ThreeHourForecast(futureForecastProcessor.getForecastWeather());
    panelThreeHourForecast = new JScrollPane(threeHourForecast.getPanel(), JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    panelThreeHourForecast.setBorder(null);
    panelMain.add(panelThreeHourForecast, "span 2 1");

    /*** frame final setup ***/
    frame.add(panelMain);
    frame.setVisible(true);
  }

}
