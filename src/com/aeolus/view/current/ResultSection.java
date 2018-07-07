package com.aeolus.view.current;

import com.aeolus.app.holder.CurrentCityBase;
import com.aeolus.app.holder.CurrentWeather;
import com.aeolus.view.CurrentWeatherFrame;
import com.aeolus.view.PartPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ResultSection extends PartPanel {

    public ResultSection(JLabel label_result) {
        inFont.setBaseFont(label_result, Font.BOLD, 12);

        getPanel().setLayout(new MigLayout());

        label_result.setVisible(false);
        getPanel().add(label_result, "span, gapbottom 7");
        getPanel().setVisible(false);
    }

    public void showResults(CurrentWeather currentWeather) {
        for (CurrentCityBase ccb : currentWeather.getBases()) {
            JPanel panel_cw = new JPanel();
            panel_cw.setLayout(new MigLayout());
            panel_cw.setBackground(new Color(29, 116, 117));

            /* city, country */
            JLabel label_city_country = new JLabel(ccb.getCity() + ", " + ccb.getCountry());
            label_city_country.setForeground(Color.WHITE);
            inFont.setMainFont(label_city_country, Font.BOLD, 14);
            panel_cw.add(label_city_country, "pushx, growx, gapleft 10");

            /* longitude, latitude */
            JLabel label_lon_lat = new JLabel(ccb.getLongitude() + ", " + ccb.getLatitude());
            label_lon_lat.setForeground(Color.WHITE);
            inFont.setMainFont(label_lon_lat);
            panel_cw.add(label_lon_lat, "align 100%, gapright 10");

            panel_cw.addMouseListener(new MouseListener() {
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

            getPanel().add(panel_cw, "span, pushx, growx, gapbottom 5");
        }
    }

    public void removeAllResultList() {
        Component[] components = getPanel().getComponents();
        for (Component c : components) {
            if (c instanceof JPanel) {
                getPanel().remove(c);
            }
        }
    }

}
