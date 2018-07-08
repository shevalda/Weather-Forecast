package com.aeolus.utils;

public class Api {
  private String key;

  /**
   * Responsible for generating API call for all the processors.
   */
  public Api() {
    // INSERT YOUR OPENWEATHERMAP HERE
    // e.g. key = "qwertyuiop123456789";
  }

  /**
   * Generates API call for Main frame and CurrentWeather frame.
   * @param city  the name of the city given by user
   * @return      string of the API call
   */
  public String generateWeatherURL(String city) {
    String url = "http://api.openweathermap.org/data/2.5/find";
    url += "?q=" + city;
    url += "&type=accurate";
    url += "&units=metric";
    url += "&appid=" + key;
    return url;
  }

  /**
   * Generates API call for FutureForecast frame.
   * @param id  the ID of the city selected by the user in CurrentWeather frame
   * @return    string of the API call
   */
  public String generateForecastURL(String id) {
    String url = "http://api.openweathermap.org/data/2.5/forecast";
    url += "?id=" + id;
    url += "&units=metric";
    url += "&appid=" + key;
    return url;
  }
}
