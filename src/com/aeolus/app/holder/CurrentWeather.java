package com.aeolus.app.holder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CurrentWeather {

    private String city, country, description, image, latitude, longitude, temperature, pressure, windSpeed, windDirection, humidity, cloudiness;

    public CurrentWeather(JSONObject jsonObject) {
        // longitude & latitude
        JSONObject coordinate = (JSONObject) jsonObject.get("coord");
        longitude = coordinate.get("lon").toString();
        latitude = coordinate.get("lat").toString();

        // description & icon name
        JSONArray weather = (JSONArray) jsonObject.get("weather");
        JSONObject weather_obj = (JSONObject) weather.get(0);
        description = (String) weather_obj.get("description");
        image = (String) weather_obj.get("icon");

        // city
        city = (String) jsonObject.get("name");

        // temperature, atmosphere pressure, humidity
        JSONObject main = (JSONObject) jsonObject.get("main");
        temperature = main.get("temp").toString();
        humidity = main.get("humidity").toString();
        pressure = main.get("pressure").toString();

        // cloudiness
        JSONObject clouds = (JSONObject) jsonObject.get("clouds");
        cloudiness = clouds.get("all").toString();

        // country
        JSONObject sys = (JSONObject) jsonObject.get("sys");
        country = (String) sys.get("country");

        // wind speed & direction
        JSONObject wind = (JSONObject) jsonObject.get("wind");
        if (wind.get("deg") != null) {
            windDirection = wind.get("deg").toString();
        } else {
            windDirection = "-";
        }
        windSpeed = wind.get("speed").toString();
    }

    public void printAll() {
        System.out.println("city : " + city);
        System.out.println("country : " + country);
        System.out.println("description : " + description);
        System.out.println("image : " + image);
        System.out.println("latitude : " + latitude);
        System.out.println("longitude : " + longitude);
        System.out.println("temperature : " + temperature);
        System.out.println("pressure : " + pressure);
        System.out.println("humidity : " + humidity);
        System.out.println("wind speed : " + windSpeed);
        System.out.println("wind direction : " + windDirection);
        System.out.println("cloudiness : " + cloudiness);
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getCloudiness() {
        return cloudiness;
    }

}
