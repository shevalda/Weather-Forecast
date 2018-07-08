package test.com.aeolus.app; 

import com.aeolus.app.SearchProcessor;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.Test;

/** 
* SearchProcessor Tester. 
* 
* @author Shevalda Gracielira
* @since <pre>Jul 8, 2018</pre> 
* @version 1.0 
*/ 
public class SearchProcessorTest {
  SearchProcessor sp;

  public SearchProcessorTest() {
    sp = new SearchProcessor("Pekanbaru");
  }

  /**
  *
  * Method: getCurrentWeather()
  *
  */
  @Test
  public void testGetCurrentWeather() throws Exception {
    if (sp.getResponseCode() == 200) {
      assertNotNull(sp.getCurrentWeather());
    }
  }

  /**
  *
  * Method: readJSONResponse()
  *
  */
  @Test
  public void testReadJSONResponse() throws Exception {
    if (sp.getResponseCode() == 200) {
      assertNotNull(sp.getCurrentWeather());
    }
  }


} 
