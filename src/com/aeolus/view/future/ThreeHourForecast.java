package com.aeolus.view.future;

import com.aeolus.app.holder.ForecastWeather;
import com.aeolus.app.holder.ThreeHourBase;
import com.aeolus.utils.InPath;
import com.aeolus.view.PartPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class ThreeHourForecast extends PartPanel {

  /**
   * Responsible for three-hour forecast panel.
   * @param fw ForecastWeather object from FutureForecast frame
   */
  public ThreeHourForecast(ForecastWeather fw) {
    getPanel().setLayout(new MigLayout());
    for (ThreeHourBase thb : fw.getBases()) {
      addWeatherTile(thb);
    }
  }

  private void addWeatherTile(ThreeHourBase thb) {
    JPanel panelTile = new JPanel();
    panelTile.setLayout(new MigLayout("wrap 2"));

    /* weather icon */
    String weatherIcon = thb.getImage();
    JLabel labelWeather = new JLabel();
    ImageIcon logo = new ImageIcon(InPath.getWeatherStateDirectory(weatherIcon));
    labelWeather.setIcon(new ImageIcon(logo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    panelTile.add(labelWeather, "span, align 50%, gaptop 5");

    /* description */
    String description = thb.getDescription();
    JLabel labelDescription = new JLabel(description);
    inFont.setMainFont(labelDescription, Font.BOLD, 14);
    panelTile.add(labelDescription, "span, align 50%, gapbottom 10");

    /* temperature */
    addLabel(panelTile, "Temperature");
    String temperature = thb.getTemperature() + " °C";
    addInformation(panelTile, temperature);

    /* pressure */
    addLabel(panelTile, "Atm pressure");
    String pressure = thb.getPressure() + " hPa";
    addInformation(panelTile, pressure);

    /* humidity */
    addLabel(panelTile, "Humidity");
    String humidity = thb.getHumidity() + "%";
    addInformation(panelTile, humidity);

    /* cloudiness */
    addLabel(panelTile, "Cloudiness");
    String cloudiness = thb.getCloudiness() + "%";
    addInformation(panelTile, cloudiness);

    /* wind speed */
    addLabel(panelTile, "Wind speed");
    String windSpeed = thb.getWindSpeed() + "m/s";
    addInformation(panelTile, windSpeed);

    /* wind degrees */
    addLabel(panelTile, "Wind degrees");
    String windDegrees = thb.getWindDirection() + "°";
    addInformation(panelTile, windDegrees);

    /* rain volume */
    addLabel(panelTile, "Rain volume");
    String rainVolume = thb.getRainVolume();
    addInformation(panelTile, rainVolume);

    /* time (date) */
    String date = thb.getDate();
    JLabel labelDate = new JLabel();
    labelDate.setText(date);
    inFont.setMainFont(labelDate, Font.BOLD, 15);
    panelTile.add(labelDate, "align 50%, span, gaptop 5");

    /* time (clock) */
    String clock = thb.getTime();
    JLabel labelClock = new JLabel();
    labelClock.setText(clock);
    inFont.setMainFont(labelClock, 14);
    panelTile.add(labelClock, "align 50%, span, gapbottom 5");

    if (thb.getDayNight().equals("d")) {
      panelTile.setBackground(new Color(236, 209, 128));
    } else {
      panelTile.setBackground(new Color(3, 30, 60));
      for (Component c : panelTile.getComponents()) {
        c.setForeground(Color.WHITE);
      }
    }

    getPanel().add(panelTile, "pushy, growy, gap 5");
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
