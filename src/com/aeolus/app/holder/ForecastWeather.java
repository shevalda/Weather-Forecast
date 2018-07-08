package com.aeolus.app.holder;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ForecastWeather {
  private ArrayList<ThreeHourBase> bases;

  private String city;
  private String country;
  private String longitude;
  private String latitude;
  private int baseCount;

  /**
   * Holds the result of the forecast API's response.
   * @param jsonObject  the response in JSON object
   */
  public ForecastWeather(JSONObject jsonObject) {
    /* city & country */
    JSONObject cityObj = (JSONObject) jsonObject.get("city");
    city = (String) cityObj.get("name");
    country = (String) cityObj.get("country");
    JSONObject coord = (JSONObject) cityObj.get("coord");
    latitude = coord.get("lat").toString();
    longitude = coord.get("lon").toString();

    baseCount = ((Long) jsonObject.get("cnt")).intValue();
    bases = new ArrayList<>(baseCount);
    JSONArray list = (JSONArray) jsonObject.get("list");
    for (int i = 0; i < baseCount; i++) {
      JSONObject listObj = (JSONObject) list.get(i);
      ThreeHourBase threeHourBase = new ThreeHourBase(listObj);
      bases.add(threeHourBase);
    }
  }

  public ArrayList<ThreeHourBase> getBases() {
    return bases;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public String getLongitude() {
    return longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public int getBaseCount() {
    return baseCount;
  }
}
