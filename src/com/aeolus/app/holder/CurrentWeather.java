package com.aeolus.app.holder;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CurrentWeather {
  private ArrayList<CurrentCityBase> bases;

  private int baseCount;

  /**
   * Holds the result of cities similar to user's input.
   * @param jsonObject  API response in JSON object type
   */
  public CurrentWeather(JSONObject jsonObject) {
    baseCount = ((Long) jsonObject.get("count")).intValue();
    bases = new ArrayList<>(baseCount);

    JSONArray list = (JSONArray) jsonObject.get("list");
    for (int i = 0; i < baseCount; i++) {
      CurrentCityBase currentCityBase = new CurrentCityBase((JSONObject) list.get(i));
      bases.add(currentCityBase);
    }
  }

  public ArrayList<CurrentCityBase> getBases() {
    return bases;
  }

  public int getBaseCount() {
    return baseCount;
  }

}
