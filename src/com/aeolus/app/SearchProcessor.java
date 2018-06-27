package com.aeolus.app;

import com.aeolus.app.holder.CurrentWeather;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchProcessor {
    private Api api = new Api();
    private CurrentWeather currentWeather = new CurrentWeather();

    private String city_name;
    private String response;
    private int responseCode;

    public SearchProcessor(String city_name) {
        this.city_name = city_name;
        createConnection();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            readJSONResponse();
        }
    }

    public int getResponseCode() {
        return responseCode;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    private void createConnection() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(api.generateWeatherURL(city_name));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {    // connection successful
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                response = sb.toString();
            } else {
                System.out.println("Response code : " + responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

    private void readJSONResponse() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(response);
            JSONObject jsonObject = (JSONObject) obj;

            // longitude & latitude
            JSONObject coordinate = (JSONObject) jsonObject.get("coord");
            currentWeather.setLongitude(coordinate.get("lon").toString());
            currentWeather.setLatitude(coordinate.get("lat").toString());

            // description & icon name
            JSONArray weather = (JSONArray) jsonObject.get("weather");
            JSONObject weather_obj = (JSONObject) weather.get(0);
            currentWeather.setDescription((String) weather_obj.get("description"));
            currentWeather.setImage((String) weather_obj.get("icon"));

            // city
            currentWeather.setCity((String) jsonObject.get("name"));

            // temperature, atmosphere pressure, humidity
            JSONObject main = (JSONObject) jsonObject.get("main");
            currentWeather.setTemperature(main.get("temp").toString());
            currentWeather.setHumidity(main.get("humidity").toString());
            currentWeather.setPressure(main.get("pressure").toString());

            // cloudiness
            JSONObject clouds = (JSONObject) jsonObject.get("clouds");
            currentWeather.setCloudiness(clouds.get("all").toString());

            // country
            JSONObject sys = (JSONObject) jsonObject.get("sys");
            currentWeather.setCountry((String) sys.get("country"));

            // wind speed & direction
            JSONObject wind = (JSONObject) jsonObject.get("wind");
            if (wind.get("deg") != null) {
                currentWeather.setWindDirection(wind.get("deg").toString());
            } else {
                currentWeather.setWindDirection("-");
            }
            currentWeather.setWindSpeed(wind.get("speed").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
