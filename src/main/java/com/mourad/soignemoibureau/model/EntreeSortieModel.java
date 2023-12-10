package com.mourad.soignemoibureau.model;

public class EntreeSortieModel {

    private int entreesortieId;
    private int userId;
    private int sejourId;
    private String dateEntree;
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
