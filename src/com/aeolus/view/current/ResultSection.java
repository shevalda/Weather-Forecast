package com.aeolus.view.current;

import com.aeolus.app.holder.CurrentCityBase;
import com.aeolus.app.holder.CurrentWeather;
import com.aeolus.view.CurrentWeatherFrame;
import com.aeolus.view.PartPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class ResultSection extends PartPanel {

  /**
   * One of panel in Main frame.
   * Responsible of showing result list.
   * @param labelResult  label from Main frame
   */
  public ResultSection(JLabel labelResult) {
    inFont.setBaseFont(labelResult, Font.BOLD, 12);

    getPanel().setLayout(new MigLayout());

    labelResult.setVisible(false);
    getPanel().add(labelResult, "span, gapbottom 7");
    getPanel().setVisible(false);
  }

  /**
   * Shows the list of every city given by the API.
   * @param currentWeather  a CurrentWeather object from Main frame
   */
  public void showResults(CurrentWeather currentWeather) {
    for (CurrentCityBase ccb : currentWeather.getBases()) {
      JPanel panelCw = new JPanel();
      panelCw.setLayout(new MigLayout());
      panelCw.setBackground(new Color(29, 116, 117));

      /* city, country */
      JLabel labelCityCountry = new JLabel(ccb.getCity() + ", " + ccb.getCountry());
      labelCityCountry.setForeground(Color.WHITE);
      inFont.setMainFont(labelCityCountry, Font.BOLD, 14);
      panelCw.add(labelCityCountry, "pushx, growx, gapleft 10");

      /* longitude, latitude */
      JLabel labelLonLat = new JLabel(ccb.getLongitude() + ", " + ccb.getLatitude());
      labelLonLat.setForeground(Color.WHITE);
      inFont.setMainFont(labelLonLat);
      panelCw.add(labelLonLat, "align 100%, gapright 10");

      panelCw.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
          new CurrentWeatherFrame(ccb);
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
      });

      getPanel().add(panelCw, "span, pushx, growx, gapbottom 5");
    }
  }

  /**
   * Removes all previous result list.
   */
  public void removeAllResultList() {
    Component[] components = getPanel().getComponents();
    for (Component c : components) {
      if (c instanceof JPanel) {
        getPanel().remove(c);
      }
    }
  }

}
