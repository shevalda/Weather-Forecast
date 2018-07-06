package com.aeolus.app.holder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class ForecastWeather {
    private ArrayList<ThreeHourBase> bases;

    private String city, country;
    private int baseCount;

    public ForecastWeather(JSONObject jsonObject) {
//        System.out.println("ForecastWeather");
        // city & country
        JSONObject cityObj = (JSONObject) jsonObject.get("city");
        city = (String) cityObj.get("name");
//        System.out.println("city");
        country = (String) cityObj.get("country");
//        System.out.println("country");

        baseCount = ((Long) jsonObject.get("cnt")).intValue();
//        System.out.println("base count");
        bases = new ArrayList<>(baseCount);
        fillBases((JSONArray) jsonObject.get("list"));
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

    private void fillBases(JSONArray jsonArray) {
//        System.out.println("fill bases");
        for (int i = 0; i < baseCount; i++) {
//            System.out.println(i);
            JSONObject listObj = (JSONObject) jsonArray.get(i);
            ThreeHourBase threeHourBase = new ThreeHourBase(listObj);
            bases.add(threeHourBase);
        }
    }

//    public void print() {
//        System.out.println("city : " + city);
//        System.out.println("country : " + country);
//        System.out.println("base count : " + baseCount);
//        System.out.println();
//        for (ThreeHourBase thb : bases) {
//            thb.printAll();
//            System.out.println();
//        }
//    }

}
