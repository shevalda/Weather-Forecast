package test.com.aeolus.app.holder; 

import com.aeolus.app.FutureForecastProcessor;
import com.aeolus.app.holder.ThreeHourBase;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.Test;

/** 
* ThreeHourBase Tester. 
* 
* @author Shevalda Gracielira
* @since <pre>Jul 8, 2018</pre> 
* @version 1.0 
*/ 
public class ThreeHourBaseTest { 
  ThreeHourBase thb;

  public ThreeHourBaseTest() {
    FutureForecastProcessor ffp = new FutureForecastProcessor("1631761");
    thb = ffp.getForecastWeather().getBases().get(0);
  }

  /**
  *
  * Method: getTemperature()
  *
  */
  @Test
  public void testGetTemperature() throws Exception {
    assertNotNull(thb.getTemperature());
  }

  /**
  *
  * Method: getPressure()
  *
  */
  @Test
  public void testGetPressure() throws Exception {
    assertNotNull(thb.getPressure());
  }

  /**
  *
  * Method: getHumidity()
  *
  */
  @Test
  public void testGetHumidity() throws Exception {
    assertNotNull(thb.getHumidity());
  }

  /**
  *
  * Method: getCloudiness()
  *
  */
  @Test
  public void testGetCloudiness() throws Exception {
    assertNotNull(thb.getCloudiness());
  }

  /**
  *
  * Method: getWindSpeed()
  *
  */
  @Test
  public void testGetWindSpeed() throws Exception {
    assertNotNull(thb.getWindSpeed());
  }

  /**
  *
  * Method: getWindDirection()
  *
  */
  @Test
  public void testGetWindDirection() throws Exception {
    assertNotNull(thb.getWindDirection());
  }

  /**
  *
  * Method: getRainVolume()
  *
  */
  @Test
  public void testGetRainVolume() throws Exception {
    assertNotNull(thb.getRainVolume());
  }

  /**
  *
  * Method: getImage()
  *
  */
  @Test
  public void testGetImage() throws Exception {
    assertNotNull(thb.getImage());
  }

  /**
  *
  * Method: getDescription()
  *
  */
  @Test
  public void testGetDescription() throws Exception {
    assertNotNull(thb.getDescription());
  }

  /**
  *
  * Method: getDate()
  *
  */
  @Test
  public void testGetDate() throws Exception {
    assertNotNull(thb.getDate());
  }

  /**
  *
  * Method: getTime()
  *
  */
  @Test
  public void testGetTime() throws Exception {
    assertNotNull(thb.getTime());
  }

  /**
  *
  * Method: getDayNight()
  *
  */
  @Test
  public void testGetDayNight() throws Exception {
    assertNotNull(thb.getDayNight());
  }


} 
