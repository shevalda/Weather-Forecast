package com.aeolus.app;

import com.aeolus.utils.Api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Processor {
  private Api api = new Api();

  private String response;
  private int responseCode;

  Api getApi() {
    return api;
  }

  String getResponse() {
    return response;
  }

  public int getResponseCode() {
    return responseCode;
  }

  void createConnection(String urlString) {
    HttpURLConnection connection = null;
    try {
      URL url = new URL(urlString);
      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      responseCode = connection.getResponseCode();
      if (responseCode == HttpURLConnection.HTTP_OK) {    // connection successful
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
          sb.append(line);
        }
        br.close();
        response = sb.toString();
      } else {
        System.out.println("Response code : " + responseCode);
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }
  }

  protected abstract void readJSONResponse();
}
