package com.aeolus.app.holder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class CurrentWeather {

    private ArrayList<CurrentCityBase> bases;

    private int baseCount;

    public CurrentWeather(JSONObject jsonObject) {
        baseCount = ((Long) jsonObject.get("count")).intValue();
        bases = new ArrayList<>(baseCount);

        JSONArray list = (JSONArray) jsonObject.get("list");
        for(int i = 0; i < baseCount; i++) {
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
