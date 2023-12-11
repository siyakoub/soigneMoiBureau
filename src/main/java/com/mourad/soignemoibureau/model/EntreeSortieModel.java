package com.mourad.soignemoibureau.model;

import com.google.gson.annotations.SerializedName;

public class EntreeSortieModel {

    @SerializedName("entresortie_id")
    private int entreesortieId;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("sejour_id")
    private int sejourId;
    @SerializedName("dateEntre")
    private String dateEntree;
    @SerializedName("dateSortie")
    private String dateSortie;

    public EntreeSortieModel() {

    }

    public EntreeSortieModel(int entreesortieId, int userId, int sejourId, String dateEntree, String dateSortie) {
        this.entreesortieId = entreesortieId;
        this.userId = userId;
        this.sejourId = sejourId;
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
    }

    public int getEntreesortieId() {
        return entreesortieId;
    }

    public int getUserId() {
        return userId;
    }

    public int getSejourId() {
        return sejourId;
    }

    public String getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(String dateEntree) {
        this.dateEntree = dateEntree;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }
}
