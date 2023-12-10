package com.mourad.soignemoibureau.service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mourad.soignemoibureau.model.MedecinModel;

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
            MedecinModel medecin = gson.fromJson(response.body(), MedecinModel.class);
            return medecin;
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
