package com.aeolus.app;

import com.aeolus.app.holder.ForecastWeather;

import java.net.HttpURLConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FutureForecastProcessor extends Processor {
  private ForecastWeather forecastWeather;

  /**
   * Processor for FutureForecast frame.
   * @param cityId  the id of the city that will generated
   */
  public FutureForecastProcessor(String cityId) {
    createConnection(getApi().generateForecastURL(cityId));
    if (getResponseCode() == HttpURLConnection.HTTP_OK) {
      readJSONResponse();
    }
  }

  public ForecastWeather getForecastWeather() {
    return forecastWeather;
  }

  @Override
  protected void readJSONResponse() {
    JSONParser parser = new JSONParser();
    try {
      Object obj = parser.parse(getResponse());
      JSONObject jsonObject = (JSONObject) obj;
      forecastWeather = new ForecastWeather(jsonObject);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

}
