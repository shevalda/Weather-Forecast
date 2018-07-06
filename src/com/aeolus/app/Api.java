package com.aeolus.app;

public class Api {
    private String key;

    public Api() {
        // INSERT YOUR OPENWEATHERMAP HERE
        // e.g. key = "qwertyuiop123456789";
        
    }

    public String generateWeatherURL(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather";
        url += "?q=" + city;
        url += "&units=metric";
        url += "&appid=" + key;
        return url;
    }

    public String generateForecastURL(String city) {
        String url = "http://api.openweathermap.org/data/2.5/forecast";
        url += "?q=" + city;
        url += "&units=metric";
        url += "&appid=" + key;
        return url;
    }
}
