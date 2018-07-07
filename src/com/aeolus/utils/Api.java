package com.aeolus.utils;

public class Api {
    private String key;

    public Api() {
        // INSERT YOUR OPENWEATHERMAP HERE
        // e.g. key = "qwertyuiop123456789";
        
    }

    public String generateWeatherURL(String city) {
        String url = "http://api.openweathermap.org/data/2.5/find";
        url += "?q=" + city;
        url += "&type=accurate";
        url += "&units=metric";
        url += "&appid=" + key;
        return url;
    }

    public String generateForecastURL(String city_id) {
        String url = "http://api.openweathermap.org/data/2.5/forecast";
        url += "?id=" + city_id;
        url += "&units=metric";
        url += "&appid=" + key;
        return url;
    }
}
