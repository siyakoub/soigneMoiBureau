package com.mourad.soignemoibureau.model;

public class SearchModel {
    private String emailClient;
    private String emailMedecin;
    private int sejourId;
    private String dateEntre;
    private String dateSortie;

    public SearchModel() {

    }

    public SearchModel(String emailClient, String emailMedecin, int sejourId, String dateEntre, String dateSortie) {
        this.emailClient = emailClient;
        this.emailMedecin = emailMedecin;
        this.sejourId = sejourId;
        this.dateEntre = dateEntre;
        this.dateSortie = dateSortie;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getEmailMedecin() {
        return emailMedecin;
    }

    public void setEmailMedecin(String emailMedecin) {
        this.emailMedecin = emailMedecin;
    }

    public int getSejourId() {
        return sejourId;
    }

    public void setSejourId(int sejourId) {
        this.sejourId = sejourId;
    }

    public String getDateEntre() {
        return dateEntre;
    }

    public void setDateEntre(String dateEntre) {
        this.dateEntre = dateEntre;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }
}
