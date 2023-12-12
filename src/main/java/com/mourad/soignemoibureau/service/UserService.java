package com.mourad.soignemoibureau.service;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mourad.soignemoibureau.model.AdminModel;
import com.mourad.soignemoibureau.model.SejourModel;
import com.mourad.soignemoibureau.model.UserModel;
import java.lang.reflect.Type;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class UserService extends AbstractApiService {

    private HttpClient httpClient = HttpClient.newHttpClient();
    private Gson gson = new Gson();

    public UserModel getUserById(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "user/users/" + id))  // Ajout du slash manquant
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body().trim();

                // Création d'un type pour la réponse enveloppée
                Type responseType = new TypeToken<Map<String, UserModel>>(){}.getType();
                Map<String, UserModel> responseMap = gson.fromJson(responseBody, responseType);

                // Retourner l'utilisateur
                return responseMap.get("user");
            } else if (response.statusCode() == 404) {
                System.out.println("User Réponse HTTP non réussie :" + response.statusCode());
                return null;
            } else {
                System.out.println("Réponse HTTP non réussie : " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<UserModel> getAllUsers() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "user/users"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<UserModel> listUser = gson.fromJson(response.body(), new TypeToken<List<UserModel>>(){}.getType());
            return listUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserModel> getAllUsersActif() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "user/users/actif"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<UserModel> listUser = gson.fromJson(response.body(), new TypeToken<List<UserModel>>(){}.getType());
            return listUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserModel> getAllUsersInactif() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "user/users/inactif"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<UserModel> listUser = gson.fromJson(response.body(), new TypeToken<List<UserModel>>(){}.getType());
            return listUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean logout(String token) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "user/users/logout"))
                    .header("Content-Type", "application/json")
                    .header("token", token)
                    .DELETE()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                Map<String, Object> responseBody = gson.fromJson(response.body(), new TypeToken<Map<String, Object>>(){}.getType());
                Boolean isDeconnected = (Boolean) responseBody.get("deconnected");
                if (isDeconnected != null && isDeconnected) {
                    return true;
                } else {
                    return false;
                }
            } else if (response.statusCode() == 404) {
                return null;
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de connexion réseau : " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            throw new RuntimeException("La requête a été interrompue : " + e.getMessage());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de traitement JSON : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur : " + e.getMessage());
        }
    }

    public Map<String, Object> login(String email, String password) {
        try {
            String loginJson = gson.toJson(Map.of("email", email, "password", password, "userType", "Administrateur"));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "user/users/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(loginJson))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map<String, Object> responseBody = gson.fromJson(response.body(), new TypeToken<Map<String, Object>>(){}.getType());

                Boolean isConnected = (Boolean) responseBody.get("connected");
                if (isConnected != null && isConnected) {
                    return responseBody;
                } else {
                    throw new Exception("Connexion échouée, les informations de l'utilisateur ne sont pas valides.");
                }
            } else {
                // Gère d'autres codes d'état HTTP
                throw new Exception("Une erreur est survenue lors de la requête. Code d'état HTTP : " + response.statusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de connexion réseau : " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            throw new RuntimeException("La requête a été interrompue : " + e.getMessage());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de traitement JSON : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur : " + e.getMessage());
        }
    }


}
