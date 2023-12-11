package com.mourad.soignemoibureau.service;
import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;
import java.util.Map;

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
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());



            if (response.statusCode() == 200) {
                String responseBody = response.body().trim(); // Nettoyage de la réponse si nécessaire
                Type responseType = new TypeToken<Map<String, List<SejourModel>>>(){}.getType();
                Map<String, List<SejourModel>> responseMap = gson.fromJson(responseBody, responseType);
                // Log de la réponse brute pour le débogage
                System.out.println("Réponse du serveur : " + responseMap.get("Sejours"));
                return responseMap.get("Sejours");
            } else {
                System.out.println("Erreur HTTP : " + response.statusCode());
                return null;
            }
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
