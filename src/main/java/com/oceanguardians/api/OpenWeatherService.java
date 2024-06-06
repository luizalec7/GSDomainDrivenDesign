package com.oceanguardians.api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class OpenWeatherService {
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String OPEN_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    public JsonObject getWeatherByCity(String city) throws Exception {
        String url = String.format(OPEN_WEATHER_URL, city, API_KEY);
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String jsonResponse = EntityUtils.toString(response.getEntity());
                try (JsonReader jsonReader = Json.createReader(new StringReader(jsonResponse))) {
                    return jsonReader.readObject();
                }
            }
        }
    }
}