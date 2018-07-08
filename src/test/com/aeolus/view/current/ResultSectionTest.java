package test.com.aeolus.view.current; 

import com.aeolus.app.SearchProcessor;
import com.aeolus.app.holder.CurrentWeather;
import com.aeolus.view.current.ResultSection;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

/** 
* ResultSection Tester. 
* 
* @author <Authors name> 
* @since <pre>Jul 8, 2018</pre> 
* @version 1.0 
*/ 
public class ResultSectionTest {
  ResultSection rs;
  SearchProcessor sp;

  public ResultSectionTest() {
    JLabel label = new JLabel("A label");
    rs = new ResultSection(label);
    sp = new SearchProcessor("Pekanbaru");
  }

  /**
  *
  * Method: showResults(CurrentWeather currentWeather)
  *
  */
  @Test
  public void testShowResults() throws Exception {
    if (sp.getResponseCode() == 200) {
      CurrentWeather cw = sp.getCurrentWeather();
      if (cw.getBaseCount() != 0) {
        rs.showResults(cw);
        int panelCount = 0;
        for (Component c : rs.getPanel().getComponents()) {
          if (c instanceof JPanel) {
            panelCount++;
          }
        }
        assertTrue(panelCount > 0);
      }
    }
  }

  /**
  *
  * Method: removeAllResultList()
  *
  */
  @Test
  public void testRemoveAllResultList() throws Exception {
    if (sp.getResponseCode() == 200) {
      CurrentWeather cw = sp.getCurrentWeather();
      if (cw.getBaseCount() != 0) {
        rs.showResults(cw);
        rs.removeAllResultList();
        int panelCount = 0;
        for (Component c : rs.getPanel().getComponents()) {
          if (c instanceof JPanel) {
            panelCount++;
          }
        }
        assertEquals(0, panelCount);
      }
    }
  }


} 
