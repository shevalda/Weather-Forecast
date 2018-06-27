package com.aeolus.app.holder;

public class CurrentWeather {

    private String city, country, description, image, latitude, longitude, temperature, pressure, windSpeed, windDirection, humidity, cloudiness;

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

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(String cloudiness) {
        this.cloudiness = cloudiness;
    }
}
