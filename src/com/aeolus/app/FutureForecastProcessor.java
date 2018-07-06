package com.aeolus.app;

import com.aeolus.app.holder.ForecastWeather;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.HttpURLConnection;

public class FutureForecastProcessor extends Processor {
    private ForecastWeather forecastWeather;

    public FutureForecastProcessor(String city_name) {
//        System.out.println("FutureForecastProcessor created");
        createConnection(getApi().generateForecastURL(city_name));
//        System.out.println("connection created");
        if (getResponseCode() == HttpURLConnection.HTTP_OK) {
            readJSONResponse();
        }
    }

    public ForecastWeather getForecastWeather() {
        return forecastWeather;
    }

    @Override
    protected void readJSONResponse() {
//        System.out.println("parsing JSON");
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
