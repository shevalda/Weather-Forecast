package test.com.aeolus.app.holder; 

import com.aeolus.app.FutureForecastProcessor;
import com.aeolus.app.holder.ForecastWeather;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

/** 
* ForecastWeather Tester. 
* 
* @author Shevalda Gracielira
* @since <pre>Jul 8, 2018</pre> 
* @version 1.0 
*/ 
public class ForecastWeatherTest {
  ForecastWeather fw;

  public static void main(String[] args) {
    new ForecastWeatherTest();
  }

  public ForecastWeatherTest() {
    FutureForecastProcessor ffp = new FutureForecastProcessor("1631761");
    fw = ffp.getForecastWeather();
  }

  /**
  *
  * Method: getBases()
  *
  */
  @Test
  public void testGetBases() throws Exception {
    if (fw.getBaseCount() != 0) {
      assertNotNull(fw.getBases());
    }
  }

  /**
  *
  * Method: getCity()
  *
  */
  @Test
  public void testGetCity() throws Exception {
    assertEquals("Pekanbaru", fw.getCity());
  }

  /**
  *
  * Method: getCountry()
  *
  */
  @Test
  public void testGetCountry() throws Exception {
    assertEquals("ID", fw.getCountry());
  }

  /**
  *
  * Method: getLongitude()
  *
  */
  @Test
  public void testGetLongitude() throws Exception {
    assertEquals("101.45", fw.getLongitude());
  }

  /**
  *
  * Method: getLatitude()
  *
  */
  @Test
  public void testGetLatitude() throws Exception {
    assertEquals("0.5333", fw.getLongitude());
  }


} 
