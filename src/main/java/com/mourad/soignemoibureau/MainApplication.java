package com.mourad.soignemoibureau;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger le fichier FXML pour la vue LoginAdmin
            Parent root = FXMLLoader.load(getClass().getResource("/com/mourad/soignemoibureau/view/LoginAdmin.fxml"));


            // Créer et configurer la scène
            Scene scene = new Scene(root);

            // Configurer le stage principal
            primaryStage.setTitle("Connexion Administrateur");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
