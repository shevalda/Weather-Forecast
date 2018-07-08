package test.com.aeolus.app.holder; 

import com.aeolus.app.SearchProcessor;
import com.aeolus.app.holder.CurrentWeather;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.Test;

/** 
* CurrentWeather Tester. 
* 
* @author Shevalda Gracielira
* @since <pre>Jul 8, 2018</pre> 
* @version 1.0 
*/ 
public class CurrentWeatherTest {
  CurrentWeather cw;

  public static void main(String[] args) {
    new CurrentWeatherTest();
  }

  public CurrentWeatherTest() {
    SearchProcessor sp = new SearchProcessor("Pekanbaru");
    cw = sp.getCurrentWeather();
  }

  /**
  *
  * Method: getBases()
  *
  */
  @Test
  public void testGetBases() {
    if (cw.getBaseCount() != 0) {
      assertNotNull(cw.getBases());
    }
  }

} 
