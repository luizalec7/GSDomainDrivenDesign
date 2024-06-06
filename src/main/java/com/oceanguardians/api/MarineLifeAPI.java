package com.oceanguardians.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MarineLifeAPI {
    private static final String API_URL = "https://example-marine-life-api.com/";

    public static String getMarineLifeInfo(String query) throws Exception {
        URL url = new URL(API_URL + "search?q=" + query);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

        return content.toString();
    }
}