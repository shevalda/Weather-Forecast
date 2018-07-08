package com.aeolus.app;

import com.aeolus.app.holder.CurrentWeather;

import java.net.HttpURLConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SearchProcessor extends Processor {
  private CurrentWeather currentWeather;

  /**
   * Processor for Main frame (and CurrentWeather frame).
   * @param cityName the city's name given by user input
   */
  public SearchProcessor(String cityName) {
    createConnection(getApi().generateWeatherURL(cityName));
    if (getResponseCode() == HttpURLConnection.HTTP_OK) {
      readJSONResponse();
    }
  }

  public CurrentWeather getCurrentWeather() {
    return currentWeather;
  }

  @Override
  protected void readJSONResponse() {
    JSONParser parser = new JSONParser();
    try {
      Object obj = parser.parse(getResponse());
      JSONObject jsonObject = (JSONObject) obj;
      currentWeather = new CurrentWeather(jsonObject);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

}
