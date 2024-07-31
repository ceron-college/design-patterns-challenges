package org.example.factory.ws;

import org.example.services.IEmployeeService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * Author: Fabrizio Bolaño
 */
public class WSEmployeeServiceImpl implements IEmployeeService {
    @Override
    public String[] getEmployees() {
        System.out.println("Service Type: WebServices");
        try {
            // Create HttpClient
            HttpClient client = HttpClient.newHttpClient();
            // Create HttpRequest
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://taller-factory.downloadablefox.dev/soap/employees")).build();
            // Send request asynchronously
            CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            // Get the response
            String responseBody = future.thenApply(HttpResponse::body).join();

            // Debug output of the response
            System.out.println("Response Body: " + responseBody);

            // Parse the XML response
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(responseBody.getBytes()));

            NodeList nodeList = document.getElementsByTagName("employees");
            List<String> employeesList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                employeesList.add(nodeList.item(i).getTextContent());
            }

//            // Debug output of the parsed employees
//            System.out.println("Parsed Employees: " + employeesList);

            return employeesList.toArray(new String[0]);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[]{"nothing"};
    }
}
