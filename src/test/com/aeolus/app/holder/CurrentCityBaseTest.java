package test.com.aeolus.app.holder; 

import com.aeolus.app.SearchProcessor;
import com.aeolus.app.holder.CurrentCityBase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.Test;

/** 
* CurrentCityBase Tester. 
*
* @author Shevalda Gracielira
* @since <pre>Jul 8, 2018</pre> 
* @version 1.0 
*/ 
public class CurrentCityBaseTest {
  private CurrentCityBase ccb;

  public static void main(String[] args) {
    new CurrentCityBaseTest();
  }

  public CurrentCityBaseTest() {
    SearchProcessor sp = new SearchProcessor("Pekanbaru");
    ccb = sp.getCurrentWeather().getBases().get(0);
  }

  /**
  *
  * Method: getId()
  *
  */
  @Test
  public void testGetId() throws Exception {
    assertEquals("1631761", ccb.getId());
  }

  /**
  *
  * Method: getCity()
  *
  */
  @Test
  public void testGetCity() throws Exception {
    assertEquals("Pekanbaru", ccb.getCity());
  }

  /**
  *
  * Method: getCountry()
  *
  */
  @Test
  public void testGetCountry() throws Exception {
    assertEquals("ID", ccb.getCountry());
  }

  /**
  *
  * Method: getDescription()
  *
  */
  @Test
  public void testGetDescription() throws Exception {
    assertNotNull(ccb.getDescription());
  }

  /**
  *
  * Method: getImage()
  *
  */
  @Test
  public void testGetImage() throws Exception {
    assertNotNull(ccb.getImage());
  }

  /**
  *
  * Method: getLatitude()
  *
  */
  @Test
  public void testGetLatitude() throws Exception {
    assertEquals("0.5374", ccb.getLatitude());
  }

  /**
  *
  * Method: getLongitude()
  *
  */
  @Test
  public void testGetLongitude() throws Exception {
    assertEquals("101.4458", ccb.getLongitude());
  }

  /**
  *
  * Method: getTemperature()
  *
  */
  @Test
  public void testGetTemperature() throws Exception {
    assertNotNull(ccb.getTemperature());
  }

  /**
  *
  * Method: getPressure()
  *
  */
  @Test
  public void testGetPressure() throws Exception {
    assertNotNull(ccb.getPressure());
  }

  /**
  *
  * Method: getWindSpeed()
  *
  */
  @Test
  public void testGetWindSpeed() throws Exception {
    assertNotNull(ccb.getWindSpeed());
  }

  /**
  *
  * Method: getWindDirection()
  *
  */
  @Test
  public void testGetWindDirection() throws Exception {
    assertNotNull(ccb.getWindDirection());
  }

  /**
  *
  * Method: getHumidity()
  *
  */
  @Test
  public void testGetHumidity() throws Exception {
    assertNotNull(ccb.getHumidity());
  }

  /**
  *
  * Method: getCloudiness()
  *
  */
  @Test
  public void testGetCloudiness() throws Exception {
    assertNotNull(ccb.getCloudiness());
  }


} 
