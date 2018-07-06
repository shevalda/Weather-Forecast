package com.aeolus.app.holder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ThreeHourBase {
    private String temperature, pressure, humidity, cloudiness, windSpeed, windDirection, rainVolume;
    private String image, description, date, time, dayNight;

    public ThreeHourBase(JSONObject jsonObject) {
        // temperature, pressure, humidity
        JSONObject main = (JSONObject) jsonObject.get("main");
        temperature = main.get("temp").toString();
//        System.out.println("temperature");
        pressure = main.get("pressure").toString();
//        System.out.println("pressure");
        humidity = main.get("humidity").toString();
//        System.out.println("humidity");

        // description & image
        JSONArray weatherArr = (JSONArray) jsonObject.get("weather");
        JSONObject weatherObj = (JSONObject) weatherArr.get(0);
        description = (String) weatherObj.get("description");
//        System.out.println("description");
        image = (String) weatherObj.get("icon");
//        System.out.println("image");

        // cloudiness
        JSONObject clouds = (JSONObject) jsonObject.get("clouds");
        cloudiness = clouds.get("all").toString();
//        System.out.println("cloudiness");

        // wind direction & speed
        JSONObject wind = (JSONObject) jsonObject.get("wind");
        windSpeed = wind.get("speed").toString();
//        System.out.println("wind speed");
        if (wind.get("deg") != null) {
            windDirection = wind.get("speed").toString();
        } else {
            windDirection = "-";
        }
//        System.out.println("wind direction");

        // rain volume
        if (jsonObject.get("rain") != null) {
            JSONObject rain = (JSONObject) jsonObject.get("rain");
            if (rain.get("3h") != null) {
                rainVolume = rain.get("3h").toString();
            } else  {
                rainVolume = "-";
            }
        } else {
            rainVolume = "-";
        }
//        System.out.println("rain volume");

        // day or night
        JSONObject sys = (JSONObject) jsonObject.get("sys");
        dayNight = (String) sys.get("pod");
//        System.out.println("day/night");

        // time & date
        String date_time = (String) jsonObject.get("dt_txt");
        String date_time_split[] = date_time.split(" ");
        String date_temp[] = date_time_split[0].split("-");
        date = date_temp[2] + "/" + date_temp[1];
//        System.out.println("date");
        String time_temp[] = date_time_split[1].split(":");
        time = time_temp[0] + ":" + time_temp[1];
//        System.out.println("time");
    }

    public String getTemperature() {
        return temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getCloudiness() {
        return cloudiness;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getRainVolume() {
        return rainVolume;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDayNight() {
        return dayNight;
    }

//    public void printAll() {
//        System.out.println("image : " + image);
//        System.out.println("description : " + description);
//        System.out.println("date : " + date);
//        System.out.println("time : " + time);
//        System.out.println("day/night : " + dayNight);
//        System.out.println("temperature : " + temperature);
//        System.out.println("pressure : " + pressure);
//        System.out.println("humidity : " + humidity);
//        System.out.println("cloudiness : " + cloudiness);
//        System.out.println("wind speed : " + windSpeed);
//        System.out.println("wind direction : " + windDirection);
//        System.out.println("rain volume : " + rainVolume);
//    }

}
