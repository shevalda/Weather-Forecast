package com.aeolus.app;

import com.aeolus.app.holder.CurrentWeather;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.HttpURLConnection;

public class SearchProcessor extends Processor {
    private CurrentWeather currentWeather;

    public SearchProcessor(String city_name) {
        createConnection(getApi().generateWeatherURL(city_name));
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
