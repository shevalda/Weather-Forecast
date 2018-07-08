package com.aeolus.app.holder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ThreeHourBase {
  private String temperature;
  private String pressure;
  private String humidity;
  private String cloudiness;
  private String windSpeed;
  private String windDirection;
  private String rainVolume;
  private String image;
  private String description;
  private String date;
  private String time;
  private String dayNight;

  /**
   * Holds the detailed information of three-hour forecast.
   * @param jsonObject  JSON object of one three-hour forecast
   */
  public ThreeHourBase(JSONObject jsonObject) {
    /*  temperature, pressure, humidity */
    JSONObject main = (JSONObject) jsonObject.get("main");
    temperature = main.get("temp").toString();
    pressure = main.get("pressure").toString();
    humidity = main.get("humidity").toString();

    /* description & image */
    JSONArray weatherArr = (JSONArray) jsonObject.get("weather");
    JSONObject weatherObj = (JSONObject) weatherArr.get(0);
    description = (String) weatherObj.get("description");
    image = (String) weatherObj.get("icon");

    /* cloudiness */
    JSONObject clouds = (JSONObject) jsonObject.get("clouds");
    cloudiness = clouds.get("all").toString();

    /* wind direction & speed */
    JSONObject wind = (JSONObject) jsonObject.get("wind");
    windSpeed = wind.get("speed").toString();
    if (wind.get("deg") != null) {
      windDirection = wind.get("speed").toString();
    } else {
      windDirection = "-";
    }

    /* rain volume */
    if (jsonObject.get("rain") != null) {
      JSONObject rain = (JSONObject) jsonObject.get("rain");
      if (rain.get("3h") != null) {
        rainVolume = rain.get("3h").toString();
      } else  {
        rainVolume = "-";
      }
    } else {
      rainVolume = "-";
    }

    /* day or night */
    JSONObject sys = (JSONObject) jsonObject.get("sys");
    dayNight = (String) sys.get("pod");

    /* time & date */
    String dateTime = (String) jsonObject.get("dt_txt");
    String[] dateTimeSplit = dateTime.split(" ");
    String[] dateTemp = dateTimeSplit[0].split("-");
    date = dateTemp[2] + "/" + dateTemp[1];

    String[] timeTemp = dateTimeSplit[1].split(":");
    time = timeTemp[0] + ":" + timeTemp[1];
  }

  public String getTemperature() {
    return temperature;
  }

  public String getPressure() {
    return pressure;
  }

  public String getHumidity() {
    return humidity;
  }

  public String getCloudiness() {
    return cloudiness;
  }

  public String getWindSpeed() {
    return windSpeed;
  }

  public String getWindDirection() {
    return windDirection;
  }

  public String getRainVolume() {
    return rainVolume;
  }

  public String getImage() {
    return image;
  }

  public String getDescription() {
    return description;
  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public String getDayNight() {
    return dayNight;
  }

}
