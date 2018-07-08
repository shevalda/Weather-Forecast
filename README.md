# Aeolus

Aeolus is a simple weather forecast application made with Java Swing.

## What is an API?

Basically, an API (Application Programming Interface) is a way to interact with a program that can be understood by a human, or at least a programmer. API can be used internally among the program developer or externally with costumers. Mostly, API are used to ease communication of a program with an external resources. On the other hand, API helps controlling how external program uses their resources to prevent one external program overload.

##### [[1](https://medium.freecodecamp.org/what-is-an-api-in-english-please-b880a3214a82)][[2](https://en.wikipedia.org/wiki/Application_programming_interface)][[3](https://www.infoworld.com/article/3269878/apis/what-is-an-api-application-programming-interfaces-explained.html)]

## OpenWeatherMap API

This program uses the [OpenWeatherMap API](https://openweathermap.org/api) for information about weather of cities around the world. This program particularly uses the [Current weather data](https://openweathermap.org/current)  and [5 day / 3 hour forecast](https://openweathermap.org/forecast5) API that OpenWeatherMap provided.

### Current weather data

This API provides the current weather data of the selected city by the user. Cities can be selected by its name (and county), city id (the list of city and their id is provided [here](http://bulk.openweathermap.org/sample/)), geographic coordinates, and zip codes. The information given by the API are overall, temperature, wind, atmospheric pressure, humidity and other weather-related condition of the selected city.

This application uses the "Search accuracy" where the API find the closest city that matches a city name given in the request. However, the result might not so accurate and might return a response that is undesirable.

### 5 day / 3 hour forecast

This API gives us a slightly lesser information compared to Current weather data. However this API provides information for 3-hour-interval forecast for the next five days of the selected city.

OpenWeatherMap provides a free subsription of their APIs. For each free-subscription member, there is a limit of 60 calls per minute.

## Package Structure

This is the current package structure of the project

```
lib
res
src
	com
		aeolus
			app
			    holder
			utils
			view
			    current
			    future
```

**lib** - libraries used by the application

**res** - resources (images) used in the application

**src/com/aeolus/app** - main java files

**src/com/aeolus/app/holder** - java classes to store OpenWeatherMap API result

**src/com/aeolus/utils** - classes that hold utility tools for app and view package  

**src/com/aeolus/view** - java swing frames and interface for the application

**src/com/aeolus/view/current** - java swing panels for the main frame (MainFrame.java)

**src/com/aeolus/view/future** - java swing panels for the "future forecast" frame (FutureForecast.java)

This package structure is used to categorize based on the files functionalities.

## Project Checklist

Sudah:
 - PartPanel.java
 - SearchBar.java
 - Main.java
 - CurrentWeather.java
 - SearchProcessor.java
 - Api.java
 - ThreeHourForecast.java
 - FutureForecastProcessor.java
 - ForecastWeather.java
 - InFont.java
 - InPath.java
 - MainFrame.java
 - ResultSection.java
 - FutureForecastFrame.java
 - CurrentWeatherFrame.java

Sedang:
 
Belum:

## How to run

 1. Download or clone the respitory to a local respitory.
 2. Make sure you are connected to the internet. The program will not work without an internet connection and does not give a warning if you are disconnedted.
 3. Run **Weather-Forecast.jar**. Make sure the .jar file is not moved from the original folder.
 
 ## How to use
**1.** After opening the application, you will see this main menu.

![](https://github.com/shevalda/Weather-Forecast/blob/master/doc/screenshots/1a.JPG)

Type the city name you want to search. The search is not case sensitive. After you input the city, press ENTER or click the search button.

![](https://github.com/shevalda/Weather-Forecast/blob/master/doc/screenshots/1b.JPG)
    
If you search a blank text, the application will give you a reminder.

![](https://github.com/shevalda/Weather-Forecast/blob/master/doc/screenshots/1c.JPG)
  
**2.** Wait for a few seconds for the result to show. The result might show a couple of similar names. To know which city you are interested, look at the longitude and latitude of each city.

![](https://github.com/shevalda/Weather-Forecast/blob/master/doc/screenshots/2a.JPG)
    
The search might not return any cities. You might want to review whether you have input the city's name right.

![](https://github.com/shevalda/Weather-Forecast/blob/master/doc/screenshots/2b.JPG) 
    
**3.** To see the detailed weather information, click on one of the results. It will show another window containing the information.

![](https://github.com/shevalda/Weather-Forecast/blob/master/doc/screenshots/3.JPG)

**4.** To see the three-hour forecast, click on **See forecast** button. Another window will show weather informations for the next five days.

![](https://github.com/shevalda/Weather-Forecast/blob/master/doc/screenshots/4.JPG) 

## JDepend Analysis

To see the JDepend Analysis, see [here](https://github.com/shevalda/Weather-Forecast/blob/master/doc/jdepend/README.md)
