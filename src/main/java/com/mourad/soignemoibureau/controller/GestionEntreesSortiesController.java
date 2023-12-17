package com.mourad.soignemoibureau.controller;

import com.mourad.soignemoibureau.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.mourad.soignemoibureau.service.UserService;
import com.mourad.soignemoibureau.service.MedecinService;
import com.mourad.soignemoibureau.service.SejourService;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class GestionEntreesSortiesController implements Initializable {

    private Map<String, Object> adminData;

    @FXML
    public TableColumn<SearchModel, String> emailClient;

    @FXML
    public TableColumn<SearchModel, String> emailMedecin;

    @FXML
    public TableColumn<SearchModel, Integer> sejourId;
    @FXML
    public TableColumn<SearchModel, String> dateHeureDebut;

    @FXML
    public TableColumn<SearchModel, String> dateHeureFin;
    @FXML
    public TableView<SearchModel> tableEntreeSortieid;

    @FXML
    public TextField searchPlainText;
    @FXML
    public Button logoutButtonId;

    private UserService userService = new UserService();

    ObservableList<SearchModel> searchModelObservableList = FXCollections.observableArrayList();

    public void setAdminData(Map<String, Object> adminData) {
        this.adminData = adminData;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SejourService sejourService = new SejourService();
        UserService userService = new UserService();
        MedecinService medecinService = new MedecinService();

        List<SejourModel> sejours = sejourService.getAllSejour();
        if (sejours != null) {
            for (SejourModel sejour : sejours) {
                // Récupération des informations utilisateur et médecin
                UserModel userInfo = userService.getUserById(sejour.getUserId());
                MedecinModel medecinInfo = medecinService.getMedecinById(sejour.getMedecinId());

                // Vérifiez que userInfo et medecinInfo ne sont pas null avant de les utiliser
                if (medecinInfo != null) {
                    // Création de l'objet SearchModel
                    SearchModel searchModel = new SearchModel();
                    searchModel.setEmailClient(userInfo.getUserEmail());
                    searchModel.setEmailMedecin(medecinInfo.getUserEmail());
                    searchModel.setSejourId(sejour.getSejourId());
                    searchModel.setDateEntre(sejour.getDateDebut());
                    searchModel.setDateSortie(sejour.getDateFin());
                    // ... autres paramètres ...

                    // Ajout à l'ObservableList
                    searchModelObservableList.add(searchModel);
                }
            }
            emailClient.setCellValueFactory(new PropertyValueFactory<>("emailClient"));
            emailMedecin.setCellValueFactory(new PropertyValueFactory<>("emailMedecin"));
            sejourId.setCellValueFactory(new PropertyValueFactory<>("sejourId"));
            dateHeureDebut.setCellValueFactory(new PropertyValueFactory<>("dateEntre"));
            dateHeureFin.setCellValueFactory(new PropertyValueFactory<>("dateSortie"));
            // Associez l'ObservableList au TableView
            tableEntreeSortieid.setItems(searchModelObservableList);
        }
    }

    @FXML
    public void logout(ActionEvent event) {
        try {
            if (adminData != null){
                String token = (String)((Map<String, Object>) adminData.get("sessions")).get("token");
                Boolean isDeconnected = userService.logout(token);
                if (isDeconnected != null && isDeconnected) {
                    navigateToLoginAdmin(event);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void navigateToLoginAdmin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mourad/soignemoibureau/view/LoginAdmin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Page Connexion");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
