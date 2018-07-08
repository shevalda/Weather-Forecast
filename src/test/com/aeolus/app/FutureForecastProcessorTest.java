package test.com.aeolus.app; 

import com.aeolus.app.FutureForecastProcessor;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.Test;

/** 
* FutureForecastProcessor Tester. 
* 
* @author Shevalda Gracielira
* @since <pre>Jul 8, 2018</pre> 
* @version 1.0 
*/ 
public class FutureForecastProcessorTest {
  FutureForecastProcessor ffp;

  public FutureForecastProcessorTest() {
    ffp = new FutureForecastProcessor("1631761");
  }

  /**
  *
  * Method: getForecastWeather()
  *
  */
  @Test
  public void testGetForecastWeather() throws Exception {
    if (ffp.getResponseCode() == 200) {
      assertNotNull(ffp.getForecastWeather());
    }
  }

  /**
  *
  * Method: readJSONResponse()
  *
  */
  @Test
  public void testReadJSONResponse() throws Exception {
    if (ffp.getResponseCode() == 200) {
      assertNotNull(ffp.getForecastWeather());
    }
  }


} 
