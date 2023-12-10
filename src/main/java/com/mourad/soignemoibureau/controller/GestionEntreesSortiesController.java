package com.mourad.soignemoibureau.controller;

import com.mourad.soignemoibureau.model.MedecinModel;
import com.mourad.soignemoibureau.model.SearchModel;
import com.mourad.soignemoibureau.model.SejourModel;
import com.mourad.soignemoibureau.model.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.mourad.soignemoibureau.service.UserService;
import com.mourad.soignemoibureau.service.MedecinService;
import com.mourad.soignemoibureau.service.SejourService;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class GestionEntreesSortiesController implements Initializable {

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
                if (userInfo != null && medecinInfo != null) {
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

            // Associez l'ObservableList au TableView
            tableEntreeSortieid.setItems(searchModelObservableList);
        }
    }



}
