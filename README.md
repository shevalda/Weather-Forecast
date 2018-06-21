# Aeolus

Aeolus is a simple weather forecast application made with Java Swing.

## What is an API?

Basically, an API (Application Programming Interface) is a way to interact with a program that can be understood by a human, or at least a programmer. API can be used internally among the program developer or externally with costumers. Mostly, API are used to ease communication of a program with an external resources. On the other hand, API helps controlling how external program uses their resources to prevent one external program overload.

##### [[1](https://medium.freecodecamp.org/what-is-an-api-in-english-please-b880a3214a82)][[2](https://en.wikipedia.org/wiki/Application_programming_interface)][[3](https://www.infoworld.com/article/3269878/apis/what-is-an-api-application-programming-interfaces-explained.html)]

## OpenWeatherMap API

This program uses the [OpenWeatherMap API](https://openweathermap.org/api) for information about weather of cities around the world. This program particularly uses the [Current weather data](https://openweathermap.org/current)  and [5 day / 3 hour forecast](https://openweathermap.org/forecast5) API that OpenWeatherMap provided.

### Current weather data

This API provides the current weather data of the selected city by the user. Cities can be selected by its name (and county), city id (the list of city and their id is provided [here](http://bulk.openweathermap.org/sample/)), geographic coordinates, and zip codes. The information given by the API are overall, temperature, wind, atmospheric pressure, humidity and other weather-related condition of the selected city.

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
			view
			    current
			    future
```

**lib** - libraries used by the application

**res** - resources (images) used in the application

**src/com/aeolus/app** - main java files

**src/com/aeolus/view** - java swing frames and interface for the application

**src/com/aeolus/view/current** - java swing panels for the main frame (MainFrame.java)

**src/com/aeolus/view/future** - java swing panels for the "future forecast" frame (FutureForecast.java) 

This package structure is used to categorize based on the files functionalities.

## Project Checklist

Sudah:
 - PartPanel.java
 - SearchBar.java
 - Main.java

Sedang:
 - MainFrame.java
 - ResultSection.java
 - SearchProcessor.java

Belum:
 - FutureForecastProcessor.java
 - ThreeHourForecast.java
 - FutureForecastFrame.java
 