package com.aeolus.view;

import com.aeolus.app.holder.CurrentCityBase;
import com.aeolus.utils.InFont;
import com.aeolus.utils.InPath;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class CurrentWeatherFrame {
  private JPanel panel = new JPanel();
  private JFrame frame = new JFrame();

  private CurrentCityBase currentCityBase;
  private InFont inFont = new InFont();

  /**
   * Frame (and panel) to show detailed information of the city selected by user.
   * @param ccb CurrentCityBase object from Main frame
   */
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
    JPanel panelWeather = new JPanel();
    panelWeather.setLayout(new MigLayout("wrap 5"));

    /* weather icon */
    String weatherIcon = currentCityBase.getImage();
    JLabel labelWeather = new JLabel();
    ImageIcon logo = new ImageIcon(InPath.getWeatherStateDirectory(weatherIcon));
    labelWeather.setIcon(new ImageIcon(logo.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
    panelWeather.add(labelWeather, "span 1 4, align 50%, gapright 10");

    /* city & country  label */
    String city = currentCityBase.getCity();
    String country = currentCityBase.getCountry();
    JLabel labelCityCountry = new JLabel();
    labelCityCountry.setText(city + ", " + country);
    inFont.setMainFont(labelCityCountry, Font.BOLD, 20);
    panelWeather.add(labelCityCountry, "span 2 1, growx, pushx");

    /* longitude & latitude */
    String lon = currentCityBase.getLongitude();
    String lat = currentCityBase.getLatitude();
    JLabel labelLonLat = new JLabel();
    labelLonLat.setText(lon + ", " + lat);
    inFont.setMainFont(labelLonLat, Font.ITALIC, 14);
    panelWeather.add(labelLonLat, "span 2 1, align 100%");

    /* temperature */
    addLabel(panelWeather,"Temperature");
    String temperature = currentCityBase.getTemperature() + " °C";
    addInformationLeft(panelWeather, temperature);

    /* wind speed */
    addLabel(panelWeather, "Wind speed");
    String windSpeed = currentCityBase.getWindSpeed() + " m/s";
    addInformationRight(panelWeather, windSpeed);

    /* pressure */
    addLabel(panelWeather, "Atm Pressure");
    String pressure = currentCityBase.getPressure() + " hPa";
    addInformationLeft(panelWeather, pressure);

    /* wind degrees */
    addLabel(panelWeather, "Wind degrees");
    String windDegrees = currentCityBase.getWindDirection();
    if (!windDegrees.equals("-")) {
      windDegrees += "°";
    }
    addInformationRight(panelWeather, windDegrees);

    /* humidity */
    addLabel(panelWeather, "Humidity");
    String humidity = currentCityBase.getHumidity() + "%";
    addInformationLeft(panelWeather, humidity);

    /* cloudiness */
    addLabel(panelWeather, "Cloudiness");
    String cloudiness = currentCityBase.getCloudiness() + "%";
    addInformationRight(panelWeather, cloudiness);

    /* weather description */
    String description = currentCityBase.getDescription();
    JLabel labelDescription = new JLabel(description);
    inFont.setMainFont(labelDescription, Font.BOLD, 15);
    panelWeather.add(labelDescription, "align 50%, gapright 10");

    /* button for 5 days forecast */
    JButton buttonForecast = new JButton("See forecast");
    inFont.setBaseFont(buttonForecast, Font.BOLD, 12);
    buttonForecast.setMargin(new Insets(2,12,2,12));
    buttonForecast.setBackground(new Color(29, 116, 117));
    buttonForecast.setForeground(Color.WHITE);
    buttonForecast.setBorderPainted(false);
    buttonForecast.setFocusable(false);
    buttonForecast.addMouseListener(new MouseListener() {
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
    panelWeather.add(buttonForecast, "skip 4, span, align 100%");

    panel.add(panelWeather, "push, grow, gap 10");
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
