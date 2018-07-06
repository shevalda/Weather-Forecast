package com.aeolus.utils;

public class InPath {
    private static String resource = "\\res\\";
    private static String weatherState = "\\state\\";
    private static String font = "\\font\\";
    private static String currentDir = System.getProperty("user.dir");

    static String getFontDirectory(String font_name) {
        return currentDir + resource + font + font_name + ".ttf";
    }

    public static String getResourceDirectory(String res_name) {
        return currentDir + resource + res_name;
    }

    public static String getWeatherStateDirectory(String state_name) {
        return currentDir + resource + weatherState + state_name + ".png";
    }
}
