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

public class ViaCepService {
    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/%s/json/";

    public JsonObject getAddressByCep(String cep) throws Exception {
        String url = String.format(VIA_CEP_URL, cep);
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