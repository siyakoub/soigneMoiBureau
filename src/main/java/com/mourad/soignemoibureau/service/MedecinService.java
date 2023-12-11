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
import com.mourad.soignemoibureau.model.MedecinModel;
import com.mourad.soignemoibureau.model.UserModel;

public class MedecinService extends AbstractApiService {

    private HttpClient httpClient = HttpClient.newHttpClient();

    private Gson gson = new Gson();

    public MedecinModel getMedecinById(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "medecin/medecins/" + id))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body().trim();

                // Création d'un type pour la réponse enveloppée
                Type responseType = new TypeToken<Map<String, MedecinModel>>(){}.getType();
                Map<String, MedecinModel> responseMap = gson.fromJson(responseBody, responseType);
                return responseMap.get("medecin");
            } else if (response.statusCode() == 404) {
                System.out.println("Erreur HTTP : " + response.statusCode());
                return null;
            } else {
                System.out.println("Erreur HTTP : " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MedecinModel> getAllMedecin() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/medecin/medecins"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<MedecinModel> listeMedecin = gson.fromJson(response.body(), new TypeToken<List<MedecinModel>>(){}.getType());
            return listeMedecin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MedecinModel> getAllMedecinActif() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "medecin/medecins/actif"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<MedecinModel> listMedecinActif = gson.fromJson(response.body(), new TypeToken<List<MedecinModel>>(){}.getType());
            return listMedecinActif;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MedecinModel> getAllMedecinInactif() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "medecin/medecins/inactif"))
                    .GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<MedecinModel> listeMedecinInactif = gson.fromJson(response.body(), new TypeToken<List<MedecinModel>>(){}.getType());
            return listeMedecinInactif;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public MedecinModel getMedecinByEmail(String email) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "medecin/medecins/" + email))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            MedecinModel medecin = gson.fromJson(response.body(), MedecinModel.class);
            return medecin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




}
