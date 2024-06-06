package com.oceanguardians.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCepAPI {
    private static final String API_URL = "https://viacep.com.br/ws/";

    public static String getAddress(String cep) throws Exception {
        URL url = new URL(API_URL + cep + "/json/");
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
