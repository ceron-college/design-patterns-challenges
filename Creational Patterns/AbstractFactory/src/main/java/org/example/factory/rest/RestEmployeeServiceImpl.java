package org.example.factory.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import org.example.services.IEmployeeService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author: Fabrizio Bolaño
 */
public class RestEmployeeServiceImpl implements IEmployeeService {
    private static final String API_URL = "https://dummy.restapiexample.com/api/v1/employees";

    @Override
    public String[] getEmployees() {
        System.out.println("Service Type: Restful");
        try {
            String jsonResponse = getJsonResponse(API_URL);
            return parseEmployeeNames(jsonResponse);
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

    private String[] parseEmployeeNames(String jsonResponse) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
        JsonArray data = jsonObject.getAsJsonArray("data");
        String[] employeeNames = new String[data.size()];

        for (int i = 0; i < data.size(); i++) {
            JsonObject employee = data.get(i).getAsJsonObject();
            employeeNames[i] = employee.get("employee_name").getAsString();
        }

        return employeeNames;
    }
}
