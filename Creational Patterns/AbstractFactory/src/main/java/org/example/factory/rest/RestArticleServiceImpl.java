package org.example.factory.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import org.example.services.IArticleService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author: Fabrizio Bolaño
 */
public class RestArticleServiceImpl implements IArticleService {
    private static final String API_URL = "https://dummyapi.online/api/products";

    @Override
    public String[] getArticles() {
        System.out.println("Service Type: Restful");
        try {
            String jsonResponse = getJsonResponse(API_URL);
            return parseProductNames(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{};
        }
    }

    private String getJsonResponse(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }

        conn.disconnect();
        return sb.toString();
    }

    private String[] parseProductNames(String jsonResponse) {
        Gson gson = new Gson();
        JsonArray data = gson.fromJson(jsonResponse, JsonArray.class);
        String[] productNames = new String[data.size()];

        for (int i = 0; i < data.size(); i++) {
            JsonObject product = data.get(i).getAsJsonObject();
            productNames[i] = product.get("name").getAsString();
        }

        return productNames;
    }
}
