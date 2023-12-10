package com.mourad.soignemoibureau.service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mourad.soignemoibureau.model.SejourModel;

public class SejourService extends AbstractApiService {

    private HttpClient httpClient = HttpClient.newHttpClient();

    private Gson gson = new Gson();

    public SejourModel getSejourById(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "sejour/sejours/" + id))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            SejourModel sejour = gson.fromJson(response.body(), SejourModel.class);
            return sejour;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SejourModel> getAllSejour() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "sejour/sejours"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<SejourModel> listSejours = gson.fromJson(response.body(), new TypeToken<List<SejourModel>>(){}.getType());
            return listSejours;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteSejour(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "sejour/sejours/" + id))
                    .DELETE()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
