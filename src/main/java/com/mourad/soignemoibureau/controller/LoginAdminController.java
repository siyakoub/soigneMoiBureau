package com.mourad.soignemoibureau.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Map;
import com.mourad.soignemoibureau.service.UserService;

public class LoginAdminController {

    @FXML
    private TextField emailAdmin;

    @FXML
    private PasswordField AdPass;

    private UserService userService = new UserService();

    @FXML
    private void login(ActionEvent event) {
        String email = emailAdmin.getText();
        String password = AdPass.getText();

        Map<String, Object> adminData = userService.login(email, password);

        if (adminData != null) {
            // Stocker les données de l'administrateur si nécessaire
            // ...

            // Naviguer vers GestionEntreesSorties
            navigateToGestionEntreesSorties(event);
        } else {
            // Échec de la connexion
            showLoginError();
        }
    }

    private void navigateToGestionEntreesSorties(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/mourad/soignemoibureau/view/GestionEntreesSorties.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Gestion des Entrées et Sorties");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLoginError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de connexion");
        alert.setHeaderText("Échec de la connexion");
        alert.setContentText("Veuillez vérifier vos informations de connexion.");
        alert.showAndWait();
    }
}
