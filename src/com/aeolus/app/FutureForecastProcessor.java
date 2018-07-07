package com.aeolus.app;

import com.aeolus.app.holder.ForecastWeather;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.HttpURLConnection;

public class FutureForecastProcessor extends Processor {
    private ForecastWeather forecastWeather;

    public FutureForecastProcessor(String city_name) {
        createConnection(getApi().generateForecastURL(city_name));
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
