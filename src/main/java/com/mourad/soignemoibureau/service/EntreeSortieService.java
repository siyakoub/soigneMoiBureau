package com.mourad.soignemoibureau.service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mourad.soignemoibureau.model.EntreeSortieModel;

public class EntreeSortieService extends AbstractApiService {

    private HttpClient httpClient = HttpClient.newHttpClient();

    private Gson gson = new Gson();

    public EntreeSortieModel getEntreeSortieById(int id) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "entreesortie/entreessorties/" + id))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Désérialiser la réponse dans une Map
            Map<String, EntreeSortieModel> responseMap = gson.fromJson(response.body(),
                    new TypeToken<Map<String, EntreeSortieModel>>(){}.getType());

            // Extraire l'objet EntreeSortieModel
            EntreeSortieModel entreeSortie = responseMap.get("EntreeSortie");

            return entreeSortie;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<EntreeSortieModel> getAllEntreesSorties() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "entreesortie/entreessorties"))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // D'abord, désérialiser la réponse dans une Map
            Map<String, List<EntreeSortieModel>> responseMap = gson.fromJson(response.body(),
                    new TypeToken<Map<String, List<EntreeSortieModel>>>(){}.getType());

            // Ensuite, extraire la liste des entrées/sorties
            List<EntreeSortieModel> listEntreesSorties = responseMap.get("EntreesSorties");

            return listEntreesSorties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteEntreeSortie(int id) {
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "entreesortie/entreessorties/" + id))
                    .DELETE()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
