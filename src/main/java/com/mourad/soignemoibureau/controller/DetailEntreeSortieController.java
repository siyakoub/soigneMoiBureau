package com.mourad.soignemoibureau.controller;

import com.mourad.soignemoibureau.model.EntreeSortieModel;
import com.mourad.soignemoibureau.model.SearchModel;
import com.mourad.soignemoibureau.service.EntreeSortieService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailEntreeSortieController implements Initializable {

    @FXML
    private TableView<SearchModel> entreeSortieModelTableView;

    @FXML
    private TableColumn<SearchModel, String> emailClient;

    @FXML
    private TableColumn<SearchModel, String> emailMedecin;

    @FXML
    private TableColumn<SearchModel, Integer> SejourId;

    @FXML
    private TableColumn<SearchModel, String> dateEntree;

    @FXML
    private TableColumn<SearchModel, String> dateSortie;

    ObservableList<SearchModel> searchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

}
