package com.aeolus.app.holder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ThreeHourBase {
    private String temperature, pressure, humidity, cloudiness, windSpeed, windDirection, rainVolume;
    private String image, description, date, time, dayNight;

    public ThreeHourBase(JSONObject jsonObject) {
        /*  temperature, pressure, humidity */
        JSONObject main = (JSONObject) jsonObject.get("main");
        temperature = main.get("temp").toString();
        pressure = main.get("pressure").toString();
        humidity = main.get("humidity").toString();

        /* description & image */
        JSONArray weatherArr = (JSONArray) jsonObject.get("weather");
        JSONObject weatherObj = (JSONObject) weatherArr.get(0);
        description = (String) weatherObj.get("description");
        image = (String) weatherObj.get("icon");

        /* cloudiness */
        JSONObject clouds = (JSONObject) jsonObject.get("clouds");
        cloudiness = clouds.get("all").toString();

        /* wind direction & speed */
        JSONObject wind = (JSONObject) jsonObject.get("wind");
        windSpeed = wind.get("speed").toString();
        if (wind.get("deg") != null) {
            windDirection = wind.get("speed").toString();
        } else {
            windDirection = "-";
        }

        /* rain volume */
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

        /* day or night */
        JSONObject sys = (JSONObject) jsonObject.get("sys");
        dayNight = (String) sys.get("pod");

        /* time & date */
        String date_time = (String) jsonObject.get("dt_txt");
        String date_time_split[] = date_time.split(" ");
        String date_temp[] = date_time_split[0].split("-");
        date = date_temp[2] + "/" + date_temp[1];

        String time_temp[] = date_time_split[1].split(":");
        time = time_temp[0] + ":" + time_temp[1];
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

}
