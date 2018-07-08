package com.aeolus.utils;

public class InPath {
  private static String resource = "\\res\\";
  private static String weatherState = "\\state\\";
  private static String font = "\\font\\";
  private static String currentDir = System.getProperty("user.dir");

  static String getFontDirectory(String fontName) {
    return currentDir + resource + font + fontName + ".ttf";
  }

  public static String getResourceDirectory(String resName) {
    return currentDir + resource + resName;
  }

  public static String getWeatherStateDirectory(String stateName) {
    return currentDir + resource + weatherState + stateName + ".png";
  }
}
