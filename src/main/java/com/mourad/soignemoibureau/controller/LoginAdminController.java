package com.mourad.soignemoibureau.controller;

import com.mourad.soignemoibureau.model.SessionData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.mourad.soignemoibureau.service.UserService;

public class LoginAdminController implements Initializable {

    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private TextField emailAdmin;

    @FXML
    private PasswordField AdPass;

    private final UserService userService = new UserService();

    @FXML
    private void login(ActionEvent event) {
        try {
            String email = emailAdmin.getText();
            String password = AdPass.getText();
            Map<String, Object> adminData = userService.login(email, password);

            if (adminData != null) {
                navigateToGestionEntreesSorties(event, adminData);
            } else {
                // Échec de la connexion
                showLoginError();
            }
        } catch (Exception e) {
            showLoginError();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            Scene scene = myAnchorPane.getScene();
            if (scene != null) {
                // Ajustez la taille initiale
                myAnchorPane.setPrefWidth(scene.getWidth() * 0.5);
                myAnchorPane.setPrefHeight(scene.getHeight());

                // Ajoutez des écouteurs pour les changements de taille
                scene.widthProperty().addListener((obs, oldVal, newVal) -> {
                    myAnchorPane.setPrefWidth(newVal.doubleValue() * 0.5);
                });
                scene.heightProperty().addListener((obs, oldVal, newVal) -> {
                    myAnchorPane.setPrefHeight(newVal.doubleValue());
                });
            }
        });

    }

    private void navigateToGestionEntreesSorties(ActionEvent event, Map<String, Object> adminData) {
        try {
            SessionData.getInstance().setAdminData(adminData);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mourad/soignemoibureau/view/GestionEntreesSorties.fxml"));
            Parent root = loader.load();
            GestionEntreesSortiesController controller = loader.getController();
            controller.setAdminData(adminData); // Transmettre les données d'administration réelles
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
