package com.mourad.soignemoibureau.service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mourad.soignemoibureau.model.AdminModel;

public class AdminService extends AbstractApiService {

    private HttpClient httpClient = HttpClient.newHttpClient();

    private Gson gson = new Gson();

    public AdminModel getAdminById(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "admin/admins/" + id))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            AdminModel admin = gson.fromJson(response.body(), AdminModel.class);
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AdminModel getAdminByEmail(String email) {
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "admin/admins/" + email))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            AdminModel admin = gson.fromJson(response.body(), AdminModel.class);
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AdminModel> getAllAdmins() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "admin/admins"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<AdminModel> listAdmin = gson.fromJson(response.body(), new TypeToken<List<AdminModel>>(){}.getType());
            return  listAdmin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AdminModel> getAllAdminActif() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "admin/admins/actif"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<AdminModel> listAdmin = gson.fromJson(response.body(), new TypeToken<List<AdminModel>>(){}.getType());
            return listAdmin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AdminModel> getAllAdminInactif() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "admin/admins/inactif"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<AdminModel> listAdmin = gson.fromJson(response.body(), new TypeToken<List<AdminModel>>(){}.getType());
            return listAdmin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
