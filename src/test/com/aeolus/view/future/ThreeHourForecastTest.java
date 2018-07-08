package test.com.aeolus.view.future; 

import com.aeolus.app.FutureForecastProcessor;
import com.aeolus.app.holder.ForecastWeather;
import com.aeolus.view.future.ThreeHourForecast;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.miginfocom.swing.MigLayout;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

/** 
* ThreeHourForecast Tester. 
* 
* @author Shevalda Gracielira
* @since <pre>Jul 8, 2018</pre> 
* @version 1.0 
*/ 
public class ThreeHourForecastTest {

  /**
  *
  * Method: addWeatherTile(ThreeHourBase thb)
  *
  */
  @Test
  public void testAddWeatherTile() throws Exception {
    FutureForecastProcessor ffp = new FutureForecastProcessor("1631761");
    ForecastWeather fw = ffp.getForecastWeather();
    ThreeHourForecast thf = new ThreeHourForecast(fw);
    int panelCount = 0;
    for (Component c : thf.getPanel().getComponents()) {
      if (c instanceof JPanel) {
        panelCount++;
      }
    }
    assertTrue(panelCount > 0);
  }

} 
